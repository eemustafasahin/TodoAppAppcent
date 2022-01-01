package com.sahin.app.service;

import com.sahin.app.model.User;
import com.sahin.app.model.UserRole;
import com.sahin.app.repository.IUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by M.Şahin on 01/01/2022
 */
@Service
public class UserService implements UserDetailsService {

    private final static String exceptionMsg = "User with this username or email not found %s";

    private final IUserRepository m_userRepository;
    private final BCryptPasswordEncoder m_passwordEncoder;

    public UserService(IUserRepository userRepository, BCryptPasswordEncoder passwordEncoder)
    {
        m_userRepository = userRepository;
        m_passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException
    {
        return m_userRepository
                .findByUsernameOrEmail(usernameOrEmail,usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format(exceptionMsg,usernameOrEmail)));
    }

    public User signUpUser(User user)
    {
        boolean userExists = m_userRepository.existsByEmail(user.getEmail());

        if (userExists)
            throw new IllegalStateException("Email is already taken.");

        user.setUserRole(UserRole.USER_ROLE);
        user.setPassword(m_passwordEncoder.encode(user.getPassword()));
        m_userRepository.save(user);

        return user;
    }
}
