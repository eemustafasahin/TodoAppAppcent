package com.sahin.app.model;

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

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "todo_id",nullable = false)
    private Todo todo;

}
