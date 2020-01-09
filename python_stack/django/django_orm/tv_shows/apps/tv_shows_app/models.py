from django.db import models

class shows(models.Model):
    title = models.CharField(max_length=255)
    network = models.CharField(max_length=255)
    released_at = models.DateField(null=True, auto_now_add=False,auto_now=False)
    description = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
# Create your models here.
