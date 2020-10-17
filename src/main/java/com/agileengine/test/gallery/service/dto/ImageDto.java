package com.agileengine.test.gallery.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ImageDto {
    @JsonProperty("id")
    private String id;

    @JsonProperty("cropped_picture")
    private String croppedImageUrl;

    @JsonProperty("full_picture")
    private String fullImageUrl;

    private String author;

    private String tags;

    private String camera;
}
