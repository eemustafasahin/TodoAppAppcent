package com.sahin.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by M.Şahin on 02/01/2022
 */
public class TodoDTO {

    private Long m_id;
    private String m_title;
    private LocalDateTime createdAt;
    private boolean m_completed;
    private UserDTO m_userDTO;
    private Set<TaskDTO> m_taskDTOSet = new HashSet<>();
    private Set<TagDTO> m_tagDTOSet = new HashSet<>();
    private Set<CategoryDTO> m_categoryDTOSet = new HashSet<>();

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

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt)
    {
        this.createdAt = createdAt;
    }

    public Boolean getCompleted()
    {
        return m_completed;
    }

    public void setCompleted(Boolean completed)
    {
        m_completed = completed;
    }

    public UserDTO getUserDTO()
    {
        return m_userDTO;
    }

    public void setUserDTO(UserDTO userDTO)
    {
        m_userDTO = userDTO;
    }

    public Set<TaskDTO> getTaskDTOSet()
    {
        return m_taskDTOSet;
    }

    public void setTaskDTOSet(Set<TaskDTO> taskDTOSet)
    {
        m_taskDTOSet = taskDTOSet;
    }

    public Set<TagDTO> getTagDTOSet()
    {
        return m_tagDTOSet;
    }

    public void setTagDTOSet(Set<TagDTO> tagDTOSet)
    {
        m_tagDTOSet = tagDTOSet;
    }

    public Set<CategoryDTO> getCategoryDTOSet()
    {
        return m_categoryDTOSet;
    }

    public void setCategoryDTOSet(Set<CategoryDTO> categoryDTOSet)
    {
        m_categoryDTOSet = categoryDTOSet;
    }
}
