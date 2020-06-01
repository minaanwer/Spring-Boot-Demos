package users.ui.controllers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import users.Service.UsersService;
import users.shared.UserDto;
import users.ui.models.CreateUserRequestModel;
import users.ui.models.CreatedReponseModel;
import users.ui.models.UserResponseModel;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController{

    @Autowired
    public Environment env;

    @Autowired
    UsersService usersService;

    @GetMapping("status/check")
    public  String statusCheck(){
        return  "accounts Service says  :  i'm woorking .. on port "+ env.getProperty("local.server.port")  + "and secret key is : " + env.getProperty("token.secret") ;
    }
    @GetMapping("status/check/temp")
    public  String statusCheckTemp(){
        return "temp is working";
    }



    //@PostMapping(path = "" , produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE}
    //,consumes = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE})
    @PostMapping(path = "")
    public ResponseEntity<CreatedReponseModel>  createUser(@Valid @RequestBody CreateUserRequestModel userDetails){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT) ;
        UserDto userDto =  modelMapper.map(userDetails,UserDto.class);
        UserDto responceDto =  usersService.CreateUser(userDto);

       return ResponseEntity.status(HttpStatus.CREATED).body( new ModelMapper().map(responceDto,CreatedReponseModel.class));
    }


  @GetMapping(value = "/{userId}")
    public ResponseEntity<UserResponseModel> getUser(@PathVariable("userId") String userId){
        UserDto userDto = usersService.getUserByUserId(userId);
        UserResponseModel returnValue = new ModelMapper().map(userDto,UserResponseModel.class);
       return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }



}