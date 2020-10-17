package com.agileengine.test.gallery.service.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
public class ApiKey {

    @Value("${image.gallery.api.key}")
    private String apiKey;
}
