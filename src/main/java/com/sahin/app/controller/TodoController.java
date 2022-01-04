package com.sahin.app.controller;



import com.sahin.app.data.repository.ITodoRepository;
import com.sahin.app.dto.TodoDTO;
import com.sahin.app.dto.TodoDTOConverter;
import com.sahin.app.payload.ApiDataResponse;
import com.sahin.app.payload.ApiResponse;
import com.sahin.app.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by M.Şahin on 02/01/2022
 */
@RestController
@RequestMapping("api/v1/todos")
public class TodoController {

    private final TodoService m_todoService;
    private final TodoDTOConverter m_todoDTOConverter;

    public TodoController(TodoService todoService,TodoDTOConverter todoDTOConverter)
    {
        m_todoService = todoService;
        m_todoDTOConverter = todoDTOConverter;
    }

    @GetMapping("/id")
    public ResponseEntity<ApiDataResponse<TodoDTO>> getTodoById(Long id)
    {
        var todoDTO = m_todoService.getTodoById(id);
        if (todoDTO == null)
            return new ResponseEntity<>(new ApiDataResponse<>(new TodoDTO(),Boolean.FALSE,"To todo available",HttpStatus.NO_CONTENT),HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(new ApiDataResponse<>(todoDTO,Boolean.TRUE,"Successful",HttpStatus.FOUND),HttpStatus.FOUND);
    }

    @GetMapping("/all")
    public List<TodoDTO> getAllTodos()
    {
        return m_todoService.getAllTodos();
    }

    @PostMapping("/add")
    public ResponseEntity<ApiDataResponse<TodoDTO>> addTodo(@RequestBody TodoDTO todoDTO)
    {
        try {
            var userName = SecurityContextHolder.getContext().getAuthentication().getName();
            var savedTodoDTO = m_todoService.saveTodo(todoDTO,userName);

            return new ResponseEntity<>(new ApiDataResponse<>(savedTodoDTO,Boolean.TRUE,"Todo added successfully"), HttpStatus.OK);

        } catch (Throwable ignored) {
            return new ResponseEntity<>(new ApiDataResponse<>(new TodoDTO(),Boolean.FALSE,"Todo could not be added"),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/todoId")
    public ResponseEntity<ApiDataResponse<TodoDTO>> updateTodo(Long todoId , @RequestBody TodoDTO todoDTO)
    {
        try {
            var userName = SecurityContextHolder.getContext().getAuthentication().getName();
            var updatedTodoDTO = m_todoService.updateTodo(todoId,todoDTO,userName);

            return new ResponseEntity<>(new ApiDataResponse<>(updatedTodoDTO,Boolean.TRUE,"Todo updated successfully"), HttpStatus.OK);

        } catch (Throwable ignored) {
            return new ResponseEntity<>(new ApiDataResponse<>(new TodoDTO(),Boolean.FALSE,"Update is failed."),HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping(value = "/id")
    public ResponseEntity<ApiResponse> deleteTodo(Long id)
    {
        if (m_todoService.deleteTodo(id) == null)
            return new ResponseEntity<>(new ApiResponse(Boolean.FALSE,"Fail"),HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(new ApiResponse(Boolean.TRUE,"Successful"),HttpStatus.NO_CONTENT);
    }
}
