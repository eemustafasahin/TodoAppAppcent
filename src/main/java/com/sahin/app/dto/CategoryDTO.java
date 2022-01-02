package com.sahin.app.dto;

/**
 * Created by M.Şahin on 02/01/2022
 */
public class CategoryDTO {

    private Long m_id;
    private String m_name;

    public Long getId()
    {
        return m_id;
    }

    public void setId(Long id)
    {
        m_id = id;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }
}
