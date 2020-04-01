package net.guides.springboot2.crud.controller;
import net.guides.springboot2.crud.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class test {
    @GetMapping("/test")
    public String getAllEmployees() {
       return  "8or yad !!";
    }
}