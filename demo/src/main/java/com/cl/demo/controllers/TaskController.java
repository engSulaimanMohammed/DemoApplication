package com.cl.demo.controllers;

import com.cl.demo.requestobjects.TaskCreateRequest;
import com.cl.demo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public class TaskController {

   // To connect TaskController with TaskService.
    @Autowired
    private TaskService taskService;

    // To add a new Task.
    @PostMapping("/add")
    public Map<String, String> addTask(@RequestBody TaskCreateRequest requestObj) {
        return taskService.addTask(requestObj);
    }






}
