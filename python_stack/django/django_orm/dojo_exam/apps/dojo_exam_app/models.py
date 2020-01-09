from django.db import models
import re 
import bcrypt

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')


class UserManager(models.Manager):
    def register_validate(self,postData):
        error={}
        # First and Last name should atleast be 3 characters
        if len(postData['first_name']) < 4:
            error['first_name'] = 'User name should be atleast 3 characters'
        if not postData['first_name'].isalpha():
            error['first_name']="User name should only be alphabets"
        if len(postData['last_name']) < 4:
            error['last_name'] = 'User should be atleast 3 characters'

        #Email should be valid (email should match ReGex and email should be unique)
        if not EMAIL_REGEX.match(postData['email']):
            error['email'] = 'Your email must be in valid format'
        if User.objects.filter(email=postData['email']):
            error['emailreg'] = 'Your email is already registered'

        #Password should match and be atleast 8 characters
        if len(postData['password']) < 8:
            error['password'] = 'Your password must be longer than 8 char'
        if postData['password'] != postData['c_password']:
            error['passwordmatch'] = 'Your password and confirm password dont match'
        return error

    def login_validate(self,postData):
        error = {}
        #validate with ReGex and check for email in db
        if not EMAIL_REGEX.match(postData['email']):
            error['email'] = 'Your email must be in valid format'

        #check if password provided matches the password in db
        user = User.objects.filter(email=postData['email'])
        if not user:
            error['loginemail'] = 'email doesnot exist with in db'
            return error
        else:
            if bcrypt.checkpw(postData['password'].encode(), User[0].password.encode()):
                pass
            else:
                error['password'] = 'Your password does not match'
            return error


      

class User(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.CharField(max_length=255)
    password = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = UserManager()





# Create your models here.
