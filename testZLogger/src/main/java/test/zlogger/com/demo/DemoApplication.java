package test.zlogger.com.demo;

import com.ebc.zLogger.helper.LoggerUserInfo;
import com.ebc.zLogger.zLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    zLogger zLogger(){
       return new zLogger("myLoggingSystem" , new LoggerUserInfo(1,"monna",1,"",1,"monnaBank"));
    }
}
