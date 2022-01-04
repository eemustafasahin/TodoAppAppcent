package com.sahin.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Created by M.Şahin on 01/01/2022
 */
@JsonPropertyOrder({"id","firstname","lastname","username","email","password"})
public class UserDTO {
    private Long m_id;
    private String m_username;
    private String m_firstname;
    private String m_lastname;
    private String m_email;
    private String m_password;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Long getId()
    {
        return m_id;
    }

    public void setId(Long id)
    {
        m_id = id;
    }

    @Schema(example = "tuzludondurma")
    public String getUsername()
    {
        return m_username;
    }

    public void setUsername(String username)
    {
        m_username = username;
    }

    @Schema(example = "mustafa")
    public String getFirstname()
    {
        return m_firstname;
    }

    public void setFirstname(String firstname)
    {
        m_firstname = firstname;
    }

    @Schema(example = "şahin")
    public String getLastname()
    {
        return m_lastname;
    }

    public void setLastname(String lastname)
    {
        m_lastname = lastname;
    }

    @Schema(example = "mustafasahin@springboot.com")
    public String getEmail()
    {
        return m_email;
    }

    public void setEmail(String email)
    {
        m_email = email;
    }

    @Schema(example = "password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String getPassword()
    {
        return m_password;
    }

    public void setPassword(String password)
    {
        m_password = password;
    }
}
