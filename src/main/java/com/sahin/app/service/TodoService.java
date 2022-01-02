package com.sahin.app.service;

import com.sahin.app.data.model.User;
import com.sahin.app.data.repository.ITodoRepository;
import com.sahin.app.data.repository.IUserRepository;
import com.sahin.app.dto.TodoDTO;
import com.sahin.app.dto.TodoDTOConverter;
import com.sahin.app.security.CurrentUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Created by M.Şahin on 02/01/2022
 */
@Service
public class TodoService {

    private final ITodoRepository m_todoRepository;
    private final TodoDTOConverter m_todoDTOConverter;
    private final IUserRepository m_userRepository;

    public TodoService(ITodoRepository todoRepository, TodoDTOConverter todoDTOConverter, IUserRepository userRepository)
    {
        m_todoRepository = todoRepository;
        m_todoDTOConverter = todoDTOConverter;
        m_userRepository = userRepository;
    }

    public TodoDTO saveTodo(TodoDTO todoDTO,String principal)
    {
        var todo = m_todoDTOConverter.toTodo(todoDTO);
        var currentUser = m_userRepository.findByUsername(principal);
        currentUser.get().addTodo(todo);
        var savedUser = m_userRepository.save(currentUser.get());

        return m_todoDTOConverter.toTodoDTO(m_todoRepository.getByUser(savedUser));
    }
}
