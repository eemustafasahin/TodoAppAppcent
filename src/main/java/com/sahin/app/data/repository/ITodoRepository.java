package com.sahin.app.data.repository;

import com.sahin.app.data.model.Todo;
import com.sahin.app.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by M.Şahin on 02/01/2022
 */
@Repository
public interface ITodoRepository extends JpaRepository<Todo,Long> {
    public Todo getByUser(User user);
}
