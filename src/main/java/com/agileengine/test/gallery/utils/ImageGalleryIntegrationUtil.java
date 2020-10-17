package com.agileengine.test.gallery.utils;

import com.agileengine.test.gallery.service.dto.Token;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class ImageGalleryIntegrationUtil {

    public HttpHeaders getHeaderParams(Token token){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token.getToken());
        return headers;
    }
}
