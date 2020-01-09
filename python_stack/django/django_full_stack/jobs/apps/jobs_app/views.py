from django.shortcuts import render , redirect
from django.contrib import messages

from .models import *

def index(request):
    return render(request, 'jobs_app/index.html')

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
        request.session['user_id'] = True
        request.session['user_name'] = user.first_name
        return redirect('/dashboard')

#def success(request):
    #if 'user_id' not in request.session:
        #return redirect('/')
    #return render(request , 'jobs_app/success.html')

def logout(request):
    request.session.clear()
    return redirect('/')

def dashboard(request):
    if 'user_id' in request.session:
        context = {
            'all_jobs':Job.objects.all()
        }
        return render(request,'jobs_app/dashboard.html', context)
    else:
        messages.error(request, 'the user is not recognized pls login')
        return redirect('/')

def createjob(request):
    return render(request,'jobs_app/createjob.html')

def addjob(request):
    errors = Job.objects.job_validate(request.POST)

    if len(errors) > 0:
        for key , value in errors.items():
            messages.error(request, value)
        return redirect('/createjob')
    else:
        employee = User.objects.get(id=request.session['user_id'])
        job = request.POST['job']
        title = request.POST['title']
        desc = request.POST['desc']
        location = request.POST['location']
        Job.objects.create(job=job,title=title,desc=desc,location=location,employee=employee)
        return redirect('/dashboard')

def editjob(request, job_id):
    if request.method == "GET":
        all_jobs = {
            'job':Job.objects.get(id = job_id)
        }
        return render(request, 'jobs_app/edit.html', all_jobs)
    if request.method == 'POST':
        errors = Job.objects.job_validate(request.POST)
        if len(errors) > 0 :
            for key , value in errors.items():
                messages.error(request, value)
            return redirect('/jobs/edit/'+job_id)
        else:
            job = Job.objects.get(id=job_id)
            job.job = request.POST['job']
            job.title = request.POST['title']
            job.desc = request.POST['desc']
            job.location = request.POST['location']
            job.save()
            return redirect('/dashboard')

def jobdetails(request, job_id):
    all_jobs = {
        'job' : Job.objects.get(id=job_id)
    }
    return render(request,'jobs_app/jobdetails.html',all_jobs)


def deletejob(request, job_id):
    job = Job.objects.get(id=job_id)
    job.delete()
    return redirect('/dashboard')

def cancel(request):
    return redirect('/dashboard')