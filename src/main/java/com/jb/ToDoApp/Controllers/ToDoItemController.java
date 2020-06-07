package com.jb.ToDoApp.Controllers;

import com.jb.ToDoApp.DataModels.ToDoItem;
import com.jb.ToDoApp.DataModels.ToDoList;
import com.jb.ToDoApp.Repositories.ToDoItemRepository;
import com.jb.ToDoApp.Repositories.ToDoListRepository;
import com.jb.ToDoApp.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins="*", allowedHeaders="*")
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
    public String addNewItemToList(@RequestBody Map<String, Object> newItem){
        ToDoItem item = itemService.createNewToDoItem((String)newItem.get("parent"), (String)newItem.get("toDoDescription"));
        if (item != null){
            return "Item added.";
        } else {
            return "List does not exist.";
        }
    }

    @PutMapping("/items")
    public void updateItemInList(@RequestBody Map<String, Object> newItem){
        itemService.updateToDoItemDescription((String)newItem.get("itemId"), (String)newItem.get("toDoDescription"));
    }

    @PutMapping("/items/update")
    public void updateCompletedStatusOfItem(@RequestBody Map<String, Object> newItem){
        itemService.updateToDoItemCompletedStatus((String)newItem.get("itemId"), (boolean)newItem.get("completed"));
    }


    @DeleteMapping("/items/{itemId}")
    public void deleteItemFromList(@PathVariable Long itemId){
        itemService.deleteToDoItem(itemId);
    }
}
