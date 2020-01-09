from django.shortcuts import render , redirect
from django.utils.crypto import get_random_string 

def index(request):
    random_string = get_random_string(length=14)
    data = {
        'random_str' : random_string
    }
    if 'counter' not in request.session:
        request.session['counter'] = 1
    else:
        request.session['counter'] += 1

    return render(request, 'word_app/index.html',data)
    #request.session['name'] = request.POST['name']
    #request.session['counter'] = 100 

def random_method(request):
    
    return redirect('/')

# Create your views here.
