# -*- coding: utf-8 -*-
# Generated by Django 1.10 on 2019-11-19 22:20
from __future__ import unicode_literals

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('dojo_exam_app', '0004_auto_20191118_1624'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='trip',
            name='users',
        ),
        migrations.DeleteModel(
            name='Trip',
        ),
    ]