package org.wecancodeit.todotask.Controllers;

import jakarta.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.todotask.Models.TaskDto;
import org.wecancodeit.todotask.Models.TaskModel;
import org.wecancodeit.todotask.Models.Enums.CategoryEnum;
import org.wecancodeit.todotask.Models.Enums.PriorityEnum;
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
   * @return detail.html about specific task by iD
   */
  @GetMapping("{id}")
  public String getTask(@PathVariable Long id, Model model) {
    TaskModel task = taskModelService.findById(id);
    model.addAttribute("task", task);
    return "detail";
  }

  /**
   * Method to edit task
   * 
   * @param id    selects task to be edited by iD
   * @param model
   * @return
   */

  @GetMapping("create")
  public String createTask(Model model) {
    TaskDto task = new TaskDto();
    model.addAttribute("task", task);

    List<String> lstCategory = enumToList(CategoryEnum.class);
    model.addAttribute("lstCategory", lstCategory);

    List<String> lstPriority = enumToList(PriorityEnum.class);
    model.addAttribute("lstPriority", lstPriority);
    return "edit";
  }

  @GetMapping("edit/{id}")
  public String editTask(@PathVariable Long id, Model model) {
    // find task by task id
    TaskModel tasks = taskModelService.findById(id);

    // put task into TaskDTO
    TaskDto task = new TaskDto(tasks);
    model.addAttribute("task", task);

    List<String> lstCategory = enumToList(CategoryEnum.class);
    model.addAttribute("lstCategory", lstCategory);

    List<String> lstPriority = enumToList(PriorityEnum.class);
    model.addAttribute("lstPriority", lstPriority);
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
  public String saveTask(@ModelAttribute("task") TaskDto task) {
    taskModelService.saveTask(task.CopyTask());
    return "redirect:/";
  }

  // convert enum to Strings, so we have a list
  public <T extends Enum<T>> List<String> enumToList(Class<T> class1) {
    List<String> list = new ArrayList<>();
    T[] enumConstants = class1.getEnumConstants();
    for (T enumConstant : enumConstants) {
      list.add(enumConstant.name());
    }
    return list;
  }

}
