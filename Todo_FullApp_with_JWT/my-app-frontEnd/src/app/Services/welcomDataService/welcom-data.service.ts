import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { API_URL } from 'src/app/app.constants';

@Injectable({
  providedIn: 'root'
})

export class WelcomDataService {
  constructor(
     private http: HttpClient
    ){}

  executeHelloWorldBeanService() {
    // let myHeaders = new HttpHeaders({
    //   Authorization: this.CreateBasicAuthenticationhttpHeader()
    // })
    return this.http.get<helloWorldBean>( API_URL + "/api/v1/test");
  }

  // CreateBasicAuthenticationhttpHeader() {
  //   let userName = 'monna'
  //   let password = 'monna'
  //   let basicAuthenticationString = 'Basic ' + window.btoa(userName + ':' + password);
  //   console.log("basicAuthenticationString" + basicAuthenticationString)
  //   return basicAuthenticationString;
  // }
}

export class helloWorldBean {
  constructor(public message: string) { }
}