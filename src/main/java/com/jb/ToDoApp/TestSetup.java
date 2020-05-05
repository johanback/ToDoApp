package com.jb.ToDoApp;

import com.jb.ToDoApp.DataModels.ToDoItem;
import com.jb.ToDoApp.DataModels.ToDoList;
import com.jb.ToDoApp.Repositories.ToDoItemRepository;
import com.jb.ToDoApp.Repositories.ToDoListRepository;
import com.jb.ToDoApp.Services.TestSetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestSetup {



    private TestSetupService testSetupService;

    public TestSetup(TestSetupService tss) {
        testSetupService = tss;
        initializeSomeLists();
    }

    public void initializeSomeLists(){
        testSetupService.createPlaceholderLists();
    }
}
