package com.sahin.app.controller;

import com.sahin.app.data.model.User;
import com.sahin.app.payload.ApiResponse;
import com.sahin.app.payload.SignupRequest;
import com.sahin.app.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by M.Şahin on 01/01/2022
 */
@RestController
@RequestMapping
public class AuthenticationController {

    private final HttpServletResponse m_httpServletResponse;
    private final AuthenticationService m_authenticationService;

    public AuthenticationController(HttpServletResponse httpServletResponse, AuthenticationService authenticationService)
    {
        m_httpServletResponse = httpServletResponse;
        m_authenticationService = authenticationService;
    }

    @PostMapping(path = "/signup")
    public ResponseEntity<ApiResponse> register(@RequestBody SignupRequest request)
    {
        var apiResponse = m_authenticationService.registerWithUserRole(request);

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/login")
    public void login() throws Exception
    {
        m_httpServletResponse.sendRedirect("http://localhost:8080/login");
    }

}
