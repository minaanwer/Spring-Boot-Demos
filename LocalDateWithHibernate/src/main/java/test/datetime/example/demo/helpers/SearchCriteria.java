package test.datetime.example.demo.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Arrays;
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
    public SearchCriteria(String key, SearchOperation operation, List<Object> values) {
        this.key = key;
        this.operation = operation;
        this.values = values;
    }
    private SearchCriteria(List<String> keys, SearchOperation operation, List<Object> values) {
        this.key = key;
        this.operation = operation;
        this.values = values;
    }
    public SearchCriteria(String startTimestampKey, String endTimestampKey, LocalDateTime startTimestamp, LocalDateTime endTimeStamp) {
        this(Arrays.asList(startTimestampKey,endTimestampKey), SearchOperation.Between, Arrays.asList(startTimestamp,endTimeStamp));
    }
}