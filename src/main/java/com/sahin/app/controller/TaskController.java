package com.sahin.app.controller;

import com.sahin.app.dto.TagDTO;
import com.sahin.app.dto.TaskDTO;
import com.sahin.app.payload.ApiDataResponse;
import com.sahin.app.payload.ApiResponse;
import com.sahin.app.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by M.Şahin on 05/01/2022
 */
@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {

    private final TaskService m_taskService;

    public TaskController(TaskService taskService)
    {
        m_taskService = taskService;
    }

    @GetMapping("/all")
    public ResponseEntity<ApiDataResponse<List<TaskDTO>>> getAll()
    {
        return new ResponseEntity<>(
                new ApiDataResponse<>(m_taskService.getAllTasks(),Boolean.TRUE,"Successful"),
                HttpStatus.OK);
    }

    @GetMapping("/id")
    public ApiDataResponse<TaskDTO> getTask(Long id)
    {
        var taskDTO = m_taskService.getTaskById(id);
        if (taskDTO == null)
            return new ApiDataResponse<>(new TaskDTO(),Boolean.FALSE,"No task available with given id",HttpStatus.NOT_FOUND);

        return new ApiDataResponse<>(taskDTO,Boolean.TRUE,"Success",HttpStatus.FOUND);
    }

    @PutMapping("/id")
    public ApiDataResponse<TaskDTO> updateTask(@RequestParam Long id, @RequestBody TaskDTO taskDTO)
    {
        var taskDTOUpdated =  m_taskService.updateTask(id,taskDTO);

        if (taskDTOUpdated == null)
            return new ApiDataResponse<>(new TaskDTO(),
                    Boolean.FALSE,
                    "No task available with given id",
                    HttpStatus.NOT_FOUND);

        return new ApiDataResponse<>(taskDTOUpdated,Boolean.TRUE,"Updated Successfully.",HttpStatus.FOUND);

    }

    @DeleteMapping( "/id")
    public ResponseEntity<ApiResponse> deleteTask(Long id)
    {
        if (m_taskService.deleteTask(id) == null)
            return new ResponseEntity<>(new ApiResponse(Boolean.FALSE,"Fail"),HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(new ApiResponse(Boolean.TRUE,"Successful"),HttpStatus.NO_CONTENT);
    }
}
