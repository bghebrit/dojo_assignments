from django.shortcuts import render , redirect
from .models import *

def index(request):
    if request.method == 'GET':

        return render(request , 'tv_shows_app/index.html')

    if request.method == "POST":
        title=request.POST['title']
        network=request.POST['network']
        release_date=request.POST['release_date']
        print(release_date)
        desc=request.POST['desc']
        shows.objects.create(title=title , network=network , released_at=release_date , description=desc)
        return redirect('/')

def showsread(request):
    context = {
        "all_shows": shows.objects.all()
    }
    print(shows.objects.all().values())
    return render(request,'tv_shows_app/shows.html',context)

def readone(request,shows_id):
    context = {
        "show": shows.objects.get(id=shows_id)
    }
    return render(request,'tv_shows_app/read.html',context)

def edit(request,shows_id):
    if request.method=="GET":
        context = {
        "show" : shows.objects.get(id=shows_id)
    }
        return render(request,'tv_shows_app/update.html',context)
    if request.method=="POST":
        show = shows.objects.get(id=shows_id)
        show.title = request.POST['title']
        show.network = request.POST['network']
        show.release_date = request.POST['release_date']
        show.desc = request.POST['desc']
        show.save()
        return redirect('/readone/shows_id')



#def shows_create(request,shows_id):



# Create your views here.
