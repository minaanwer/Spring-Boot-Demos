package users.ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import users.ui.models.CreateUserRequestModel;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController{

    @Autowired
    public Environment env;
    @GetMapping("status/check")
    public  String statusCheck(){
        return  "accounts Service says  :  i'm woorking .. on port "+env.getProperty("local.server.port") ;
    }


    @PostMapping
    public String createUser(@Valid CreateUserRequestModel userDetails){

        return "yes , its ok !" ;
    }



}