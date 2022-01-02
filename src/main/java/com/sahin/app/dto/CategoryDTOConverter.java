package com.sahin.app.dto;

import com.sahin.app.data.model.Category;
import org.springframework.stereotype.Component;

/**
 * Created by M.Şahin on 02/01/2022
 */
@Component
public class CategoryDTOConverter {

    public Category toCategory(CategoryDTO categoryDTO)
    {
        var category = new Category();

        category.setName(categoryDTO.getName());

        return category;
    }

    public CategoryDTO toCategoryDTO(Category category)
    {
        var categoryDTO = new CategoryDTO();

        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());

        return categoryDTO;
    }
}
