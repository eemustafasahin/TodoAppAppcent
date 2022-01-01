package com.sahin.app.service;

import com.sahin.app.dto.RegistrationDTO;
import com.sahin.app.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by M.Şahin on 01/01/2022
 */
@Service
public class RegistrationService {

    private final UserService m_userService;
    private final BCryptPasswordEncoder m_passwordEncoder;

    public RegistrationService(UserService userService, BCryptPasswordEncoder passwordEncoder)
    {
        m_userService = userService;

        m_passwordEncoder = passwordEncoder;
    }

    public User register(RegistrationDTO request)
    {

        return  m_userService.signUpUser(new User(
                request.getFirstName(),
                request.getLastName(),
                request.getUserName(),
                request.getEmail(),
                request.getPassword()));

    }
}
