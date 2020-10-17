package com.agileengine.test.gallery.service;

import com.agileengine.test.gallery.model.Image;
import com.agileengine.test.gallery.service.dto.ApiKey;
import com.agileengine.test.gallery.service.dto.ImageDto;
import com.agileengine.test.gallery.service.dto.ResultImagesDto;
import com.agileengine.test.gallery.service.dto.Token;
import com.agileengine.test.gallery.utils.ImageGalleryIntegrationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageGalleryService {

    private Token token;

    @Autowired
    private IntegrationService integrationService;
    @Autowired
    private ImageGalleryIntegrationUtil imageGalleryIntegrationUtil;
    @Autowired
    private ApiKey apiKey;

    private boolean refreshToken() {

        token = integrationService.postForObject("http://interview.agileengine.com/auth", apiKey, Token.class);
        return token.isAuth();
    }

    public List<Image> getAllImagesInfo() {
        ResultImagesDto result;
        try {
            result = getImagesByPage(1);
        } catch (Exception e) {
            refreshToken();
            result = getImagesByPage(1);
        }

        var allPages = new ArrayList<ResultImagesDto>();
        allPages.add(result);

        for (int i = result.getPage(); i <= result.getPage(); i++) {
            allPages.add(getImagesByPage(i));
        }

        return allPages.parallelStream()
                .map(this::getFullImageInfoForPage)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private List<Image> getFullImageInfoForPage(ResultImagesDto images) {
        return images.getResult().stream()
                .map(image -> getImageById(image.getId()))
                .collect(Collectors.toList());
    }

    private ResultImagesDto getImagesByPage(int page) {
        return integrationService.getForObjectWithHeaderParams(
                "http://interview.agileengine.com/images?page={page}",
                List.of(page),
                imageGalleryIntegrationUtil.getHeaderParams(token),
                ResultImagesDto.class);
    }

    private Image getImageById(String id) {
        ImageDto imageDto = integrationService.getForObjectWithHeaderParams(
                "http://interview.agileengine.com/images/{id}",
                List.of(id),
                imageGalleryIntegrationUtil.getHeaderParams(token),
                ImageDto.class);
        return fromDto(imageDto);
    }

    private Image fromDto(ImageDto dto) {
        return Image.builder()
                .id(dto.getId())
                .author(dto.getAuthor())
                .camera(dto.getCamera())
                .croppedImageUrl(dto.getCroppedImageUrl())
                .fullImageUrl(dto.getFullImageUrl())
                .tags(dto.getTags())
                .complexSearchKey(dto.getAuthor() + " " + dto.getCamera() + " " + dto.getTags())
                .build();
    }


}
