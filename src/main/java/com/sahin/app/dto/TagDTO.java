package com.sahin.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Created by M.Şahin on 02/01/2022
 */
@JsonPropertyOrder("id")
public class TagDTO {

    private Long m_id;
    private String m_name;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Long getId()
    {
        return m_id;
    }

    public void setId(Long id)
    {
        m_id = id;
    }

    @Schema(example = "decay")
    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }
}
