package test.datetime.example.demo.converter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
public class Example {
    public static void main(String[] args) {
        //default time zone
        ZoneId defaultZoneId = ZoneId.systemDefault();

        //creating the instance of LocalDate using the day, month, year info
        LocalDate localDate = LocalDate.of(2016, 8, 19);

        //local date + atStartOfDay() + default time zone + toInstant() = Date
        Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

        //Displaying LocalDate and Date
        System.out.println("LocalDate is: " + localDate);
        System.out.println("Date is: " + date);
    }
}