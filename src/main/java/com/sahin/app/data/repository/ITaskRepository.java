package com.sahin.app.data.repository;

import com.sahin.app.data.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by M.Şahin on 04/01/2022
 */
@Repository
public interface ITaskRepository extends JpaRepository<Task,Long> {
}
