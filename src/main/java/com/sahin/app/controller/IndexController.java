package com.sahin.app.controller;

import com.sahin.app.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by M.Şahin on 01/01/2022
 */
@RestController
@RequestMapping
public class IndexController {

    private final HttpServletResponse m_httpServletResponse;

    public IndexController(HttpServletResponse httpServletResponse)
    {
        m_httpServletResponse = httpServletResponse;
    }

    @GetMapping(path = "/doc")
    public void docPage() throws Exception
    {
        m_httpServletResponse.sendRedirect("/swagger-ui.html");
    }

    @GetMapping(path = "/")
    public void home() throws Exception
    {
        m_httpServletResponse.sendRedirect("/swagger-ui.html");
    }

}
