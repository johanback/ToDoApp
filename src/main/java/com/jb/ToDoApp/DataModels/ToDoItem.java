package com.jb.ToDoApp.DataModels;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private ToDoList parent;
    private String toDoDescription;
    private boolean completed;

    public ToDoItem(){
        parent = null;
        toDoDescription = "";
        completed = false;
    }

    public ToDoItem(ToDoList parent, String toDoDescription){
        this.parent = parent;
        this.toDoDescription = toDoDescription;
        completed = false;
    }
}
