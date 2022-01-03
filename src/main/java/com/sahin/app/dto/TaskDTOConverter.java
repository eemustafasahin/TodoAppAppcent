package com.sahin.app.dto;

import com.sahin.app.data.model.Task;
import org.springframework.stereotype.Component;

/**
 * Created by M.Şahin on 02/01/2022
 */
@Component
public class TaskDTOConverter {

    public Task toTask(TaskDTO taskDTO)
    {
        if (taskDTO == null)
            return null;

        var task = new Task();

        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());

        return task;
    }

    public TaskDTO toTaskDTO(Task task)
    {
        if (task == null)
            return null;

        var taskDTO = new TaskDTO();

        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());

        return taskDTO;
    }
}
