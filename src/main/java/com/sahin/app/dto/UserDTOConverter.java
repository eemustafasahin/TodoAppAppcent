package com.sahin.app.dto;

import com.sahin.app.data.model.User;
import org.springframework.stereotype.Component;

/**
 * Created by M.Şahin on 01/01/2022
 */
@Component
public class UserDTOConverter {

    public UserDTO toUserDTO(User user)
    {
        var userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }

    public User toUser(UserDTO userDTO)
    {
        var user = new User();

        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return user;

    }
}
