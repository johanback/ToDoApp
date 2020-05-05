package com.jb.ToDoApp.Controllers;

import com.jb.ToDoApp.DataModels.ToDoList;
import com.jb.ToDoApp.Repositories.ToDoItemRepository;
import com.jb.ToDoApp.Repositories.ToDoListRepository;
import com.jb.ToDoApp.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ToDoItemController {

    @Autowired
    private ToDoListRepository toDoListRepository;
    @Autowired
    private ToDoItemRepository toDoItemRepository;
    @Autowired
    private ItemService itemService;

    @GetMapping("/items/{listId}")
    public List<ToDoList> getItemsFromListById(@PathVariable Long listId){ ;
        return (List)toDoItemRepository.findAllByParentId(listId);
    }

    @PostMapping("/items")
    public void addNewItemToList(@RequestBody Map<String, Object> newItem){
        itemService.createNewToDoItem((String)newItem.get("parent"), (String)newItem.get("toDoDescription"));
    }

    @PutMapping("/items")
    public void updateItemInList(@RequestBody Map<String, Object> newItem){
        itemService.updateToDoItem((String)newItem.get("itemId"), (String)newItem.get("toDoDescription"));
    }

    @DeleteMapping("/items/{itemId}")
    public void deleteItemFromList(@PathVariable Long itemId){
        itemService.deleteToDoItem(itemId);
    }
}
