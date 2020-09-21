package test.datetime.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


class DemoApplicationTests {

    @Test
    public void Test(){
        LocalDate today = LocalDate.now();

        LocalDate localDate = LocalDate.now();
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDate));


    }




    @Test
    void contextLoads() {


    }

}
