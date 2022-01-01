package com.sahin.app.controller;

import com.sahin.app.model.User;
import com.sahin.app.dto.RegistrationDTO;
import com.sahin.app.service.RegistrationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by M.Şahin on 01/01/2022
 */
@RestController
@RequestMapping(path = "api/v1/registration")
public class RegistrationController {

    private final RegistrationService m_registrationService;

    public RegistrationController(RegistrationService registrationService)
    {
        m_registrationService = registrationService;
    }

    @PostMapping
    public User register(@RequestBody RegistrationDTO request)
    {
        return m_registrationService.register(request);
    }

}
