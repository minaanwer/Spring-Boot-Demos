package test.zlogger.com.demo;


import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

@RestController
public class TestController {


@GetMapping()
public String  checkStatus(){



    return  "I'm Ok ";
}




    @GetMapping("propLst")
    public List<String> GetPropList() throws ClassNotFoundException {
        UserDTO user = new UserDTO("mon","ageData","Ndata",new Tele("we","mob"));



        Dictionary keyValuePair =  getMembers(user,UserDTO.class);


    return null;
    }


    public  Dictionary getMembers(Object obj ,Class c) throws ClassNotFoundException {
        Dictionary keyValuePair = new Hashtable();

        Field[] fields = c.getDeclaredFields();

        for (Field f : fields)
        {
            if (f.getType().isPrimitive() || f.getType().equals(String.class))
            {
                System.out.println(c.getSimpleName() + ": " + f.getName() + " is a "+ f.getType().getSimpleName());
                keyValuePair.put(f.getName(),GetValue(obj,c,f) );
            }
            else
            {
                if (Collection.class.isAssignableFrom(f.getType()))
                {
                    String s = f.toGenericString();
                    String type = s.split("\\<")[1].split("\\>")[0];
                    Class clazz = Class.forName(type);
                    System.out.println(c.getSimpleName()+ ": "+ f.getName()+ " is a collection of "+ clazz.getSimpleName());
                    keyValuePair.put(f.getName(),GetValue(obj,c,f) );
                    getMembers(obj,clazz);
                }
                else
                {
                    System.out.println(c.getSimpleName() + ": " + f.getName() + " is a "+ f.getType().getSimpleName());
                    keyValuePair.put(f.getName(),GetValue(obj,c,f) );
                    getMembers(obj, f.getType());
                }
            }
        }
        return keyValuePair;
    }


   String  GetValue(Object obj ,Class c , Field f ){

    try {
        //Field field = c.getClass().getDeclaredField(f.getName());
        //field.setAccessible(true);
        //Object value = field.getName(obj);
        String iWantThis = (String) f.get(obj);
        return iWantThis ;
    }
    catch (Exception ex){
        return "Error";
    }





    }


}






















