package com.agileengine.test.gallery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ImageSearchGalleryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageSearchGalleryApplication.class, args);
    }

}
