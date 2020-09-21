package test.datetime.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
public class SearchCriteria {
    String key;
    SearchOperation operation;

    Object value;

    LocalDate startDate;
    LocalDate endDate;
}