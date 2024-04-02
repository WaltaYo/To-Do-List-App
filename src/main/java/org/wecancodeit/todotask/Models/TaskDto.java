package org.wecancodeit.todotask.Models;

import java.time.LocalDate;

import org.wecancodeit.todotask.Models.Enums.CategoryEnum;
import org.wecancodeit.todotask.Models.Enums.PriorityEnum;

public class TaskDto {
    private Long taskId;
    private String description;
    private boolean status;
    private PriorityEnum priority;
    private CategoryEnum category;
    private LocalDate dueDate = LocalDate.now();

    public TaskDto() {
    }

    public TaskDto(Long taskId, String description, boolean status, PriorityEnum priority, CategoryEnum category,
            LocalDate dueDate) {
        this.taskId = taskId;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.category = category;
        this.dueDate = dueDate;
    }

    public TaskDto(TaskModel model) { // put the TaskModel in TaskDto
        this.taskId = model.getTaskId();
        this.description = model.getDescription();
        this.status = model.isStatus();
        this.priority = model.getPriority();
        this.category = model.getCategory();
        this.dueDate = model.getDueDate();
    }

    public TaskModel CopyTask() { // created consturctor to access TaskModel
        TaskModel task = new TaskModel(this.description, this.status, this.priority, this.category, this.dueDate);
        task.setTaskID(this.taskId);
        return task;

    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public PriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

}
