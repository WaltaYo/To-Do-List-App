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
@RequestMapping("/")
public class TaskModelController {

  @Resource
  private final TaskModelService taskModelService;

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
   * @return index.html displaying all tasks
   */
  @GetMapping
  public String getAllTasks(Model model) {
    Iterable<TaskModel> task = taskModelService.findAll();
    model.addAttribute("tasks", task);
    return "index"; // adding it to index.html so we'll see all the tasks

  }

  /**
   * Method to get a task by id
   * 
   * @param id
   * 
   * @return  detail.html about specific task by iD
   */
  @GetMapping("{id}")
  public String getTask(@PathVariable Long id, Model model) {
    TaskModel task = taskModelService.findById(id);
    model.addAttribute("task", task);
    return "detail"; 
  }

  /**
   * Method to edit task
   * @param id selects task to be edited by iD
   * @param model
   * @return
   */
  @GetMapping("edit/{id}")
  public String editTask(@PathVariable Long id, Model model) {
    TaskModel task = taskModelService.findById(id);
    model.addAttribute("task", task);
    return "edit";
  }
 
  @GetMapping("delete/{id}")
  public String deleteTask(@PathVariable Long id, Model model) {
    TaskModel task = taskModelService.findById(id);
    model.addAttribute("task", task);
    return "confirmDelete";
  }

  @GetMapping("delete/confirmDelete/{id}")
  public String confirmDeleteTask(@PathVariable Long id) {
    taskModelService.deleteTask(id);
    return "redirect:/";
  } 
  
  @PostMapping
  public String saveTask(@ModelAttribute("task") TaskModel task) {
    taskModelService.saveTask(task);
    return "redirect:/";
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

  // /**
  // * Method to delete task
  // *
  // * @param id
  // *
  // * @return true when task is deleted
  // */
  // @DeleteMapping("{id}")
  // public boolean deleteTask(@PathVariable Long id){
  // return taskModelService.deleteTask(id);
  // }

}
