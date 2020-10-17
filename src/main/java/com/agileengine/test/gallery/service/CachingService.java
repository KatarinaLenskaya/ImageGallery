package com.agileengine.test.gallery.service;

import com.agileengine.test.gallery.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CachingService {
    private List<Image> cache = new ArrayList<>();

    @Autowired
    ImageGalleryService imageGalleryService;

    @Scheduled(cron="${cache.update.time}")
    public void updateCache(){
        cache.clear();
        cache.addAll(imageGalleryService.getAllImagesInfo());
        System.out.println(cache);
    }

    public List<Image> searchByTerm(String searchTerm) {
        return cache.stream()
                .filter(image -> image.getComplexSearchKey().contains(searchTerm))
                .collect(Collectors.toList());
    }
}
