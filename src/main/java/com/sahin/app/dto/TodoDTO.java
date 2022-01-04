package com.sahin.app.dto;

import com.fasterxml.jackson.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by M.Şahin on 02/01/2022
 */
@JsonPropertyOrder({ // look for getters camelCase names
        "id", "title", "createdAt", "completed", "UserDTO", "taskDTOs", "tagDTOs", "categoryDTOs"
})
public class TodoDTO {

    private Long m_id;
    private String m_title;
    private LocalDateTime createdAt;
    private boolean m_completed;
    private UserDTO m_userDTO;
    private Set<TaskDTO> m_taskDTOs = new HashSet<>();
    private Set<TagDTO> m_tagDTOs = new HashSet<>();
    private Set<CategoryDTO> m_categoryDTOs = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Long getId()
    {
        return m_id;
    }
    public void setId(Long id)
    {
        m_id = id;
    }

    @Schema(example = "Dentist")
    public String getTitle()
    {
        return m_title;
    }

    public void setTitle(String title)
    {
        m_title = title;
    }

    @JsonIgnore
    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt)
    {
        this.createdAt = createdAt;
    }

    @Schema(example = "false")
    public Boolean getCompleted()
    {
        return m_completed;
    }

    public void setCompleted(Boolean completed)
    {
        m_completed = completed;
    }

    @JsonIgnore
    public UserDTO getUserDTO()
    {
        return m_userDTO;
    }
    @JsonIgnore
    public void setUserDTO(UserDTO userDTO)
    {
        m_userDTO = userDTO;
    }

    public Set<TaskDTO> getTaskDTOs()
    {
        return m_taskDTOs;
    }

    public void setTaskDTOs(Set<TaskDTO> taskDTOs)
    {
        m_taskDTOs = taskDTOs;
    }

    public Set<TagDTO> getTagDTOs()
    {
        return m_tagDTOs;
    }

    public void setTagDTOs(Set<TagDTO> tagDTOs)
    {
        m_tagDTOs = tagDTOs;
    }

    public Set<CategoryDTO> getCategoryDTOs()
    {
        return m_categoryDTOs;
    }

    public void setCategoryDTOs(Set<CategoryDTO> categoryDTOs)
    {
        m_categoryDTOs = categoryDTOs;
    }
}
