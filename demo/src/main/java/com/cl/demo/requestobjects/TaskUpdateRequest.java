package com.cl.demo.requestobjects;


import com.cl.demo.entities.TaskStatus;
import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class TaskUpdateRequest {

    private UUID uuid;
    private String titleToUpdate;
    private String descriptionToUpdate;
    private TaskStatus taskStatusToUpdate;
    private Date dueDateToUpdate;
    private Boolean isAssignedToUpdate;








}
