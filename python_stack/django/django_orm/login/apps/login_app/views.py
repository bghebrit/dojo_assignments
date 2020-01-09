from django.shortcuts import render , redirect 
from django.contrib import messages

from .models import *


def index(request):
    return render(request, 'login_app/index.html')

    #else:
        #user = User.objects.get(id = 'id')
        #user.first_name = request.POST['first_name']
        #user.last_name = request.POST['last_name']
        #user.save()
        #messages.success(request, "User successfully updated")
        #return redirect('/success')

    #return render(request , 'login_app/index.html')

def register(request):
    errors = User.objects.basic_validator(request.POST)

    if errors:
        for key , value in errors.items():
            messages.error(request, value)
        return redirect('/')

    else:
        first_name = request.POST['first_name']
        last_name = request.POST['last_name']
        email = request.POST['email']
        dob = request.POST['dob']
        password = request.POST['password']
        #hashed password
        hashed_pw = bcrypt.hashpw(password.encode(),bcrypt.gensalt())

        user = User.objects.create(first_name=first_name,last_name=last_name,email=email,dob=dob,password=hashed_pw)
        request.session['user_id'] = user.id
        return redirect('/home')

def login(request):
    errors = User.objects.loginvalidate(request.POST)

    if errors:
        for key , value in errors.items():
            messages.error(request, value)
        return redirect('/')

    else :
        user = User.objects.get(email = request.POST['email'])
        request.session['user_id'] = user.id
        return redirect('/success')

def success(request):
    if 'user_id' not in request.session:
        return redirect('/')
    return render(request , 'login_app/success.html')

def logout(request):
    request.session.clear()
    return redirect('/')

    #return render(request, 'login_app/success.html')

# Create your views here.
