package test.zlogger.com.demo;

import org.springframework.boot.web.servlet.server.Encoding;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

public class Logger {

    public List<String> log(Object obj ,Type T ){

        Field[] fields = T.getClass().getDeclaredFields();

        return null;
    }


}
