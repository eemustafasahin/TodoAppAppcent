package com.sahin.app.dto;

import com.sahin.app.data.model.Tag;
import org.springframework.stereotype.Component;

/**
 * Created by M.Şahin on 02/01/2022
 */
@Component
public class TagDTOConverter {

    public Tag toTag(TagDTO tagDTO)
    {
        var tag = new Tag();

        tag.setName(tagDTO.getName());

        return tag;
    }

    public TagDTO toTagDTO(Tag tag)
    {
        var tagDTO = new TagDTO();

        tagDTO.setId(tag.getId());
        tagDTO.setName(tag.getName());

        return tagDTO;
    }
}
