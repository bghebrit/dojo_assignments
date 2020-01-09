from django.shortcuts import render , HttpResponse , redirect
def index(request):
    return HttpResponse("placeholder to display a new form to create a new blog")

def new(request):
    return HttpResponse("place holder to display another form correct")

def create(request):
    return redirect("/")

def show(request , my_val , color):
    return HttpResponse(f"placeholder to display blog number {my_val}",color)

def edit(request , my_val):
    return HttpResponse(f"placeholder to display blog number {my_val}")

def destroy(request , my_val):
    return redirect('/')

      

# Create your views here.
