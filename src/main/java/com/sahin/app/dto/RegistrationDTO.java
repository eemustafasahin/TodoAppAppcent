package com.sahin.app.dto;

import java.util.Objects;

/**
 * Created by M.Şahin on 01/01/2022
 */
public class RegistrationDTO {
    private final String m_firstName;
    private final String m_lastName;
    private final String m_userName;
    private final String m_email;
    private final String m_password;

    public RegistrationDTO(String firstName, String lastName, String userName, String email, String password)
    {
        m_firstName = firstName;
        m_lastName = lastName;
        m_userName = userName;
        m_email = email;
        m_password = password;
    }

    public String getFirstName()
    {
        return m_firstName;
    }

    public String getLastName()
    {
        return m_lastName;
    }

    public String getUserName()
    {
        return m_userName;
    }

    public String getEmail()
    {
        return m_email;
    }

    public String getPassword()
    {
        return m_password;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationDTO that = (RegistrationDTO) o;
        return Objects.equals(m_firstName, that.m_firstName) && Objects.equals(m_lastName, that.m_lastName) && Objects.equals(m_email, that.m_email);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(m_firstName, m_lastName, m_email);
    }
}
