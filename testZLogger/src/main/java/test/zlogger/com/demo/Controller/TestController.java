package test.zlogger.com.demo.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test.zlogger.com.demo.Log.myLogger;
import test.zlogger.com.demo.Model.ChildOne;
import test.zlogger.com.demo.Model.ChildTwo;
import test.zlogger.com.demo.Model.UserDTO;

import java.lang.reflect.Field;
import java.util.Dictionary;
import java.util.Hashtable;


@RestController
public class TestController {

    @Autowired
    myLogger  mylogger ;

    public  TestController(){

    }

    @GetMapping()
    public String  checkStatus(){
        this.mylogger.Log("I'm inside check status");
        return  "ALL IZZ WEll";
    }




    @GetMapping("propLst")
    public Dictionary GetPropList() throws IllegalAccessException {
        UserDTO user = new UserDTO("mon","ageData","Ndata",new ChildOne("we","mob" , new ChildTwo("tel2","tele2Num")));

        Dictionary keyValuePair = new Hashtable();
        keyValuePair =  getMembers(user, user.getClass(), keyValuePair);
        return keyValuePair;

    }

    public  Dictionary getMembers(Object obj, Class c, Dictionary dict) throws IllegalAccessException {

        Field[] fields = c.getDeclaredFields();

        for (Field f : fields)
        {
            if (f.getType().isPrimitive() || f.getType().equals(String.class))
            {
                System.out.println(c.getSimpleName() + ": " + f.getName() + " is a "+ f.getType().getSimpleName());
                dict.put(f.getName(),GetValue(obj,c,f) );
            }
            else
            {
                getMembers(f.get(obj), f.getType(),dict);
            }
        }
        return dict;
    }

    String  GetValue(Object obj ,Class c , Field f ){
        try {
            f.setAccessible(true);
            String iWantThis = (String) f.get(obj);
            return iWantThis ;
        }
        catch (Exception ex){
            return "Error";
        }
    }


}