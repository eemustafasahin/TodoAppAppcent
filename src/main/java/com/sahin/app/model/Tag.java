package com.sahin.app.model;

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

    @Column(name = "title",nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "todo_id",nullable = false)
    private Todo todo;

}
