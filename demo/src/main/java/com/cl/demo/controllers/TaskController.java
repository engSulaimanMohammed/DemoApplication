package com.cl.demo.controllers;

import com.cl.demo.entities.Task;
import com.cl.demo.requestobjects.TaskCreateRequest;
import com.cl.demo.responseobjects.TaskCreateResponse;
import com.cl.demo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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

    // To get one Task by ID.
    @GetMapping("/getById")
    public TaskCreateResponse getTaskById(@RequestParam String uuid) {
        Task task = taskService.getTaskById(uuid);
        return TaskCreateResponse.convert(task);
    }













}
