# -*- coding: utf-8 -*-
# Generated by Django 1.10 on 2019-11-14 23:33
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='shows',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('title', models.CharField(max_length=255)),
                ('network', models.CharField(max_length=255)),
                ('actions', models.CharField(max_length=255)),
            ],
        ),
    ]
