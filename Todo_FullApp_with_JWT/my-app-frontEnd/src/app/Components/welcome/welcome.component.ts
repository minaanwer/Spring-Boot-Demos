import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WelcomDataService, helloWorldBean } from '../../Services/welcomDataService/welcom-data.service';
import { error } from 'protractor';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  name: string

  messageFromService: String

  constructor(private route: ActivatedRoute,
    private welcomDataService: WelcomDataService

  ) { }

  ngOnInit(): void {

    this.name = this.route.snapshot.params['name']
  }

  getWelcomMessage() {

    var result = this.welcomDataService.executeHelloWorldBeanService();

   
    result.subscribe(
      responce => {
        console.log("in Responce")
        console.log(responce)
        console.log(responce.message);
        
        this.messageFromService = responce.message

      },
      error => {
        console.log("in error")
        this.messageFromService = error.message
      } 
    );


  }
 
}