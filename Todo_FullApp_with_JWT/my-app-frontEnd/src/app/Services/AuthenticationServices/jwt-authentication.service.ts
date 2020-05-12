import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { map } from 'rxjs/operators'

import { API_URL } from '../../app.constants';

export const TOKEN = 'token'
export const AUTHENTICATED_USER = 'authenticatedUser'


@Injectable({
  providedIn: 'root'
})

export class JWTAuthenticationService {
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
      console.log("Get token : ");
      console.log(sessionStorage.getItem(TOKEN));
      
      return sessionStorage.getItem(TOKEN);
    }
  }

  executeAuthorizationService(username: string, password: string) {

    console.log('username :   ' + username)
    console.log('password :   ' + password)
   
   
    return this.http.post<any>(API_URL + "/authenticate",{username,password} )
      .pipe(
        map(
          data => {
            sessionStorage.setItem(AUTHENTICATED_USER, username)
            sessionStorage.setItem(TOKEN, "Bearer "+ data.token)
            return data;
          }
        )

      );

  }


}
