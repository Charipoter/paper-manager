package com.cd.moyu.paper.manager.common.strategy;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class LocalFileUploadStrategy implements FileUploadStrategy {
    @Override
    public String upload(MultipartFile file, String path) throws IOException {
        String fullPath = path + file.getOriginalFilename();
        file.transferTo(Path.of(fullPath));
        return fullPath;
    }

    @Override
    public boolean remove(String path) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }
}
