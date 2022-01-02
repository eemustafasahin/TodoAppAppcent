package com.sahin.app.dto;

import com.sahin.app.data.model.Todo;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by M.Şahin on 02/01/2022
 */
@Component
public class TodoDTOConverter {

    private final UserDTOConverter m_userDTOConverter;
    private final TaskDTOConverter m_taskDTOConverter;
    private final TagDTOConverter m_tagDTOConverter;
    private final CategoryDTOConverter m_categoryDTOConverter;

    public TodoDTOConverter(UserDTOConverter userDTOConverter, TaskDTOConverter taskDTOConverter, TagDTOConverter tagDTOConverter, CategoryDTOConverter categoryDTOConverter)
    {

        m_userDTOConverter = userDTOConverter;
        m_taskDTOConverter = taskDTOConverter;
        m_tagDTOConverter = tagDTOConverter;
        m_categoryDTOConverter = categoryDTOConverter;
    }

    public TodoDTO toTodoDTO(Todo todo)
    {
        var todoDTO = new TodoDTO();

        todoDTO.setId(todo.getId());
        todoDTO.setTitle(todo.getTitle());
        todoDTO.setCreatedAt(todo.getCreatedAt());
        todoDTO.setUserDTO(m_userDTOConverter.toUserDTO(todo.getUser()));
        todoDTO.setTaskDTOSet(todo.getTasks()
                .stream()
                .filter(Objects::nonNull)
                .map(m_taskDTOConverter::toTaskDTO)
                .collect(Collectors.toSet()));
        todoDTO.setTagDTOSet(todo.getTags()
                .stream()
                .filter(Objects::nonNull)
                .map(m_tagDTOConverter::toTagDTO)
                .collect(Collectors.toSet()));
        todoDTO.setCategoryDTOSet(todo.getCategories()
                .stream()
                .filter(Objects::nonNull)
                .map(m_categoryDTOConverter::toCategoryDTO)
                .collect(Collectors.toSet()));

        return todoDTO;
    }

    public Todo toTodo(TodoDTO todoDTO)
    {
        var todo = new Todo();

        todo.setTitle(todoDTO.getTitle());
        todo.setCompleted(todoDTO.getCompleted());
        todo.setTasks(todoDTO.getTaskDTOSet()
                .stream()
                .filter(Objects::nonNull)
                .map(m_taskDTOConverter::toTask)
                .collect(Collectors.toSet()));
        todo.setTags(todoDTO.getTagDTOSet()
                .stream()
                .filter(Objects::nonNull)
                .map(m_tagDTOConverter::toTag).collect(Collectors.toSet()));
        todo.setCategories(todoDTO.getCategoryDTOSet()
                .stream()
                .filter(Objects::nonNull)
                .map(m_categoryDTOConverter::toCategory)
                .collect(Collectors.toSet()));

        return todo;
    }
}
