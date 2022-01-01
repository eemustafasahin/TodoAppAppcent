package com.sahin.app.service;

import com.sahin.app.data.model.User;
import com.sahin.app.data.repository.IUserRepository;
import com.sahin.app.dto.UserDTO;
import com.sahin.app.dto.UserDTOConverter;
import com.sahin.app.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by M.Şahin on 01/01/2022
 */
@Service
public class UserService implements UserDetailsService {

    private final static String exceptionMsg = "User with this username or email not found %s";

    private final IUserRepository m_userRepository;
    private final BCryptPasswordEncoder m_passwordEncoder;
    private final UserDTOConverter m_userDTOConverter;

    public UserService(IUserRepository userRepository, BCryptPasswordEncoder passwordEncoder, UserDTOConverter userDTOConverter)
    {
        m_userRepository = userRepository;
        m_passwordEncoder = passwordEncoder;
        m_userDTOConverter = userDTOConverter;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException
    {
        return m_userRepository
                .findByUsernameOrEmail(usernameOrEmail,usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format(exceptionMsg,usernameOrEmail)));
    }

    public ApiResponse signUpUser(User user)
    {
        boolean userExists = m_userRepository.existsByEmail(user.getEmail());

        if (userExists)
            throw new IllegalStateException("Email is already taken."); //wrap api response here

        user.setPassword(m_passwordEncoder.encode(user.getPassword()));
        m_userRepository.save(user);

        return new ApiResponse(Boolean.TRUE,"Successfully registered", HttpStatus.OK);
    }

    public List<UserDTO> findAllUsers()
    {
        return m_userRepository.findAll().stream().map(m_userDTOConverter::toUserDTO)
                .collect(Collectors.toList());
    }

    public Object getCurrentUser()
    {
        var currentUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
                //when Anonymous Authentication is enabled
                !(SecurityContextHolder.getContext().getAuthentication()
                        instanceof AnonymousAuthenticationToken) ) {
            User user = (User) currentUser;
            return m_userDTOConverter.toUserDTO(user);
        }

        return "Anonymous User";
    }
}
