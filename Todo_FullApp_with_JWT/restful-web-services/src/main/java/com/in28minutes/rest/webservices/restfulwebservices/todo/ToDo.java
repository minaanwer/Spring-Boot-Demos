package com.in28minutes.rest.webservices.restfulwebservices.todo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ToDo")
public class ToDo {
    private long id;
    private String username;
    private String description;
    private Date targetDate;
    private boolean done;

    public ToDo() { }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }



    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "UserName" , nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Column(name = "Description" , nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "TargetDate" , nullable = false)
    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetdate) {
        this.targetDate = targetdate;
    }

    @Column(name = "IsDone" , nullable = false)
    public boolean isDone() {
        return done;
    }

    public void setDone(boolean isdone) {
        this.done = isdone;
    }

}