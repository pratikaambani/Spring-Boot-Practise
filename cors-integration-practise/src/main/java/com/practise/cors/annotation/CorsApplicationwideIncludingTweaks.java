package com.practise.cors.annotation;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Pratik Ambani on 2/09/17.
 */
public class CorsApplicationwideIncludingTweaks extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://mygenuinedomain.com")
                .allowedMethods("PUT", "DELETE")
                .allowedHeaders("authorization", "application")
                .exposedHeaders("msisdn", "uid")
                .allowCredentials(false).maxAge(3600);

    }
}
