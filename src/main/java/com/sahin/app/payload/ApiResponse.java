package com.sahin.app.payload;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;

/**
 * Created by M.Şahin on 01/01/2022
 */
@JsonPropertyOrder({ // look for getters lower camelCase names
        "success",
        "message",
        "httpStatus"
})
public class ApiResponse {

    private Boolean m_success;
    private String m_message;
    private HttpStatus m_httpStatus;

    public ApiResponse()
    {

    }

    public ApiResponse(Boolean success, String message)
    {
        m_success = success;
        m_message = message;
    }

    public ApiResponse(Boolean success, String message, HttpStatus httpStatus)
    {
        m_success = success;
        m_message = message;
        m_httpStatus = httpStatus;
    }

    public Boolean getSuccess()
    {
        return m_success;
    }

    public String getMessage()
    {
        return m_message;
    }

    public HttpStatus getHttpStatus()
    {
        return m_httpStatus;
    }
}
