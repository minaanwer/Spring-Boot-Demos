package test.zlogger.com.demo.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;



@PropertySource(value="classpath:URL.properties")
public class URL {


    @Value("${app.test.value}")
    public String testValue ;



}
