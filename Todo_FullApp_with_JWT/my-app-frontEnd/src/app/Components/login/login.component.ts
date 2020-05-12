import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardcodedAuthenticationService } from '../../Services/HardCodedAuthService/hardcoded-authentication.service';
import { BasicAuthenticationService } from 'src/app/Services/AuthenticationServices/basic-authentication.service';
import { JWTAuthenticationService } from 'src/app/Services/AuthenticationServices/jwt-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  username = ''
  password = ''
  errormessage = 'In valid Cred.'
  invalidlogin = false

  constructor(
    
    private router: Router,
    private hardCodedAuth: HardcodedAuthenticationService, 
    private basicAuthenticationService: BasicAuthenticationService ,
    private jwtAuthService:JWTAuthenticationService
    
    ){}

  ngOnInit(): void {
    this.username = ''
    this.password = ''
  }


  loginClicked() {
console.log('loginClicked')
     this.jwtAuthService.executeAuthorizationService(this.username, this.password).subscribe(
       data => {
         console.log("login success")
         console.log(data)
         this.invalidlogin = false
         sessionStorage.setItem('authenticatedUser', this.username)
         this.router.navigate(['welcom', this.username])
        },
       error => {
         console.log('error occured ')
          console.log(error)
        this.invalidlogin = true
       }
     )
    
      
    }
    






}