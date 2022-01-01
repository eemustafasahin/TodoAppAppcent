package com.sahin.app.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by M.Şahin on 01/01/2022
 */
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Todo> todos;
}
