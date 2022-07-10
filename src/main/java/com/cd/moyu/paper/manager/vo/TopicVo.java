package com.cd.moyu.paper.manager.vo;

import lombok.Data;

import java.util.Date;

@Data
public class TopicVo {

    private Integer id;

    private String title;

    private String topicDesc;

    private String teacherName;

    private Integer limitNumber;

    private Integer currentNumber;

    private String majorName;

    private Date publishDate;

}
