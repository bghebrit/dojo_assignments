# Create your views here.

from django.shortcuts import render , redirect 
from django.contrib import messages

from .models import *

def index(request):
    return render(request, 'coffee_app/index.html')

