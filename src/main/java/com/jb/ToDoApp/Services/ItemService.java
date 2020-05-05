package com.jb.ToDoApp.Services;

import com.jb.ToDoApp.DataModels.ToDoItem;
import com.jb.ToDoApp.DataModels.ToDoList;
import com.jb.ToDoApp.Repositories.ToDoItemRepository;
import com.jb.ToDoApp.Repositories.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ToDoListRepository listRepository;
    @Autowired
    ToDoItemRepository itemRepository;

    public void createNewToDoItem(String parentId, String toDoDescription){
        ToDoList parent = listRepository.findById(Long.valueOf(parentId)).get();
        itemRepository.save(new ToDoItem(parent, toDoDescription));
    }

    public void updateToDoItem(String itemId, String newToDoDescription){
        Optional<ToDoItem> optionalItem = itemRepository.findById(Long.valueOf(itemId));
        if (optionalItem.isPresent()){
            ToDoItem itemToUpdate = optionalItem.get();
            itemToUpdate.setToDoDescription(newToDoDescription);
            itemRepository.save(itemToUpdate);
        }
    }

    public void deleteToDoItem(Long itemId){
        itemRepository.deleteById(itemId);
    }
}
