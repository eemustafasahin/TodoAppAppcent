package com.sahin.app.data.repository;

import com.sahin.app.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by M.Şahin on 01/01/2022
 */

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsernameOrEmail(String username,String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
