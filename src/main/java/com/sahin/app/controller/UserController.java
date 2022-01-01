package com.sahin.app.controller;

import com.sahin.app.dto.UserDTO;
import com.sahin.app.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by M.Şahin on 01/01/2022
 */
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService m_userService;

    public UserController(UserService userService)
    {
        m_userService = userService;
    }

    @GetMapping(path = "/me")
    public Object getCurrentUser()
    {
        return m_userService.getCurrentUser();
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers()
    {
        return m_userService.findAllUsers();
    }
}
