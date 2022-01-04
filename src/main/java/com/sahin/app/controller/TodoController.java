package com.sahin.app.controller;



import com.sahin.app.data.repository.ITodoRepository;
import com.sahin.app.dto.TodoDTO;
import com.sahin.app.dto.TodoDTOConverter;
import com.sahin.app.payload.ApiDataResponse;
import com.sahin.app.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by M.Şahin on 02/01/2022
 */
@RestController
@RequestMapping("api/v1/todos")
public class TodoController {

    private final TodoService m_todoService;
    private final ITodoRepository m_todoRepository;
    private final TodoDTOConverter m_todoDTOConverter;

    public TodoController(TodoService todoService, ITodoRepository todoRepository, TodoDTOConverter todoDTOConverter)
    {
        m_todoService = todoService;
        m_todoRepository = todoRepository;
        m_todoDTOConverter = todoDTOConverter;
    }

    @GetMapping("/all")
    public List<TodoDTO> getAllTodos()
    {
        return m_todoRepository.findAll().stream().map(m_todoDTOConverter::toTodoDTO).collect(Collectors.toList());
    }

    @PostMapping("/add")
    public ResponseEntity<ApiDataResponse<TodoDTO>> addTodo(@RequestBody TodoDTO todoDTO)
    {
        String userName;

        try {
            userName = SecurityContextHolder.getContext().getAuthentication().getName();
            var savedTodoDTO = m_todoService.saveTodo(todoDTO,userName);

            //there is no null check

            return new ResponseEntity<>(new ApiDataResponse<>(savedTodoDTO,Boolean.TRUE,"Todo added successfully"), HttpStatus.OK);

        } catch (ClassCastException ignored) {
            return new ResponseEntity<>(new ApiDataResponse<>(new TodoDTO(),Boolean.FALSE,"There is no logged in user"),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/todoId")
    private ResponseEntity<ApiDataResponse<TodoDTO>> updateTodo(Long todoId , @RequestBody TodoDTO todoDTO)
    {
        String userName;

        try {
            userName = SecurityContextHolder.getContext().getAuthentication().getName();
            var updatedTodoDTO = m_todoService.updateTodo(todoId,todoDTO,userName);

            return new ResponseEntity<>(new ApiDataResponse<>(updatedTodoDTO,Boolean.TRUE,"Todo updated successfully"), HttpStatus.OK);

        } catch (ClassCastException ignored) {
            return new ResponseEntity<>(new ApiDataResponse<>(new TodoDTO(),Boolean.FALSE,"There is no logged in user"),HttpStatus.BAD_REQUEST);
        }
    }
}
