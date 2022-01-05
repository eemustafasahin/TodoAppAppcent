package com.sahin.app.service;

import com.sahin.app.data.repository.ITagRepository;
import com.sahin.app.data.repository.ITodoRepository;
import com.sahin.app.dto.TagDTO;
import com.sahin.app.dto.TagDTOConverter;
import com.sahin.app.dto.TaskDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by M.Şahin on 05/01/2022
 */
@Component
public class TagService {

    private final ITagRepository m_tagRepository;
    private final TagDTOConverter m_tagDTOConverter;

    public TagService(ITagRepository tagRepository, TagDTOConverter tagDTOConverter)
    {
        m_tagRepository = tagRepository;
        m_tagDTOConverter = tagDTOConverter;
    }

    public TagDTO getTagById(Long id)
    {
        var tagOpt = m_tagRepository.findById(id);

        if (tagOpt.isEmpty())
            return null;

        return m_tagDTOConverter.toTagDTO(tagOpt.get());
    }

    public List<TagDTO> getAllTagsByTodoId(Long id)
    {
        return StreamSupport.stream(m_tagRepository.findTagsByTodoId(id).spliterator(),false)
                .map(m_tagDTOConverter::toTagDTO).collect(Collectors.toList());
    }

    public TagDTO updateTag(Long id,TagDTO tagDTO)
    {
        var tagOpt = m_tagRepository.findById(id);

        if (tagOpt.isEmpty())
            return null;

        var tagUpdated = tagOpt.get();

        tagUpdated.setName(m_tagDTOConverter.toTag(tagDTO).getName());

        m_tagRepository.save(tagUpdated);

        return m_tagDTOConverter.toTagDTO(tagUpdated);
    }

    public TagDTO deleteTag(Long id)
    {
        var tagOpt = m_tagRepository.findById(id);

        if (tagOpt.isEmpty())
            return null;

        var tagDeleted = tagOpt.get();
        m_tagRepository.delete(tagDeleted);

        return m_tagDTOConverter.toTagDTO((tagDeleted));
    }
}
