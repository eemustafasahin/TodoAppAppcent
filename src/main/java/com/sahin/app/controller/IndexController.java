package com.sahin.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by M.Şahin on 01/01/2022
 */
@RestController
@RequestMapping(path = "/")
public class IndexController {

    @GetMapping
    public String homePage()
    {
        return "Hello, World";
    }
}
