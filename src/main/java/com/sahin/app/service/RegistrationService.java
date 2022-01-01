package com.sahin.app.service;

import com.sahin.app.dto.RegistrationDTO;
import com.sahin.app.model.User;
import com.sahin.app.model.UserRole;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by M.Şahin on 01/01/2022
 */
@Service
public class RegistrationService {

    private final UserService m_userService;

    public RegistrationService(UserService userService)
    {
        m_userService = userService;
    }

    public User registerWithUserRole(RegistrationDTO request)
    {
        return  m_userService.signUpUser(new User(
                request.getFirstName(),
                request.getLastName(),
                request.getUserName(),
                request.getEmail(),
                request.getPassword()));

    }
    public User registerWithAdminRole(User user)
    {
        return  m_userService.signUpUser(user);
    }

}
