package com.sahin.app.controller;

import com.sahin.app.dto.CategoryDTO;
import com.sahin.app.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by M.Şahin on 05/01/2022
 */
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService m_categoryService;

    public CategoryController(CategoryService categoryService)
    {
        m_categoryService = categoryService;
    }

    @GetMapping("/categoryId")
    public CategoryDTO get(Long id)
    {
        return m_categoryService.getCategoryById(id);
    }

    @GetMapping("/categoryName")
    public CategoryDTO get(String name)
    {
        return m_categoryService.getCategoryByName(name);
    }

    @GetMapping
    public List<CategoryDTO> list()
    {
        return m_categoryService.getAllCategories();
    }

}
