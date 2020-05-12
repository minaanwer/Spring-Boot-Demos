import { Component, OnInit } from '@angular/core';
import { HardcodedAuthenticationService } from '../../Services/HardCodedAuthService/hardcoded-authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})

export class LogoutComponent implements OnInit {

  constructor(private hardCodedAuth : HardcodedAuthenticationService , private router:Router ) { }

  ngOnInit(): void {
   this.hardCodedAuth.Logout();
   this.router.navigate(['login'])
  }

}
