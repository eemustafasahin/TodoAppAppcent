package com.sahin.app.service;

import com.sahin.app.data.repository.ITaskRepository;
import com.sahin.app.dto.TaskDTO;
import com.sahin.app.dto.TaskDTOConverter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by M.Şahin on 05/01/2022
 */
@Component
public class TaskService {

    private final ITaskRepository m_taskRepository;
    private final TaskDTOConverter m_taskDTOConverter;

    public TaskService(ITaskRepository taskRepository, TaskDTOConverter taskDTOConverter)
    {
        m_taskRepository = taskRepository;
        m_taskDTOConverter = taskDTOConverter;
    }

    public List<TaskDTO> getAllTasks()
    {
        return m_taskRepository.findAll().stream().map(m_taskDTOConverter::toTaskDTO).collect(Collectors.toList());
    }

    public TaskDTO getTaskById(Long id)
    {
        return m_taskRepository.findById(id).map(m_taskDTOConverter::toTaskDTO).orElse(null);
    }

    public TaskDTO updateTask(Long id,TaskDTO taskDTO)
    {
        var taskOpt = m_taskRepository.findById(id);

        if (taskOpt.isEmpty())
            return null;

        var taskUpdated = taskOpt.get();

        var task = m_taskDTOConverter.toTask(taskDTO);
        taskUpdated.setTitle(task.getTitle());
        taskUpdated.setDescription(task.getDescription());

        var savedTask = m_taskRepository.save(taskUpdated);

        return m_taskDTOConverter.toTaskDTO(savedTask);
    }

    public TaskDTO deleteTask(Long id)
    {
        var taskOpt = m_taskRepository.findById(id);

        if (taskOpt.isEmpty())
            return null;

        var taskDeleted = taskOpt.get();
        m_taskRepository.delete(taskDeleted);

        return m_taskDTOConverter.toTaskDTO(taskDeleted);
    }
}
