package test.datetime.example.demo.newPackage;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/*
@Converter
public class MovingLocalDateConverter implements AttributeConverter<LocalDate, String> {

    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public String convertToDatabaseColumn(LocalDate value) {
        return (value != null) ? value.format(fmt) : null;
    }

    @Override
    public LocalDate convertToEntityAttribute(String value) {
        return convertLocalDateTime(value);
    }

    private LocalDate convertLocalDateTime(String value) {
        try {
            return (value != null) ? LocalDate.parse(value.substring(0, 19), fmt) : null;
        } catch (DateTimeException e) {
            return null;
        }
    }

}

 */