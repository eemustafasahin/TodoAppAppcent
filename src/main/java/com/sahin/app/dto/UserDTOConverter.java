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

        return userDTO;
    }

    public User toUserModel(UserDTO userDTO)
    {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
}
