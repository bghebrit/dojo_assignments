from django.conf.urls import url
from . import views


urlpatterns = [
    url(r'^$',views.index),
    url(r'^register', views.register),
    url(r'^login', views.login),
    url(r'^home', views.success),
    url(r'^logout', views.logout),
]


    