package test.zlogger.com.demo;

import com.ebc.zLogger.zLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class myService {

  private  Environment environment;
  private zLogger zlogger ;


    @Autowired
    public myService( Environment env , zLogger logger ){
        zlogger = logger;
        environment = env;
    }


   public void Authenticate(zLogger logger){

   }


}
