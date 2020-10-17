package com.agileengine.test.gallery.controller;

import com.agileengine.test.gallery.controller.dto.ImageSearchDto;
import com.agileengine.test.gallery.model.Image;
import com.agileengine.test.gallery.service.CachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SearchController {

    @Autowired
    private CachingService cachingService;

    @RequestMapping("search/{searchTerm}")
    public List<ImageSearchDto> searchForImages(@PathVariable String searchTerm){
        List<Image> result = cachingService.searchByTerm(searchTerm);
        return toDto(result);
    }

    private List<ImageSearchDto> toDto(List<Image> result) {
        return result.stream().map(image ->
                ImageSearchDto.builder()
                        .author(image.getAuthor())
                        .camera(image.getCamera())
                        .tags(image.getTags())
                        .croppedImageUrl(image.getCroppedImageUrl())
                        .fullImageUrl(image.getFullImageUrl())
                        .build())
                .collect(Collectors.toList());
    }
}
