package com.cl.demo.controllers;

import com.cl.demo.entities.Task;
import com.cl.demo.requestobjects.TaskCreateRequest;
import com.cl.demo.requestobjects.TaskUpdateRequest;
import com.cl.demo.responseobjects.TaskCreateResponse;
import com.cl.demo.responseobjects.TaskUpdateResponse;
import com.cl.demo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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


    // To get all active Tasks.
    @GetMapping("/getAll")
    public List<TaskCreateResponse> getAllTasks() {
        List<Task> taskList = taskService.getAllTasks();
        return TaskCreateResponse.convert(taskList);
    }

    @PutMapping("/update")
    public TaskUpdateResponse updateTask(@RequestBody TaskUpdateRequest requestObj) {
        Task task = taskService.updateTask(requestObj);
        return TaskUpdateResponse.convert(task);
    }




















}
