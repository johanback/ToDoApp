package com.jb.ToDoApp.DataModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String listName;

    @JsonIgnore
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ToDoItem> items;

    public ToDoList(){
        listName = "default";
    }

    public ToDoList(String listName){
        this.listName = listName;
    }

    public ToDoList(Long id, String listName){
        this.id = id;
        this.listName = listName;
    }
}
