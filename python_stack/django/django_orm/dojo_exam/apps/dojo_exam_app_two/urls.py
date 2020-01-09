from django.conf.urls import url
from . import views

urlpatterns = [
    #url(r'^dashboard', views.dashboard),
    url(r'^createtrips', views.createtrips), 
    #url(r'^edittrips/(?P<trip_id>\d+)',views.edittrips),
    #url(r'^viewtrips/(?P<trip_id>\d+)', views.viewtrips),
]