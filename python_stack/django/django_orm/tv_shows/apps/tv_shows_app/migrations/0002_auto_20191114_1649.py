# -*- coding: utf-8 -*-
# Generated by Django 1.10 on 2019-11-15 00:49
from __future__ import unicode_literals

from django.db import migrations, models
import django.utils.timezone


class Migration(migrations.Migration):

    dependencies = [
        ('tv_shows_app', '0001_initial'),
    ]

    operations = [
        migrations.RenameField(
            model_name='shows',
            old_name='actions',
            new_name='description',
        ),
        migrations.AddField(
            model_name='shows',
            name='created_at',
            field=models.DateTimeField(auto_now_add=True, default=django.utils.timezone.now),
            preserve_default=False,
        ),
        migrations.AddField(
            model_name='shows',
            name='release_date',
            field=models.DateTimeField(null=True),
        ),
        migrations.AddField(
            model_name='shows',
            name='updated_at',
            field=models.DateTimeField(auto_now=True),
        ),
    ]