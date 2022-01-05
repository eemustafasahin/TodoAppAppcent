package com.sahin.app.controller;

import com.sahin.app.dto.TagDTO;
import com.sahin.app.payload.ApiResponse;
import com.sahin.app.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by M.Şahin on 05/01/2022
 */
@RestController
@RequestMapping("/api/v1/tags")
public class TagController {

    private final TagService m_tagService;


    public TagController(TagService tagService)
    {
        m_tagService = tagService;
    }


    @GetMapping("/todoId")//request path variable name
    public List<TagDTO> getTags(@RequestParam(name = "id") Long todoId) //passed value name as param
    {
        return m_tagService.getAllTagsByTodoId(todoId);
    }

    @GetMapping("/tagId")
    public TagDTO getTag(@RequestParam(name = "id") Long id)
    {
        return m_tagService.getTagById(id);
    }

    @PutMapping("/tagId")
    public TagDTO updateTag(@RequestParam(name = "id") Long id, @RequestBody TagDTO tagDTO)
    {
        return m_tagService.updateTag(id,tagDTO);
    }

    @DeleteMapping("tagId")
    public ResponseEntity<ApiResponse> deleteTag(@RequestParam(name = "id") Long id)
    {
        if (m_tagService.deleteTag(id) == null)
            return new ResponseEntity<>(new ApiResponse(Boolean.FALSE,"Fail"), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(new ApiResponse(Boolean.TRUE,"Successful"),HttpStatus.NO_CONTENT);
    }

}
