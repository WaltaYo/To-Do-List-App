package org.wecancodeit.todotask.Controllers;
import jakarta.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.todotask.Models.TaskModel;
import org.wecancodeit.todotask.Services.TaskModelService;







/**
 * Controller class that models the mapping of the adopter services and
 * repository
 */
@Controller
@RequestMapping("/api/v1/tasklist")
public class TaskModelController {

    @Resource
    private final TaskModelService  taskModelService;

    /**
     * Parametarized constructor
     * 
     * @param taskModelService task services
     */
    public TaskModelController(TaskModelService taskModelService) {
        this.taskModelService = taskModelService;
    }

    /**
     * Method to get all tasks
     * 
     * @return all tasks
     */
    @GetMapping("/")
    public String getAllTasks(Model model){ 
        Iterable<TaskModel> task = taskModelService.findAll();
        model.addAttribute("tasks", task);
        return "index";
     
      
    }

    /**
     * Method to get a task
     * 
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public TaskModel getTask (@PathVariable Long id) {
        return taskModelService.findById(id);
    }

    /**
     * Method to add a new task
     * 
     * @param taskModel
     * 
     * @return new task added
     */
    @PostMapping
    public TaskModel addTask(@RequestBody TaskModel taskModel) {
        return taskModelService.saveTask(taskModel);
    }

    /**
     * Method to update existing task
     * 
     * @param taskModel
     * 
     * @return
     */
    @PutMapping()
    public TaskModel updateTask(@RequestBody TaskModel taskModel) {
       return taskModelService.saveTask(taskModel);
    }

    /**
     * Method to delete task
     * 
     * @param id
     * 
     * @return true when task is deleted
     */
    @DeleteMapping("{id}")
    public boolean deleteTask(@PathVariable Long id){
        return taskModelService.deleteTask(id);
    }
    
    
    

    
    
}
