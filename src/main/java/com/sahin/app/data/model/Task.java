package com.sahin.app.data.model;

import javax.persistence.*;

/**
 * Created by M.Şahin on 01/01/2022
 */
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id")
    private Todo todo;

    public Task()
    {

    }

    public Task(String title, String description)
    {
        this.title = title;
        this.description = description;
    }

    public Task(String title, String description, Todo todo)
    {
        this.title = title;
        this.description = description;
        this.todo = todo;
    }

    public Task(Long id, String title, String description, Todo todo)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.todo = todo;
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Todo getTodo()
    {
        return todo;
    }

    public void setTodo(Todo todo)
    {
        this.todo = todo;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
            return true;

        if (null == object)
            return false;

        if (this.getClass() != object.getClass())
            return false;

        return id != null && id.equals(((Task)object).id);
    }

    @Override
    public int hashCode()
    {
        return 2022;
    }

    @Override
    public String toString()
    {
        return String.format("Category {id : %d,title : '%s'}",getId(),getTitle());
    }
}
