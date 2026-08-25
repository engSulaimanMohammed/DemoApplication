package com.cl.demo.requestobjects;


import com.cl.demo.entities.TaskStatus;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TaskCreateRequest {


    private String title;
    private String description;
    private Date dueDate;
    private Date startDate;
    private TaskStatus taskStatus;
    private Boolean isAssigned;






}
