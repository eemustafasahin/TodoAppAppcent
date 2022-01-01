package com.sahin.app.bootstrap;

import com.sahin.app.data.model.User;
import com.sahin.app.data.model.UserRole;

/**
 * Created by M.Şahin on 01/01/2022
 */
public class UserFactory {
    public static User create()
    {
        var defaultUser = new User();

        defaultUser.setFirstname("spring");
        defaultUser.setLastname("framework");
        defaultUser.setUsername("springboot");
        defaultUser.setEmail("spring.framework@boot.com");
        defaultUser.setPassword("HelloSpring");
        defaultUser.setUserRole(UserRole.ADMIN_ROLE);

        return defaultUser;
    }
}