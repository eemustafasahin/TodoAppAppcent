package com.sahin.app.controller;

import com.sahin.app.model.User;
import com.sahin.app.repository.IUserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by M.Şahin on 01/01/2022
 */
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final IUserRepository m_userRepository;

    public UserController(IUserRepository userRepository)
    {
        m_userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<User> getAllUsers()
    {
        return m_userRepository.findAll().stream().collect(Collectors.toList());
    }
}
