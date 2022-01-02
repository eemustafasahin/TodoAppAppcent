package com.sahin.app.data.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by M.Şahin on 01/01/2022
 */
@Entity
@Table(name = "tags")
public class Tag implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;

    @Column(name = "title")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id")
    private Todo todo;

    public Tag()
    {

    }

    public Tag(String name)
    {
        this.name = name;
    }

    public Tag(Long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Tag(Long id, String name, Todo todo)
    {
        this.id = id;
        this.name = name;
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

    public String getName()
    {
        return name;
    }

    public void setName(String title)
    {
        this.name = title;
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

        return id != null && id.equals(((Tag)object).id);
    }

    @Override
    public int hashCode()
    {
        return 2022;
    }

    @Override
    public String toString()
    {
        return String.format("Category {id : %d,title : '%s'}",getId(), getName());
    }
}
