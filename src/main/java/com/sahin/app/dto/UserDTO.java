package com.sahin.app.dto;

/**
 * Created by M.Şahin on 01/01/2022
 */
public class UserDTO {
    private Long m_id;
    private String m_username;
    private String m_firstname;
    private String m_lastname;
    private String m_email;

    public Long getId()
    {
        return m_id;
    }

    public void setId(Long id)
    {
        m_id = id;
    }

    public String getUsername()
    {
        return m_username;
    }

    public void setUsername(String username)
    {
        m_username = username;
    }

    public String getFirstname()
    {
        return m_firstname;
    }

    public void setFirstname(String firstname)
    {
        m_firstname = firstname;
    }

    public String getLastname()
    {
        return m_lastname;
    }

    public void setLastname(String lastname)
    {
        m_lastname = lastname;
    }

    public String getEmail()
    {
        return m_email;
    }

    public void setEmail(String email)
    {
        m_email = email;
    }
}
