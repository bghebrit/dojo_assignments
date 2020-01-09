from django.shortcuts import render , redirect
from apps.book_authors_app.models import *

def index(request):
    context = {
            "all_books": book.objects.all()
        }
    print(book.objects.all().values())
    return render(request, "book_authors_app/index.html", context)

def booksone(request):
    title = request.POST['title']
    description = request.POST['description']
    book.objects.create(title=title, description=description)
    return redirect("/")

def books(request, book_id):
    if request.method=="GET":
        context = {
            "book_info": book.objects.get(id=book_id),
            "authors": author.objects.all()
        }
        return render(request, "book_authors_app/book.html", context)
    if request.method=="POST":
        print(request.POST)
        this_book = book.objects.get(id=request.POST['books'])
        first_name=request.POST['first_name']
        last_name=request.POST['last_name']
        author.objects.create(first_name=first_name,last_name=last_name,books=this_book)
        return redirect("/")



# Create your views here.
