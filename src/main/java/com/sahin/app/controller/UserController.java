package com.sahin.app.controller;

import com.sahin.app.data.model.User;
import com.sahin.app.dto.UserDTO;
import com.sahin.app.dto.UserDTOConverter;
import com.sahin.app.payload.ApiDataResponse;
import com.sahin.app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by M.Şahin on 01/01/2022
 */
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService m_userService;
    private final UserDTOConverter m_userDTOConverter;

    public UserController(UserService userService, UserDTOConverter userDTOConverter)
    {
        m_userService = userService;
        m_userDTOConverter = userDTOConverter;
    }

    @GetMapping(path = "/me")
    public UserDTO getCurrentUser()
    {
        try {
            var userPrincipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            var user = (User) userPrincipal;

            return m_userDTOConverter.toUserDTO(user);

        } catch (ClassCastException ignored) {
            return new UserDTO();
        }
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers()
    {
        return m_userService.findAllUsers();
    }


    @GetMapping("/id")
    public ApiDataResponse<UserDTO> getUserById(@RequestParam(name = "id") Long userId)
    {
        var userDTO = m_userService.findUserById(userId);

        if (userDTO != null)
            return new ApiDataResponse<>(userDTO,Boolean.TRUE,"Success",HttpStatus.OK);

        return new ApiDataResponse<>(new UserDTO(),Boolean.FALSE,"No user available", HttpStatus.NO_CONTENT);
    }
}
