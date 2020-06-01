package com.ghoshtubai.movieinfoservice.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
