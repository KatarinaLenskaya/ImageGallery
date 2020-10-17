package com.agileengine.test.gallery.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResultImagesDto {
    @JsonProperty("pictures")
    private List<ImageDto> result;
    @JsonProperty("page")
    private int page;
    @JsonProperty("pageCount")
    private int pageCount;
    @JsonProperty("hasMore")
    boolean hasMore;

    public List<ImageDto> getResult() {
        return result;
    }

    public int getPage() {
        return page;
    }

    public int getPageCount() {
        return pageCount;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    @Override
    public String toString() {
        return "ResultImagesDto{" +
                "page=" + page +
                ", pageCount=" + pageCount +
                ", hasMore=" + hasMore +
                '}';
    }
}
