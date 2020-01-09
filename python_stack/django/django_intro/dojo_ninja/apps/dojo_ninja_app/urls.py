from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$',views.index),
    url(r'^addNinja', views.addNinja),
    url(r'^createNinja',views.createNinja),
    url(r'^deleteDojo/(?P<dojo_id>\d+)', views.deleteDojo),
]