package org.wecancodeit.todotask.Services;

import org.springframework.stereotype.Service;
import org.wecancodeit.todotask.Models.TaskModel;

@Service
public class BaseService {

    public static boolean isValidTask(TaskModel task){
        return true;
    }
    
}
