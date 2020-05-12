import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { map } from 'rxjs/operators'

import { API_URL } from '../../app.constants';

export const TOKEN = 'token'
export const AUTHENTICATED_USER = 'authenticatedUser'


@Injectable({
  providedIn: 'root'
})

export class BasicAuthenticationService {
  constructor(private http: HttpClient) { }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(AUTHENTICATED_USER );
    return !(user === null)
  }

  Logout() {
    sessionStorage.removeItem(AUTHENTICATED_USER);
    sessionStorage.removeItem(TOKEN);
  }

  getAuthenticatedUser() {
    return sessionStorage.getItem(AUTHENTICATED_USER);
  }
  getAuthenticatedToken() {
    if (this.getAuthenticatedUser()) {
      return sessionStorage.getItem(TOKEN);
    }
  }

  executeAuthorizationService(userName: string, password: string) {

    let basicAuthenticationString = this.CreateBasicAuthenticationhttpHeader(userName, password);
    let myHeaders = new HttpHeaders({
      Authorization: basicAuthenticationString
    })
    console.log('after create header ')
    console.log('url  :  ' + API_URL + "/basicauth")
    console.log('username :   ' + userName)
    console.log('password :   ' + password)
    console.log('basinc auth string :   ' + basicAuthenticationString)
    console.log(myHeaders)

    return this.http.get<AuthenticationBean>(API_URL + "/basicauth", { headers: myHeaders })
      .pipe(
        map(
          data => {
            sessionStorage.setItem(AUTHENTICATED_USER, userName)
            sessionStorage.setItem(TOKEN, basicAuthenticationString)
            return data;
          }
        )

      );

  }

  CreateBasicAuthenticationhttpHeader(userName: string, password: string) {

    let basicAuthenticationString = 'Basic ' + window.btoa(userName + ':' + password);
    console.log("basicAuthenticationString" + basicAuthenticationString)
    return basicAuthenticationString;

  }

}

export class AuthenticationBean {
  constructor(public message: string) { }
}