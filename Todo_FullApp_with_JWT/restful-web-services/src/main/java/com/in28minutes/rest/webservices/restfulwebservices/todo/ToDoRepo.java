package com.in28minutes.rest.webservices.restfulwebservices.todo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepo extends JpaRepository<ToDo,Long >, JpaSpecificationExecutor<ToDo> { }