package com.jb.ToDoApp.Controllers;

import com.jb.ToDoApp.DataModels.ToDoList;
import com.jb.ToDoApp.Repositories.ToDoItemRepository;
import com.jb.ToDoApp.Repositories.ToDoListRepository;
import com.jb.ToDoApp.TestSetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
public class ToDoListController {

    @Autowired
    private ToDoListRepository toDoListRepository;
    @Autowired
    private ToDoItemRepository toDoItemRepository;

    @GetMapping("/lists")
    public List<ToDoList> getAllLists(){
        return (List)toDoListRepository.findAll();
    }

    @GetMapping("/lists/{listId}")
    public ToDoList getListById(@PathVariable Long listId){
        Optional<ToDoList> optional = toDoListRepository.findById(listId);
        if (optional.isPresent()){
            return optional.get();
        } else {
            return null;
        }
    }

    @PostMapping("/lists")
    public String createNewList(@RequestBody Map<String, Object> newList){
        ToDoList newListObject = new ToDoList((String)newList.get("listName"));
        toDoListRepository.save(newListObject);
        return "Added a new list";
    }

    @DeleteMapping("lists/{listId}")
    public void deleteList(@PathVariable Long listId){
        toDoListRepository.deleteById(listId);
    }

}
