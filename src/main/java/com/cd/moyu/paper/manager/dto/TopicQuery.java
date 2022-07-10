package com.cd.moyu.paper.manager.dto;

import lombok.Data;

@Data
public class TopicQuery {
    private String teacherName;
    private String majorName;
    private Integer pageIndex;
    private Integer pageSize;

}
