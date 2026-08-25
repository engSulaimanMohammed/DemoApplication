package com.cl.demo.responseobjects;


import com.cl.demo.entities.Task;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class TaskUpdateResponse {

    private String taskId;
    private String title;
    private String description;
    private String taskNumber;
    private String taskStatus;
    private String dueDate;
    private Boolean isAssigned;


    // To convert one Task to TaskUpdateResponse.
    public static TaskUpdateResponse convert(Task task) {
        TaskUpdateResponse response = new TaskUpdateResponse();

        // To check that Task and ID are not null.
        if (task != null && task.getId() != null) {
            response.setTaskId(task.getId().toString());
        }
        if (task != null) {
            response.setTitle(task.getTitle()); // Data transfer.
            response.setDescription(task.getDescription()); // Data transfer.
            response.setTaskNumber(task.getTaskNumber()); // Data transfer.

            // Convert TaskStatus to String.
            if (task.getTaskStatus() != null) {
                response.setTaskStatus(task.getTaskStatus().toString());
            }

            // To convert dueDate to String.
            if (task.getDueDate() != null) {
                response.setDueDate(task.getDueDate().toString());
            }
            response.setIsAssigned(task.getIsAssigned());
        }
        return response;
    }


    // Convert List<Task> to List<TaskUpdateResponse>.
    public static List<TaskUpdateResponse> convert(List<Task> taskList) {
        List<TaskUpdateResponse> responseList = new ArrayList<>();
        if (taskList == null) {
            return responseList;
        }
        for (Task task : taskList) {
            responseList.add(convert(task));
        }
        return responseList;
    }
}
