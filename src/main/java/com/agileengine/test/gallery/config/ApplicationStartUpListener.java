package com.agileengine.test.gallery.config;

import com.agileengine.test.gallery.service.CachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartUpListener implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    CachingService cachingService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        cachingService.updateCache();
    }
}
