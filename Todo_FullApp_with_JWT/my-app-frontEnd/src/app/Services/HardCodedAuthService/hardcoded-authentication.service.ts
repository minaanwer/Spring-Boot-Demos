import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class HardcodedAuthenticationService {
  constructor() {
  }

  authenticate(userName: string, password: string) {

    if (userName === "monna" && password === "monna") {

      sessionStorage.setItem("authenticatedUser", userName);

      return true;

    }
    else {

      return false;

    }
  }

  isUserLoggedIn() {

    let user = sessionStorage.getItem("authenticatedUser");

    return !(user === null)

  }

  Logout() {
    sessionStorage.removeItem('authenticatedUser');
  }

}