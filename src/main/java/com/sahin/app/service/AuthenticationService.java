package com.sahin.app.service;

import com.sahin.app.payload.ApiResponse;
import com.sahin.app.payload.SignupRequest;
import com.sahin.app.data.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by M.Şahin on 01/01/2022
 */
@Service
public class AuthenticationService {

    private final UserService m_userService;

    public AuthenticationService(UserService userService)
    {
        m_userService = userService;
    }

    public ApiResponse registerWithUserRole(SignupRequest request)
    {
        return  m_userService.signUpUser(new User(
                request.getFirstName(),
                request.getLastName(),
                request.getUserName(),
                request.getEmail(),
                request.getPassword()));

    }
    public ApiResponse registerWithAdminRole(User user)
    {
        return  m_userService.signUpUser(user);
    }

}
