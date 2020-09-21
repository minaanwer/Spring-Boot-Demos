package test.datetime.example.demo.newPackage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
/*
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime dateTime, JsonGenerator generator,
                          com.fasterxml.jackson.databind.SerializerProvider provider)
            throws IOException, com.fasterxml.jackson.core.JsonProcessingException {
        if (dateTime == null) {
            generator.writeNull();
        } else {
            generator.writeString(dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
        }
    }

}

 */