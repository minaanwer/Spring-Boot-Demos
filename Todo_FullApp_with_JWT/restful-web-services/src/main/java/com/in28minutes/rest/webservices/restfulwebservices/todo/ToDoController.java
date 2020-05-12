package com.in28minutes.rest.webservices.restfulwebservices.todo;

import com.in28minutes.rest.webservices.restfulwebservices.helloworld.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class ToDoController {

    @Autowired
    private ToDoRepo _toDoRepo;



    @RequestMapping(value = "/api/v1/test", method = RequestMethod.GET)
    public ResponseEntity<HelloWorldBean> test() {
       return new ResponseEntity(new HelloWorldBean("trust me!"), HttpStatus.OK);
    }

    @GetMapping("/api/v1/todos/{userName}")
    public List<ToDo> GetAllToDos(@PathVariable String userName) {
        return _toDoRepo.findAll().stream().filter(x -> x.getUsername().equals(userName) ).collect(Collectors.toList());
    }

    @PostMapping("/api/v1/users/{userName}/todo")
    public String Add(@Valid @RequestBody ToDo todo , @PathVariable String userName) {
        try {
            todo.setId(0);
            todo.setTargetDate(new Date());
            todo.setDone(true);
            todo.setUsername(userName);
            _toDoRepo.save(todo);
            return "ok";
        } catch (Exception ex) {
            return "error  : " + ex.getMessage();
        }
    }

    @DeleteMapping("/api/v1/users/{username}/todos/{id}")
    public String deleteById( @PathVariable String username , @PathVariable Long id) {
        try {
           Optional<ToDo> obj =  _toDoRepo.findAll().stream().filter(x-> { return x.getUsername().equals(username) && x.getId().equals(id) ;}).findFirst();
            if(! obj.isPresent()) {
                return "NO ONe Found" ;
            }

            _toDoRepo.deleteById(id);
            return "OK";
        } catch (Exception ex) {
            return "error: " + ex.getMessage();
        }

    }

    @GetMapping("/api/v1/users/{username}/todo/{id}")
    public ToDo getTodo( @PathVariable String username , @PathVariable Long id) {

        return  _toDoRepo.findAll().stream().filter(x -> {
            return x.getUsername().equals(username) && x.getId().equals(id);
        }).findFirst().get();
    }

    @PutMapping("/api/v1/users/{username}/todo/{id}")
    public String update(@Valid @RequestBody ToDo todo , @PathVariable String username , @PathVariable  long id ) {
        try {
           ToDo  _todo = _toDoRepo.findAll().stream().filter(x-> { return x.getUsername().equals(username) && x.getId().equals(id) ;}).findFirst().get();
           _todo.setDescription(todo.getDescription());
           _todo.setTargetDate(todo.getTargetDate());
            _toDoRepo.save(_todo);
            return "ok";
        } catch (Exception ex) {
            return "error  : " + ex.getMessage();
        }

    }

}
