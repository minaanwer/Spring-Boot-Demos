package test.datetime.example.demo.newPackage;

import java.time.DateTimeException;
        import java.time.LocalDateTime;
        import java.time.format.DateTimeFormatter;
        import javax.persistence.AttributeConverter;
        import javax.persistence.Converter;
/*
@Converter
public class MovingLocalDateTimeConverter implements AttributeConverter<LocalDateTime, String> {

    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public String convertToDatabaseColumn(LocalDateTime value) {
        return (value != null) ? value.format(fmt) : null;
    }

    @Override
    public LocalDateTime convertToEntityAttribute(String value) {
        return convertLocalDateTime(value);
    }

    private LocalDateTime convertLocalDateTime(String value) {
        try {
            return (value != null) ? LocalDateTime.parse(value.substring(0, 19), fmt) : null;
        } catch (DateTimeException e) {
            return null;
        }
    }

}

 */