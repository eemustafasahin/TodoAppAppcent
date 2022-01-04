package com.sahin.app.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by M.Şahin on 01/01/2022
 */
@Entity
@Table(name = "categories")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Todo> todos = new HashSet<>();

    public Category()
    {

    }

    public Category(String name)
    {
        this.name = name;
    }

    public Category(Long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Category(Long id, String name, Set<Todo> todos)
    {
        this.id = id;
        this.name = name;
        this.todos = todos;
    }

    //getters, setters

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

    public void setName(String name)
    {
        this.name = name;
    }

    public Set<Todo> getTodos()
    {
        return todos;
    }

    public void setTodos(Set<Todo> todos)
    {
        this.todos = todos;
    }

    //equals, hashCode, toString

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
            return true;

        if (null == object)
            return false;

        if (this.getClass() != object.getClass())
            return false;

        return id != null && id.equals(((Category)object).id);
    }

    @Override
    public int hashCode()
    {
        return 2022;
    }

    @Override
    public String toString()
    {
        return String.format("Category {id : %d,name : '%s'}",getId(),getName());
    }
}
