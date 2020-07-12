package test.zlogger.com.demo.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;



@PropertySource(ignoreResourceNotFound=true,value="classpath:URL.properties")
public class URL {


    @Value("${app.test.value}")
    private String testValue ;

    public URL() {
    }

    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }
}
