package com.sahin.app.dto;

/**
 * Created by M.Şahin on 02/01/2022
 */
public class TaskDTO {

    private Long m_id;
    private String m_title;
    private String m_description;

    public Long getId()
    {
        return m_id;
    }

    public void setId(Long id)
    {
        m_id = id;
    }

    public String getTitle()
    {
        return m_title;
    }

    public void setTitle(String title)
    {
        m_title = title;
    }

    public String getDescription()
    {
        return m_description;
    }

    public void setDescription(String description)
    {
        m_description = description;
    }
}
