package com.sahin.app.data.model;

import javax.persistence.*;

/**
 * Created by M.Şahin on 01/01/2022
 */
@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id")
    private Todo todo;

    public Tag()
    {

    }

    public Tag(String title)
    {
        this.title = title;
    }

    public Tag(Long id, String title)
    {
        this.id = id;
        this.title = title;
    }

    public Tag(Long id, String title, Todo todo)
    {
        this.id = id;
        this.title = title;
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
        return String.format("Category {id : %d,title : '%s'}",getId(),getTitle());
    }
}
