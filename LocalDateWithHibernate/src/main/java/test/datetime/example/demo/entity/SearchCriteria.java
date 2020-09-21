package test.datetime.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class SearchCriteria {
    String key;
    SearchOperation operation;
    Object value;
}