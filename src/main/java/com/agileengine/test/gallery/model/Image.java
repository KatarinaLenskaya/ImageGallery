package com.agileengine.test.gallery.model;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Image {
    private String complexSearchKey;
    private String id;
    private String croppedImageUrl;
    private String fullImageUrl;
    private String author;
    private String tags;
    private String camera;
}
