# -*- coding: utf-8 -*-
# Generated by Django 1.10 on 2019-11-19 19:46
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('dojo_ninja_app', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='dojo',
            name='state',
            field=models.CharField(max_length=255, null=True),
        ),
    ]
