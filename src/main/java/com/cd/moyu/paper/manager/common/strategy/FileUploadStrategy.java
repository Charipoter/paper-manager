package com.cd.moyu.paper.manager.common.strategy;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadStrategy {
    String upload(MultipartFile file, String path) throws IOException;
    boolean remove(String path) throws IOException;
}
