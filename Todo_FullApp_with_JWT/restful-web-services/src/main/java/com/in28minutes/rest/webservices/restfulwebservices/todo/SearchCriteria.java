package com.in28minutes.rest.webservices.restfulwebservices.todo;

public class SearchCriteria {
    private String _key;
    private String _operation;
    private String _value;

    public SearchCriteria(String key, String operation, String value) {
        _key = key ;
        _operation = operation ;
        _value = value ;
    }

    public String get_key() {
        return _key;
    }

    public String get_operation() {
        return _operation;
    }

    public String get_value() {
        return _value;
    }
}
