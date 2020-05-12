import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BasicAuthenticationService } from '../AuthenticationServices/basic-authentication.service';
import {JWTAuthenticationService} from '../AuthenticationServices/jwt-authentication.service'

@Injectable({
  providedIn: 'root'
})

export class HttpInterceptorBasicAuthService implements HttpInterceptor {

  constructor(
    private AuthenticationService: BasicAuthenticationService ,
    private JWTAuthService : JWTAuthenticationService
    
    ) { }

  
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {


    let basicAuthenticationString = this.JWTAuthService.getAuthenticatedToken()
    let username = this.JWTAuthService.getAuthenticatedUser()

    if (basicAuthenticationString && username) {
      request = request.clone({
        setHeaders: { Authorization: this.JWTAuthService.getAuthenticatedToken() }
      });
    }
    
    return next.handle(request)
  }
}