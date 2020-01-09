from django.db import models
import re 
import bcrypt
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

#User Manager 

class UserManager(models.Manager):
    def validate(self, postData):
        error = {}
        # First and Last name should be atleast2 characters
        if len(postData['first_name']) < 3:
            error["first_name"] = "User name should be at least 2 characters"
        if not postData['first_name'].isalpha():
            error["first_name"] = "User name should only be alphabets"
        if len(postData['last_name']) < 3:
            error["last_name"] = "User should be at least 2 characters"

        # Email should be valid(1.email should match ReGex and 2.email should be unique)
        if not EMAIL_REGEX.match(postData['email']):
            error['email'] = 'Your email must be in Valid format'
        if User.objects.filter(email=postData['email']):
            error['emailused'] = 'Your email is already registered'

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
            error['login-email'] = 'email doesnot exist with in db'
            return error
        else:
            if bcrypt.checkpw(postData['password'].encode(),user[0].password.encode()):
                pass
            else:
                error['password'] ='your credentials do not match'
            return error

class TripManager(models.Manager):
    def trip_validate(self, postData):
        error = {}
        #destination must be provided
        if len(postData['destination']) < 2:
            error["destination"] = "destination must be provided"
        if len(postData['plan']) < 1:
            error["plan"] = "plan must be provided"
        if len(postData['start_date']) < 1:
            error["start_date"] = "start_date must be provided"
        if len(postData['end_date']) < 1:
            error["end_date"] = "end_date must be provided"



# Create your models here.
class User(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.CharField(max_length=255)
    password = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = UserManager()


class Trip(models.Model):
    destination = models.CharField(max_length=255)
    start_date = models.DateField(auto_now=False,auto_now_add=False)
    end_date = models.DateField(auto_now=False,auto_now_add=False)
    plan = models.CharField(max_length=255)
    created_by = models.ForeignKey(User,related_name='trips')
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = TripManager()

