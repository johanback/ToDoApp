package com.jb.ToDoApp.Repositories;


import com.jb.ToDoApp.DataModels.ToDoList;
import org.springframework.data.repository.CrudRepository;

public interface ToDoListRepository extends CrudRepository<ToDoList, Long> {

}
