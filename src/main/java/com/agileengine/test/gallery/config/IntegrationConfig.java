package com.agileengine.test.gallery.config;

import com.agileengine.test.gallery.service.dto.ApiKey;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class IntegrationConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Bean
    public ApiKey apiKey(){
        return new ApiKey();
    }
}
