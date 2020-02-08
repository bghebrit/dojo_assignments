import { Component, OnInit } from '@angular/core';
import { HttpService } from './http.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  constructor(private _httpService: HttpService) { }
  tasks = [];
  onetask = [];

  ngOnInit() {
    this.getTasksFromService();
    this.getOneTasksFromService();
    
  }
  getTasksFromService() {
    let observable = this._httpService.getTasks();
    observable.subscribe(data => {
      console.log("Got our tasks!", data)
      this.tasks = data['tasks'];
    });
  }
  getOneTasksFromService() {
    let observable = this._httpService.getOneTask('5e2770b574aaa4375421272a');
    observable.subscribe(data => {
      console.log("Got one task!", data)
      this.onetask = [data];
    });
  }
}