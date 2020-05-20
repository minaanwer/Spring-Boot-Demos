package accountmangementservice.accountmangementms.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController{

    @Autowired
  public Environment env;
    @GetMapping("status/check")
    public  String statusCheck(){

        return  "accounts Service says  :  i'm woorking .. on port "+env.getProperty("local.server.port") ;
    }

}