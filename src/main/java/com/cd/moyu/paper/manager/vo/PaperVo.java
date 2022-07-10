package com.cd.moyu.paper.manager.vo;

import lombok.Data;

@Data
public class PaperVo {
    private Integer id;
    private String studentName;
    private String studentNumber;
    private String topicTitle;
    private String topicId;
    private String state;
    private String comment;
    private String submitDate;
}
