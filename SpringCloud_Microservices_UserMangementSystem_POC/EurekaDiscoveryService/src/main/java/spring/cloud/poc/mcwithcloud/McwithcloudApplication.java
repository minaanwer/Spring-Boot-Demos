package spring.cloud.poc.mcwithcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class McwithcloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(McwithcloudApplication.class, args);
    }

}
