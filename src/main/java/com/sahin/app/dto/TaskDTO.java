package com.sahin.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Created by M.Şahin on 02/01/2022
 */
@JsonPropertyOrder({"id","title"})
public class TaskDTO {

    private Long m_id;
    private String m_title;
    private String m_description;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Long getId()
    {
        return m_id;
    }

    public void setId(Long id)
    {
        m_id = id;
    }

    @Schema(example = "Go to dentist next Friday")
    public String getTitle()
    {
        return m_title;
    }

    public void setTitle(String title)
    {
        m_title = title;
    }

    @Schema(example = "Pull out tooth")
    public String getDescription()
    {
        return m_description;
    }

    public void setDescription(String description)
    {
        m_description = description;
    }
}
