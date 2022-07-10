package com.cd.moyu.paper.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaperFile {
    private byte[] bytes;
    private String fileName;
}
