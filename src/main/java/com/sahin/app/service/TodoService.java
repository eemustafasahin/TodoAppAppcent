package com.sahin.app.service;

import com.sahin.app.data.model.Todo;
import com.sahin.app.data.repository.*;
import com.sahin.app.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by M.Şahin on 02/01/2022
 */
@Service
public class TodoService {

    private final ITodoRepository m_todoRepository;
    private final TodoDTOConverter m_todoDTOConverter;
    private final IUserRepository m_userRepository;
    private final UserDTOConverter m_userDTOConverter;
    private final TagDTOConverter m_tagDTOConverter;
    private final CategoryDTOConverter m_categoryDTOConverter;
    private final TaskDTOConverter m_taskDTOConverter;
    private final ITagRepository m_TagRepository;
    private final ICategoryRepository m_CategoryRepository;
    private final ITaskRepository m_iTaskRepository;

    public TodoService(ITodoRepository todoRepository, TodoDTOConverter todoDTOConverter, IUserRepository userRepository, UserDTOConverter userDTOConverter, TagDTOConverter tagDTOConverter, CategoryDTOConverter categoryDTOConverter, TaskDTOConverter taskDTOConverter, ITagRepository tagRepository, ICategoryRepository categoryRepository, ITaskRepository TaskRepository)
    {
        m_todoRepository = todoRepository;
        m_todoDTOConverter = todoDTOConverter;
        m_userRepository = userRepository;
        m_userDTOConverter = userDTOConverter;
        m_tagDTOConverter = tagDTOConverter;
        m_categoryDTOConverter = categoryDTOConverter;
        m_taskDTOConverter = taskDTOConverter;
        m_TagRepository = tagRepository;
        m_CategoryRepository = categoryRepository;
        m_iTaskRepository = TaskRepository;
    }

    public TodoDTO saveTodo(TodoDTO todoDTO,String principal) //needs to be update for possible duplicates
    {
        var todo = m_todoDTOConverter.toTodo(todoDTO);

        todo.getTags().forEach(todo::addTag);
        todo.getTasks().forEach(todo::addTask);

        var currentUser = m_userRepository.findByUsername(principal);

        currentUser.orElseThrow(RuntimeException::new).addTodo(todo);

        var savedUser = m_userRepository.save(currentUser.get());

        return m_todoDTOConverter.toTodoDTO(m_todoRepository.getByUser(savedUser));
    }

    public TodoDTO updateTodo(Long id, TodoDTO todoDTO,String principal)
    {
        var todoOptional = m_todoRepository.findById(id);

        var todo = todoOptional.orElseThrow(() ->
                new RuntimeException(String.format("There is no todo with %d",id)));

        if (todoDTO == null)
            return m_todoDTOConverter.toTodoDTO(todo);

        var todoUpdated = m_todoDTOConverter.toTodo(todoDTO);

        todo.setTitle(todoUpdated.getTitle());
        todo.setCompleted(todoUpdated.isCompleted());

        //tags update
        todo.removeTags();
        todoUpdated.getTags().stream().forEach(todo::addTag);

        //tasks update
        todo.removeTasks();
        todoUpdated.getTasks().stream().forEach(todo::addTask);

        //categories update
        todo.removeCategories();
        todoUpdated.getCategories().stream().forEach(todo::addCategory);

        var todoSaved = m_todoRepository.save(todo);

        return m_todoDTOConverter.toTodoDTO(todoSaved);
    }

    public TodoDTO getTodoById(Long id)
    {
        return m_todoRepository.findById(id).map(m_todoDTOConverter::toTodoDTO).orElse(null);
    }

    public List<TodoDTO> getAllTodos()
    {
        return m_todoRepository.findAll()
                .stream()
                .map(m_todoDTOConverter::toTodoDTO)
                .collect(Collectors.toList());
    }

    public TodoDTO deleteTodo(Long id)
    {
        var todoOpt=  m_todoRepository.findById(id);

        if (todoOpt.isPresent()) {
            var todoDeleted = todoOpt.get();
            todoDeleted.removeCategories();
            m_todoRepository.delete(todoDeleted);
            return m_todoDTOConverter.toTodoDTO(todoDeleted);

        }
            return null;
    }
}
