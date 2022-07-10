package com.cd.moyu.paper.manager.dto;

import lombok.Data;

@Data
public class PaperQuery {
    private Integer topicId;
    private String studentName;
    private Integer pageIndex;
    private Integer pageSize;
    private String teacherNumber;
}
