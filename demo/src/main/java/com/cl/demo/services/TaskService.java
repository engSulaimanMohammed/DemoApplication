package com.cl.demo.services;

import com.cl.demo.DemoApplication;
import com.cl.demo.entities.Task;
import com.cl.demo.requestobjects.TaskCreateRequest;
import com.cl.demo.requestobjects.TaskUpdateRequest;
import com.cl.demo.utils.HelperUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class TaskService {

    public static final String TASK_SAVED = "Task saved";


    // To Add a new Task.
    public Map<String, String> addTask(TaskCreateRequest requestObj) {
        Map<String, String> response = new HashMap<>();
        Task task = new Task();

        // The BaseClass information.
        task.setId(UUID.randomUUID());
        task.setIsActive(Boolean.TRUE);
        task.setCreatedDate(new Date());

        // Task information.
        task.setTitle(requestObj.getTitle());
        task.setDescription(requestObj.getDescription());
        task.setDueDate(requestObj.getDueDate());
        task.setStartDate(requestObj.getStartDate());
        task.setTaskStatus(requestObj.getTaskStatus());
        task.setIsAssigned(requestObj.getIsAssigned());

        // To generate Task Number automatically.
        task.setTaskNumber(generateTaskNumber());

        // Add Task to the list.
        Boolean result = DemoApplication.Task_List.add(task);
        if (result) {
            response.put("response", TASK_SAVED);
        }
        return response;
    }


    // Finds one active Task by ID.
    public Task getTaskById(String uuid) {
        for (Task task : DemoApplication.Task_List) {
            if (task.getId().toString().equals(uuid) && task.getIsActive()) {
                return task;
            }
        }
        return new Task();
    }


    // Returns all active Tasks.
    public List<Task> getAllTasks() {
        List<Task> resultList = new ArrayList<>();
        for (Task task : DemoApplication.Task_List) {
            if (task.getIsActive()) {
                resultList.add(task);
            }
        }
        return resultList;
    }


    // To Update an existing Task.
    public Task updateTask(TaskUpdateRequest updateObj) {
        Task task = getTaskById(updateObj.getUuid().toString());
        if (task == null || task.getId() == null || !task.getIsActive()) {
            return task;
        }
        DemoApplication.Task_List.remove(task);

        // Compare old and new values.
        task.setTitle(HelperUtils.compare(task.getTitle(), updateObj.getTitleToUpdate()));
        task.setDescription(HelperUtils.compare(task.getDescription(), updateObj.getDescriptionToUpdate()));

        // To Update these values.
        if (updateObj.getTaskStatusToUpdate() != null) {
            task.setTaskStatus(updateObj.getTaskStatusToUpdate());
        }
        if (updateObj.getDueDateToUpdate() != null) {
            task.setDueDate(updateObj.getDueDateToUpdate());
        }

        if (updateObj.getIsAssignedToUpdate() != null) {
            task.setIsAssigned(updateObj.getIsAssignedToUpdate());
        }

        // Save update date.
        task.setUpdatedDate(new Date());
        DemoApplication.Task_List.add(task);
        return task;
    }


    public Boolean deleteById(String uuid) {
        Task task = getTaskById(uuid);
        if (task == null || task.getId() == null || !task.getIsActive()) {
            return false;
        }
        DemoApplication.Task_List.remove(task);

        // Do not delete the Task permanently.
        task.setIsActive(false);
        DemoApplication.Task_List.add(task);
        return true;
    }


    // Generates Task Number automatically.
    public String generateTaskNumber() {
        return "TASK-" + (DemoApplication.Task_List.size() + 1);
    }
}