package com.cl.demo.responseobjects;


import com.cl.demo.entities.Task;
import java.util.ArrayList;
import java.util.List;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class TaskCreateResponse {

    private String taskId;
    private String title;
    private String description;
    private String taskNumber;
    private String taskStatus;
    private String dueDate;
    private Boolean isAssigned;





    // Converts one Task entity to TaskCreateResponse.
    public static TaskCreateResponse convert(Task task) {

        TaskCreateResponse response = new TaskCreateResponse();

        // Check ID before converting it to String.
        if (task != null && task.getId() != null) {
            response.setTaskId(task.getId().toString());
        }
        if (task != null) {

            response.setTitle(task.getTitle()); // Data transfer.
            response.setDescription(task.getDescription());  // Data transfer.
            response.setTaskNumber(task.getTaskNumber());  // Data transfer.

            // Convert task status to String.
            if (task.getTaskStatus() != null) {
                response.setTaskStatus(task.getTaskStatus().toString()                         );
            }

            // To Convert date to String.
            if (task.getDueDate() != null) {
                response.setDueDate(task.getDueDate().toString());
            }
            response.setIsAssigned(task.getIsAssigned());
        }
        return response;
    }


    // Converts a list of Tasks to a list of TaskCreateResponse.
    public static List<TaskCreateResponse> convert(List<Task> taskList) {
        List<TaskCreateResponse> responseList = new ArrayList<>();
        if (taskList == null) {
            return responseList;
        }
        for (Task task : taskList) {
            responseList.add(convert(task));
        }
        return responseList;
    }
}
