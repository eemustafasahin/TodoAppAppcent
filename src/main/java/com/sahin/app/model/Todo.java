package com.sahin.app.model;

import com.sun.xml.bind.v2.TODO;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by M.Şahin on 01/01/2022
 */
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "creation_time")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "completed")
    private boolean completed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "todo",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Task> tasks = new HashSet<>();

    @OneToMany(mappedBy = "todo", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Tag> tags = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "task_categories",
            joinColumns = @JoinColumn(name = "todo_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    public Todo ()
    {

    }

    public Todo(String title, User user)
    {
        this.title = title;
        this.user = user;
    }

    public Todo(String title, LocalDateTime createdAt, boolean completed, User user)
    {
        this.title = title;
        this.createdAt = createdAt;
        this.completed = completed;
        this.user = user;
    }

    public Todo(String title, LocalDateTime createdAt, boolean completed, User user, Set<Task> tasks, Set<Tag> tags, Set<Category> categories)
    {
        this.title = title;
        this.createdAt = createdAt;
        this.completed = completed;
        this.user = user;
        this.tasks = tasks;
        this.tags = tags;
        this.categories = categories;
    }

    public Todo(Long id, String title, LocalDateTime createdAt, boolean completed, User user, Set<Task> tasks, Set<Tag> tags, Set<Category> categories)
    {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.completed = completed;
        this.user = user;
        this.tasks = tasks;
        this.tags = tags;
        this.categories = categories;
    }

    //task helper methods
    public void addTask(Task task)
    {
        tasks.add(task);
        task.setTodo(this);
    }

    public void removeTask(Task task)
    {
        task.setTodo(null);
        tasks.add(task);
    }

    public void removeTasks()
    {
        tasks.forEach(this::removeTask);
    }

    //tags helper methods
    public void addTag(Tag tag)
    {
        tags.add(tag);
        tag.setTodo(this);
    }

    public void removeTag(Tag tag)
    {
        tag.setTodo(null);
        tags.remove(tag);
    }

    public void removeTag()
    {
        tags.forEach(this::removeTag);
    }

    //category helper methods
    public void addCategory(Category category)
    {
        categories.add(category);
        category.getTodos().add(this);
    }

    public void removeCategory(Category category)
    {
        categories.remove(category);
        category.getTodos().remove(this);
    }

    public void removeCategories()
    {
        categories.forEach(category -> {
            removeCategory(category);
            category.getTodos().remove(this);
        });
    }

    //getters,setters
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt)
    {
        this.createdAt = createdAt;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Set<Task> getTasks()
    {
        return tasks;
    }

    public void setTasks(Set<Task> tasks)
    {
        this.tasks = tasks;
    }

    public Set<Tag> getTags()
    {
        return tags;
    }

    public void setTags(Set<Tag> tags)
    {
        this.tags = tags;
    }

    public Set<Category> getCategories()
    {
        return categories;
    }

    public void setCategories(Set<Category> categories)
    {
        this.categories = categories;
    }

    //equals,hashCode,toString
    @Override
    public boolean equals(Object object)
    {
        if (this == object)
            return true;

        if (null == object)
            return false;

        if (this.getClass() != object.getClass())
            return false;

        return id != null && id.equals(((Todo)object).id);
    }

    @Override
    public int hashCode()
    {
        return 2022;
    }

    @Override
    public String toString()
    {
        var dateTimePattern = DateTimeFormatter.ofPattern("dd/MM/yyyy ss:mm:hh");

        String todoStr = String.format("id : %d, title : '%s', createdAt : '%s', completed : '%s'",
                getId(),getTitle(),dateTimePattern.format(getCreatedAt()),isCompleted() ? "Yes" : "No");

        return todoStr;
    }
}
