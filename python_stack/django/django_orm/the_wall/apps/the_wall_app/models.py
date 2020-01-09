from django.db import models


class User(models.Model):
    first_name = models.Charfield(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.CharField(max_length=255)
    password = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

class Message(models.Model):
    comment_content = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    message = models.ForeignKey(User, related_name='messages')



class Comment(models.Model):
    comment_content = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    message = models.ForeignKey(Message, related_name='comments')
    user = models.ForeignKey(User, related_name='comments')



# Create your models here.
