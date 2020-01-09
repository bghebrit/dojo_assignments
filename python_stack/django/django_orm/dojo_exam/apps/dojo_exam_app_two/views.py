from django.shortcuts import render , redirect
from django.contrib import messages
from .models import *



""" def dashboard(request, users_id):
    context = {
        "all_trips": Trip.objects.all()
   }
    contex_user ={
        "all_user" : User.objects.get(id=users_id)
    }
    return render(request, 'dojo_exam_app/dashboard.html',context,contex_user """)

def createtrips(request):
        context =   {
        "all_trips": Trip.objects.all()
    }
    return render(request, 'dojo_exam_app/viewtrips.html',context)
    
    if request.method == "POST":
        destination = request.POST['destination']
        start_date=request.POST['start_date']
        end_date=request.POST['end_date']
        plan=request.POST['plan']
        users = User.objects.get(id=request.POST['User'])
        Trip.objects.create(destination=destination,start_date=start_date,end_date=end_date,plan=plan,users=users)
        return redirect('/dashboard')

""" def edittrips(request,trip_id):
    if request.method =="GET":
        context = {
            "trip" : Trip.objects.get(id=trip_id)
        }
        return render(request,'dojo_exam_app/edit.html',context)
    if request.method=="POST":
        trip = Trip.objects.get(id=trip_id)
        trip.destination=request.POST['destination']
        trip.start_date=request.POST['start_date']
        trip.end_date=request.POST['end_date']
        trip.plan=request.POST['plan']
        trip.users=request.POST['users']
        trip.save()
        return redirect('edittrips/trip_id')

def viewtrips(request,trip_id):
    return render(request,'dojo_exam_app/viewtrip.html') """

# Create your views here.
