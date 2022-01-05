package com.sahin.app.service;

import com.sahin.app.data.repository.ICategoryRepository;
import com.sahin.app.dto.CategoryDTO;
import com.sahin.app.dto.CategoryDTOConverter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by M.Şahin on 05/01/2022
 */
@Component
public class CategoryService {
    private final ICategoryRepository m_categoryRepository;
    private final CategoryDTOConverter m_categoryDTOConverter;

    public CategoryService(ICategoryRepository categoryRepository, CategoryDTOConverter categoryDTOConverter)
    {
        m_categoryRepository = categoryRepository;
        m_categoryDTOConverter = categoryDTOConverter;
    }

    public CategoryDTO getCategoryById(Long id)
    {
        var categoryOpt = m_categoryRepository.findById(id);

        if (categoryOpt.isEmpty())
            return null;

        return m_categoryDTOConverter.toCategoryDTO(categoryOpt.get());
    }

    public CategoryDTO getCategoryByName(String name)
    {
        var categoryOpt = m_categoryRepository.findByName(name);

        if (categoryOpt.isEmpty())
            return null;

        return m_categoryDTOConverter.toCategoryDTO(categoryOpt.get());
    }

    public List<CategoryDTO> getAllCategories()
    {
        return m_categoryRepository.findAll().
                stream().map(m_categoryDTOConverter::toCategoryDTO).collect(Collectors.toList());
    }
}
