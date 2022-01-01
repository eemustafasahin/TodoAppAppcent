package com.sahin.app.bootstrap.runner;

import com.sahin.app.bootstrap.UserFactory;
import com.sahin.app.service.AuthenticationService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

/**
 * Created by M.Şahin on 01/01/2022
 */
@Service
public class DefaultUserRunner implements ApplicationRunner {

    private final AuthenticationService m_authenticationService;

    public DefaultUserRunner(AuthenticationService authenticationService)
    {
        m_authenticationService = authenticationService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        m_authenticationService.registerWithAdminRole(UserFactory.create());
    }
}
