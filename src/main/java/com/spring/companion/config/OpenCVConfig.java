package com.spring.companion.config;

import nu.pattern.OpenCV;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenCVConfig {
    static {
        OpenCV.loadShared();
    }
}
