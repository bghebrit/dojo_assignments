from django.shortcuts import render , redirect 
from django.contrib import messages

from .models import *

# Create your views here.

def index(request):
    return render(request, 'dojo_test_app/index.html')

def register(request):
    errors = User.objects.validate(request.POST)

    if errors:
        for key in errors:
            messages.error(request, errors[key])
        return redirect('/')

    else:
        first_name = request.POST['first_name']
        last_name = request.POST['last_name']
        email = request.POST['email']
        password = request.POST['password']
        #hashed password
        hashed_pw = bcrypt.hashpw(password.encode(),bcrypt.gensalt())

        user = User.objects.create(first_name=first_name,last_name=last_name,email=email,password=hashed_pw)
        request.session['user_id'] = user.id
        return redirect('/success')

def login(request):
    errors = User.objects.loginvalidate(request.POST)

    if errors:
        for key in errors:
            messages.error(request, errors[key])
        return redirect('/')

    else :
        user = User.objects.get(email = request.POST['email'])
        request.session['user_id'] = user.id
        return redirect('/success')

def success(request):
    if 'user_id' not in request.session:
        return redirect('/')
    return render(request , 'dojo_test_app/success.html')

def logout(request):
    request.session.clear()
    return redirect('/')
