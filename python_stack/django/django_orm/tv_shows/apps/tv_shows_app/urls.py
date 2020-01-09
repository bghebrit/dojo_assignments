from django.conf.urls import url
from . import views

urlpatterns =[
    url(r'^$',views.index),
    url(r'^showsread$', views.showsread),
    url(r'^readone/(?P<shows_id>\d+)$', views.readone),
    url(r'^update/(?P<shows_id>\d+)/edit$', views.edit),
    #url(r'^shows/create$', views.shows_create),
    #url(r'^showsr/(?P<shows_id>\d+)$', views.shows_r),

]