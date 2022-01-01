package com.sahin.app.bootstrap.runner;

import com.sahin.app.service.RegistrationService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

/**
 * Created by M.Şahin on 01/01/2022
 */
@Service
public class DefaultUserRunner implements ApplicationRunner {

    private final RegistrationService m_registrationService;

    public DefaultUserRunner(RegistrationService registrationService)
    {
        m_registrationService = registrationService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        m_registrationService.registerWithAdminRole(UserFactory.create());
    }
}
