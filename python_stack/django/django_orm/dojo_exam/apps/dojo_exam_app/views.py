from django.shortcuts import render , redirect
from django.contrib import messages
import bcrypt
from .models import *



def index(request):
    return render(request ,'dojo_exam_app/index.html')

    #Registration Views
def register(request):
    errors = User.objects.register_validate(request.POST)

    if errors:
        for key, value in errors.items():
            messages.error(request, value)
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

    #LoginViews
def login(request):
    errors = User.objects.login_validate(request.POST)

    if errors:
        for key , value in errors.items():
            messages.error(request, value)
        return redirect('/')
    else:
        user = User.objects.get(email=request.POST['email'])
        request.session['user_id'] = user.id
        return redirect('/success')

#Success Views
def success(request):
    if 'user_id' not in request.session:
        return redirect('/')
    return render(request, 'dojo_exam_app/success.html')

#logout views
def logout(request):
    request.session.clear()
    return redirect("/")





    

    

# Create your views here.
