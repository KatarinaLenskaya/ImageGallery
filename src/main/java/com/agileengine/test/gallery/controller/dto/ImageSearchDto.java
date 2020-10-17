package com.agileengine.test.gallery.controller.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ImageSearchDto implements Serializable {

    private String id;
    private String croppedImageUrl;
    private String fullImageUrl;
    private String author;
    private String tags;
    private String camera;


}
