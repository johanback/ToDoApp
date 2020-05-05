package com.jb.ToDoApp.Repositories;

import com.jb.ToDoApp.DataModels.ToDoItem;
import com.jb.ToDoApp.DataModels.ToDoList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToDoItemRepository extends CrudRepository<ToDoItem, Long> {

    public List<ToDoItem> findAllByParentId(Long parentId);
}
