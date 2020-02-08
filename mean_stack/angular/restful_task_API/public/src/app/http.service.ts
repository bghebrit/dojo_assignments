import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private _http: HttpClient) { 
    this.getTasks();
    this.getOneTask();
  }
  getTasks(){
    let tempObservable = this._http.get('/tasks');
    tempObservable.subscribe(data => console.log("Got our tasks!" , data));
  }
  getOneTask(){
    let tempObservable = this._http.get('/view/5e274ecc97fba717588b8d1d');
    console.log("hitting this route")
    tempObservable.subscribe(data => {
      console.log("viewing one task!", data);
    })
  }
}
