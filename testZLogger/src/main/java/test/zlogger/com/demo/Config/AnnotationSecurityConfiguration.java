package test.zlogger.com.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import test.zlogger.com.demo.Log.myLogger;

@Configuration
public class AnnotationSecurityConfiguration implements WebMvcConfigurer {
   @Autowired
   public myLogger mylogger;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor(mylogger));
    }
}