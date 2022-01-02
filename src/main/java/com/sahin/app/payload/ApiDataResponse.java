package com.sahin.app.payload;

import org.springframework.http.HttpStatus;

/**
 * Created by M.Şahin on 02/01/2022
 */
public class ApiDataResponse<T> extends ApiResponse {

    private T m_data;

    public ApiDataResponse()
    {

    }

    public ApiDataResponse(T data,Boolean success, String message)
    {
        super(success,message);
        m_data = data;
    }

    public ApiDataResponse(T data, Boolean success, String message, HttpStatus httpStatus)
    {
        super(success, message, httpStatus);
        m_data = data;
    }

    public T getData()
    {
        return m_data;
    }
}
