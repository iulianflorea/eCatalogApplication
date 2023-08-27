import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CredetialsInterceptorService implements HttpInterceptor {

  constructor() { }

intercept(req : HttpRequest<any>,next :HttpHandler): Observable<HttpEvent<any>>{

  var email = localStorage.getItem("loggedInUserEmail");
  var pass = localStorage.getItem("loggedInUserPass");

  if(email != null && pass != null) {
    var authData = window.btoa(email + ":" + pass);
    // Authorization username:password
      const reqWithAuth = req.clone(
        {headers: req.headers.set('Authorization', 'Basic ' + authData)}
        );
      return next.handle(reqWithAuth);
  }

  return next.handle(req);

}

}
