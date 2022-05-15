package com.etoak.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
  @Value("${image.path}")
  String pathPrefix;
  @Value("${image.dir}")
  String uploadDir;
  /**
   * <mvc:resources mapping="/files/**"
   *      location="file:d:/upload/et2108/" />
   * @param registry
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // mapping = /files/**
    String mapping = pathPrefix.endsWith("/") ?
        StringUtils.join(pathPrefix, "**") :
        StringUtils.join(pathPrefix, "/**");
    // location = file:d:/upload/et2108/
    String location = uploadDir.endsWith("/") ?
        StringUtils.join("file:", uploadDir) :
        StringUtils.join("file:", uploadDir, "/");
    registry.addResourceHandler(mapping)
        .addResourceLocations(location);
  }

  @Bean
  public MultipartConfigElement multipartConfigElement() {
    MultipartConfigFactory factory = new MultipartConfigFactory();
    factory.setLocation("/Users/rytlockbrimstone/Documents/github_resources/MyLibrary/bs/bs_houduan");
    return factory.createMultipartConfig();
  }


}
