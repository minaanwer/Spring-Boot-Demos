package net.guides.springboot2.crud.Tests;


import net.guides.springboot2.crud.model.Employee;
import net.guides.springboot2.crud.model.EmployeeSpecification;
import net.guides.springboot2.crud.model.SearchCriteria;
import net.guides.springboot2.crud.repository.SCEmployeeRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SCEmployeeRepoTests
{

    @Autowired
    private SCEmployeeRepository _toDoRepo ;

    @Before
    public void  init(){

    }


    @Test
    public void Givenlast_whenGettingListOfToDos(){
        EmployeeSpecification specs = new EmployeeSpecification( new SearchCriteria("firstName","==","tota")) ;
        List<Employee> todos = _toDoRepo.findAll(specs) ;

        //assertThat(todos.size(),1) ;


    }


}