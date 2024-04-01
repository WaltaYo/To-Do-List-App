package org.wecancodeit.todotask.Models;

import java.time.LocalDate;
import java.util.*;
import org.wecancodeit.todotask.Models.Enums.*;
import jakarta.persistence.*;

@Entity
@Table(name = "t_Task")
public class TaskModel {
    
    @Id
    @GeneratedValue
    private Long taskId;
    private String description;
    private boolean status;
    private PriorityEnum priority;
    private CategoryEnum category;
    private LocalDate dueDate = LocalDate.now();

    
    /**
     * Default constructor
     */
    public TaskModel() {
    }

    /**
     * Parametarized constructor
     * 
     * @param description
     * @param status
     * @param priority
     * @param category
     * @param dueDate
     */
    public TaskModel(String description, boolean status, PriorityEnum priority, CategoryEnum category, LocalDate dueDate) {
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.category = category;
        this.dueDate = dueDate;
    }

    /**
     * Method that gets the TaskID
     * 
     * @return TaskID
     */
    public Long getTaskId() {
        return taskId;
    }

    public void setTaskID(Long taskId) {
    this.taskId = taskId;
    }

    /**
     * Method that gets the description
     * 
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method that gets the status
     * 
     * @return
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Method that gets the priority
     * 
     * @return
     */
    public PriorityEnum getPriority() {
        return priority;
    }

    /**
     * Method that gets the category
     * 
     * @return
     */
    public CategoryEnum getCategory() {
        return category;
    }

    /**
     * Method that gets the due date
     * 
     * @return
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /*
     * toString
     */
    @Override
    public String toString() {
        return "TaskModel [taskID=" + taskId + ", description=" + description + ", status=" + status + ", priority="
                + priority + ", category=" + category + ", dueDate=" + dueDate + "]";
    }

}
