package com.appsdeveloperblog.photoapp.api.albums.io.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("albums")
public class TestController {

    @Autowired
    private Environment env;


    @GetMapping("status/check")
    public  String statusCheck(){
        return  "accounts Service says  :  i'm woorking .. on port "+ env.getProperty("local.server.port")  + "and secret key is : " + env.getProperty("token.secret") ;
        //return "";
    }

    @GetMapping("status/check/temp")
    public  String statusCheckTemp(){
        // return  "accounts Service says  :  i'm woorking .. on port "+ env.getProperty("local.server.port")  + "and secret key is : " + env.getProperty("token.secret") ;
        // return "";
        return "temp is working";
    }

}
