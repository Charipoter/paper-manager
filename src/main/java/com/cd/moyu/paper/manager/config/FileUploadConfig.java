package com.cd.moyu.paper.manager.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@ConfigurationProperties(prefix = "file.upload")
@Data
public class FileUploadConfig {
    private String path;
    private String mode;
}
