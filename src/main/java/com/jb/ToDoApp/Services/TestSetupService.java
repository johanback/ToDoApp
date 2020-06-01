package com.jb.ToDoApp.Services;


import com.jb.ToDoApp.DataModels.ToDoItem;
import com.jb.ToDoApp.DataModels.ToDoList;
import com.jb.ToDoApp.Repositories.ToDoItemRepository;
import com.jb.ToDoApp.Repositories.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestSetupService {

    @Autowired
    ToDoListRepository listRepository;
    @Autowired
    ToDoItemRepository itemRepository;

    public void createPlaceholderLists(){
        ToDoList list1 = new ToDoList(1l, "Workout");
        listRepository.save(list1);
        itemRepository.save(new ToDoItem(list1, "Item 1"));
        itemRepository.save(new ToDoItem(list1, "Item 2"));
        itemRepository.save(new ToDoItem(list1, "Item 3"));

        ToDoList list2 = new ToDoList("Groceries");
        listRepository.save(list2);
        itemRepository.save(new ToDoItem(list2, "Item 4"));
        itemRepository.save(new ToDoItem(list2, "Item 5"));
        itemRepository.save(new ToDoItem(list2, "Item 6"));

        ToDoList list3 = new ToDoList("Programming");
        listRepository.save(list3);
        itemRepository.save(new ToDoItem(list3, "Item 7"));
        itemRepository.save(new ToDoItem(list3, "Item 8"));
        itemRepository.save(new ToDoItem(list3, "Item 9"));
    }
}
