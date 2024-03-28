package org.wecancodeit.todotask;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.todotask.Models.TaskModel;
import org.wecancodeit.todotask.Models.Enums.CategoryEnum;
import org.wecancodeit.todotask.Models.Enums.PriorityEnum;
import org.wecancodeit.todotask.Services.TaskModelService;

import jakarta.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource // ADD ALL THE SERVICES HERE, SO WE CAN POPULATE OUR DATABASE
    private final TaskModelService taskModelService;

    //then generate const w/ all services (only 1 in this instance)
     public Populator(TaskModelService taskModelService) {
        this.taskModelService = taskModelService;
    }
    

    @Override
    public void run(String... args) throws Exception {
       TaskModel taskModel = new TaskModel("Call the plumber", false, PriorityEnum.THISWEEK, CategoryEnum.HOME, null);
       taskModelService.saveTask(taskModel);

       TaskModel taskModel2 = new TaskModel("finish assignment", false, PriorityEnum.EOD, CategoryEnum.WORK, null);
       taskModelService.saveTask(taskModel2);

       TaskModel taskModel3 = new TaskModel("buy bday card", false, PriorityEnum.WEEKEND, CategoryEnum.SOCIAL_LIFE, null);
       taskModelService.saveTask(taskModel3);

       TaskModel taskModel4 = new TaskModel("research pet foods", false, PriorityEnum.OPEN_ENDED, CategoryEnum.PETS, null);
       taskModelService.saveTask(taskModel4);
    }

   
}
