import { Component, OnInit } from '@angular/core';
import { HardcodedAuthenticationService } from '../../Services/HardCodedAuthService/hardcoded-authentication.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})


export class MenuComponent implements OnInit {

 isLoggedIn = true
 HardCodedAuth:HardcodedAuthenticationService
  
  constructor(hardCodedAuth :  HardcodedAuthenticationService) 
  {
    this.HardCodedAuth = hardCodedAuth;  
  }

  ngOnInit(): void { 
    this.isLoggedIn = this.HardCodedAuth.isUserLoggedIn() ; 
  }

}
