from django.conf.urls import url
from . import views


urlpatterns = [
    url(r'^$', views.index),
    url(r'^register$',views.register),
    url(r'^login$', views.login),
    #url(r'^success',views.success),
    url(r'^logout$', views.logout),

    #*********************************
    url(r'^dashboard$',views.dashboard),
    url(r'^createjob$', views.createjob),
    url(r'^jobs/new$', views.addjob),
    url(r'^jobs/edit/(?P<job_id>\d+)$',views.editjob),
    url(r'^jobs/(?P<job_id>\d+)/delete$',views.deletejob),
    url(r'^jobs/(?P<job_id>\d+)$',views.jobdetails),
    url(r'^back' , views.cancel),

]