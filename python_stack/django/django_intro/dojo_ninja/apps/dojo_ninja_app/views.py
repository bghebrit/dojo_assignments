from django.shortcuts import render , redirect
from .models import *

# Create your views here.

def index(request):
    #grab all the dojos/databasecall
    context ={
        'all_dojos' : Dojo.objects.all()
    }
    return render(request, 'dojo_ninja_app/index.html',context)

def addNinja(request):
    if request.method == 'GET':
        context ={
            'all_dojos' : Dojo.objects.all()
        }
        return render(request, 'dojo_ninja_app/newNinja.html', context )
    if request.method == 'POST':
        print(request.POST)
        dojo_to_add = Dojo.objects.get(id=request.POST['dojo'])
        Ninja.objects.create(first_name=request.POST['first_name'],last_name=request.POST['last_name'],dojo=dojo_to_add)

        return redirect('/addNinja')

def createNinja(request):
    name = request.POST['name']
    city = request.POST['city']
    state = request.POST['state']
    Dojo.objects.create(name=name,city=city,state=state)

    return redirect('/')

def deleteDojo(request, dojo_id):
    dojo_to_delete = Dojo.objects.get(id=dojo_id)
    dojo_to_delete.delete()

    return redirect('/')