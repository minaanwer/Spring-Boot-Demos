package test.zlogger.com.demo;

import com.ebc.zLogger.helper.LoggerUserInfo;
import com.ebc.zLogger.zLogger;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    myService myservice;


@GetMapping()
public String  checkStatus(){

    zLogger logger = new zLogger("myLoggingSystem" , new LoggerUserInfo(1,"monna",1,"",1,"monnaBank"));
    logger.addMessage("first Message","hi");
    logger.addMessage("2 Message","hi");
    logger.addMessage("3 Message","hi");
    logger.addMessage("4 Message","hi");
    logger.logData("log Data Action for test ");

    myservice.Authenticate(logger);


    return  "I'm Ok ";
}




    @GetMapping("propLst")
    public List<String> GetPropList() throws ClassNotFoundException {
        UserDTO user = new UserDTO("mon","ageData","Ndata",new Tele("we","mob"));



        Field[] fields = user.getClass().getDeclaredFields();


        getMembers(UserDTO.class);

      //  Logger logger = new Logger();
      //  return logger.log(user , UserDTO.class);
      return null;
    }


    public  void getMembers(Class c) throws ClassNotFoundException
    {
        Field[] fields = c.getDeclaredFields();

        for (Field f : fields)
        {
            if (f.getType().isPrimitive() || f.getType().equals(String.class))
            {
                System.out.println(c.getSimpleName() + ": " + f.getName() + " is a "+ f.getType().getSimpleName());
            }
            else
            {
                if (Collection.class.isAssignableFrom(f.getType()))
                {
                    String s = f.toGenericString();
                    String type = s.split("\\<")[1].split("\\>")[0];
                    Class clazz = Class.forName(type);
                    System.out.println(c.getSimpleName()+ ": "+ f.getName()+ " is a collection of "+ clazz.getSimpleName());
                    getMembers(clazz);
                }
                else
                {
                    System.out.println(c.getSimpleName() + ": " + f.getName() + " is a "+ f.getType().getSimpleName());
                    getMembers(f.getType());
                }
            }
        }
    }


}






















