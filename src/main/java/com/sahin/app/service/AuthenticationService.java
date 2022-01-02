package com.sahin.app.service;

import com.sahin.app.dto.UserDTO;
import com.sahin.app.dto.UserDTOConverter;
import com.sahin.app.payload.ApiDataResponse;
import com.sahin.app.data.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by M.Şahin on 01/01/2022
 */
@Service
public class AuthenticationService {

    private final UserService m_userService;
    private final UserDTOConverter m_userDTOConverter;

    public AuthenticationService(UserService userService, UserDTOConverter userDTOConverter)
    {
        m_userService = userService;
        m_userDTOConverter = userDTOConverter;
    }

    public ApiDataResponse<UserDTO> registerUserWithUserRole(UserDTO userDTO)
    {

        return m_userService.saveUser(m_userDTOConverter.toUser(userDTO));

    }
    public ApiDataResponse<UserDTO> registerUserWithAdminRole(User user)
    {
        return  m_userService.saveUser(user);
    }

}
