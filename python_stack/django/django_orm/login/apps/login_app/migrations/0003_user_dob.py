# -*- coding: utf-8 -*-
# Generated by Django 1.10 on 2019-11-17 06:37
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('login_app', '0002_auto_20191116_2031'),
    ]

    operations = [
        migrations.AddField(
            model_name='user',
            name='dob',
            field=models.DateTimeField(null=True),
        ),
    ]
