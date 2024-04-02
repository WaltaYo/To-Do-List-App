package org.wecancodeit.todotask.Services;

import java.util.*;

import org.springframework.stereotype.Service;
import org.wecancodeit.todotask.Models.TaskModel;
import org.wecancodeit.todotask.Repositories.TaskModelRepository;

import jakarta.annotation.Resource;

@Service
public class TaskModelService {

    @Resource
    private TaskModelRepository taskModelRepository;
   

    /**
     * Defualt constructor
     */
    public TaskModelService() {
    }

    /**
     * Parametarized constructor
     * 
     * @param taskModelRepository
     */
    public TaskModelService(TaskModelRepository taskModelRepository) {
        this.taskModelRepository = taskModelRepository;
    }

    /**
     * Method to find all tasks
     * 
     * @return all tasks
     */
    public Iterable<TaskModel> findAll() {
        Iterable<TaskModel> tasks = new ArrayList<>();
        try {
            tasks = taskModelRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return tasks;
    }

    /**
     * Method to find task by id
     * @param id
     * 
     * @return task by id
     */
    public TaskModel findById(Long id) {
        TaskModel task = null;
        try {
            Optional<TaskModel> optTask = taskModelRepository.findById(id);
            if (optTask.isPresent()) {
                task = optTask.get();
            }
        } catch (Exception ex) {
            throw ex;
        }
        return task;
    }

    /**
     * Method to save a task
     * 
     * @param task
     * 
     * @return saved task
     */
    public TaskModel saveTask(TaskModel task) {
        try {
            if (BaseService.isValidTask(task)) {
                task = taskModelRepository.save(task);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return task;
    }

    /**
     * Method to delete task
     * 
     * @param id
     * 
     * @return
     */
    public boolean deleteTask(Long id) {
        boolean result = false;
        try {
            taskModelRepository.deleteById(id);
            Optional<TaskModel> optTask = taskModelRepository.findById(id);
            if (!optTask.isPresent()) {
                result = true;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

   
}
