package com.agileengine.test.gallery.service;

import com.agileengine.test.gallery.service.dto.ResultImagesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class IntegrationService {

    @Autowired
    private RestTemplate restTemplate;

    public <T> T postForObject(String url, Object param, Class<T> responseType){
        return restTemplate.postForObject(url, param, responseType);
    }

    public <T> T getForObjectWithHeaderParams(String url, List<Object> params, HttpHeaders headerParams, Class<T> responseType){
        HttpHeaders headers = new HttpHeaders();
        headers.addAll(headerParams);

        ResponseEntity<T> responseEntity=  restTemplate
                .exchange(url,
                        HttpMethod.GET,
                        new HttpEntity<>(headers),
                        responseType,
                        params.toArray());

        return responseEntity.getBody();
    }
}
