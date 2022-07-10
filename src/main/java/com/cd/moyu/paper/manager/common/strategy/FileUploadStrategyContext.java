package com.cd.moyu.paper.manager.common.strategy;

import com.cd.moyu.paper.manager.config.FileUploadConfig;
import com.cd.moyu.paper.manager.po.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class FileUploadStrategyContext {
    @Autowired
    private FileUploadConfig config;
    private Map<String, FileUploadStrategy> strategyMap = new HashMap<>();

    FileUploadStrategyContext() {
        strategyMap.put("local", new LocalFileUploadStrategy());
    }

    public String upload(MultipartFile file) throws IOException {
        return strategyMap.get(config.getMode()).upload(file, config.getPath());
    }
    public boolean remove(String path) throws IOException {
        return strategyMap.get(config.getMode()).remove(path);
    }
}
