package test.zlogger.com.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test.zlogger.com.demo.Config.URL;

@RestController
public class ConfigurationTestController {

    @Autowired
    private URL url ;

@GetMapping("read/value/from/config")
    public String TryToReadValue(){
        return url.testValue;
    }



}
