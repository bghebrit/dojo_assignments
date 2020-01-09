from django.shortcuts import render , redirect
from django.contrib import messages

from .models import *

# Create your views here.

def index(request):
    return render(request, 'trip_buddy_app/index.html')

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
        request.session['user_name'] = user.first_name
        return redirect('/dashboard')

def login(request):
    errors = User.objects.loginvalidate(request.POST)

    if errors:
        for key in errors:
            messages.error(request, errors[key])
        return redirect('/')

    else :
        user = User.objects.get(email = request.POST['email'])
        request.session['user_id'] = user.id
        request.session['user_name'] = user.first_name
        return redirect('/dashboard')

def success(request):
    if 'user_id' not in request.session:
        return redirect('/')
    return render(request , 'trip_buddy_app/success.html')

def logout(request):
    request.session.clear()
    return redirect('/')

def dash(request):
    context = {
        'all_trips' : Trip.objects.all()
    }
    return render(request , 'trip_buddy_app/dashboard.html',context)

def createtrip(request):
    return render( request, 'trip_buddy_app/trips.html')

def addTrip(request):
    # errors = Trip.objects.trip_validate(request.POST)
    
    # if errors:
    #     for key in errors:
    #         messages.error(request, errors[key])
    #     return redirect('/trips/new')

    if request.method == "GET":
        return render(request,'trip_buddy_app/trips.html')

    if request.method == "POST":
        print(request.POST)

        planner = User.objects.get(id = request.session['user_id'])
        dest = request.POST['destination']
        plan = request.POST['plan']
        sdate = request.POST['start_date']
        edate = request.POST['end_date']
        Trip.objects.create(destination = dest, plan = plan, start_date= sdate, end_date= edate, created_by = planner )
        return redirect('/dashboard')


