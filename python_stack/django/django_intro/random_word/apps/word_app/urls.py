from django.conf.urls import url
from . import views

urlpatterns = [
    
    url(r'^$', views.index),
    url(r'^random$',views.random_method)
#url(r'^/time_display$', views.time_display),
]