package com.sahin.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

/**
 * Created by M.Şahin on 02/01/2022
 */
@Configuration
public class DateTimeConfig {

    @Bean
    public DateTimeFormatter dateTimeFormat()
    {
        return DateTimeFormatter.ofPattern("yy/MM/dd hh:mm:ss");
    }
}
