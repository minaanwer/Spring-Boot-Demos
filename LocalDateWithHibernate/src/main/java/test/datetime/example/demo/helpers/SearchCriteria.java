package test.datetime.example.demo.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.expression.Operation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class SearchCriteria {
    String key;
    List<String> keys;
    SearchOperation operation;
    Object value;
    List<Object> values;
    public SearchCriteria(String key, SearchOperation operation, Object value){
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    private SearchCriteria(List<String> keys, SearchOperation operation, List<Object> values) {
        this.key = key;
        this.operation = operation;
        this.values = values;
    }
    public SearchCriteria(String startTimestampKey, String endTimestampKey, Date startTimestamp, Date endTimeStamp) {

        keys = new ArrayList<String>();

        keys.add(startTimestampKey);
        keys.add(endTimestampKey);

        values = new ArrayList<>();

        values.add(startTimestamp);
        values.add(endTimeStamp);

       this.operation = SearchOperation.myBetween;
    }



}