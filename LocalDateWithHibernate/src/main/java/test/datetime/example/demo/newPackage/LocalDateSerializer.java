package test.datetime.example.demo.newPackage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
/*
public class LocalDateSerializer extends JsonSerializer<LocalDate> {

    @Override
    public void serialize(LocalDate date, JsonGenerator generator, com.fasterxml.jackson.databind.SerializerProvider provider)  throws IOException, com.fasterxml.jackson.core.JsonProcessingException {
        if (date == null) {
            generator.writeNull();
        } else {
            generator.writeString(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
    }

}

 */