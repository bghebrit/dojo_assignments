from django.db import models
import re 
import bcrypt
from datetime import date
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

now = date.today().isoformat()


class UserManager(models.Manager):
    def basic_validator(self, postData):
        error = {}
        # First and Last name should be atleast2 characters
        if len(postData['first_name']) < 3:
            error["first_name"] = "User name should be at least 2 characters"
        if not postData['first_name'].isalpha():
            error["first_name"] = "User name should only be alphabets"
        if len(postData['last_name']) < 3:
            error["last_name"] = "User should be at least 2 characters"

        #check if dob is previous to to today
        if len(postData['dob']) < 1:
            error['dob'] = "enter your dob"
        if postData['dob'] < now:
            error['dob'] = "your birthday must be before today"

        # Email should be valid(1.email should match ReGex and 2.email should be unique)
        if not EMAIL_REGEX.match(postData['email']):
            error['email'] = 'Your email must be in Valid format'
        if User.objects.filter(email=postData['email']):
            error['emaildupe'] = 'Your email is already registered'

        # Password should match and be atleast 8 characters
        if len(postData['password']) < 8:
            error['password'] = 'Your password must be longer than 8 characters'
        if postData['password'] != postData['c_password']:
            error['passwordmatch'] = 'Your password and confirm password dont match'
        return error

    def loginvalidate(self, postData):
        error = {}
        #validate with regex and check for email in db
        if not EMAIL_REGEX.match(postData['email']):
            error['email'] = 'Your email must be in valid format'

        #check if password given matches the password in db
        user = User.objects.filter(email=postData['email'])
        if not user:
            error['loginemail'] = 'email doesnot exist with in db'
            return error
        else:
            if bcrypt.checkpw(postData['password'].encode(),User[0].password.encode()):
                pass
            else:
                error['password'] ='your credentials do not match'
            return error


class User(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.CharField(max_length=255)
    dob = models.DateTimeField(auto_now_add=False,auto_now=False,null=True)
    Password = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = UserManager() 

# Create your models here.
