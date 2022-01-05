package com.sahin.app.data.repository;

import com.sahin.app.data.model.Tag;
import com.sahin.app.data.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by M.Şahin on 04/01/2022
 */
@Repository
public interface ITagRepository extends JpaRepository<Tag,Long> {

    Iterable<Tag> findTagsByTodoId(Long id);
}
