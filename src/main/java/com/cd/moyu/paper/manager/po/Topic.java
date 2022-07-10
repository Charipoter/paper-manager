package com.cd.moyu.paper.manager.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @TableName topic
 */
@TableName(value ="topic")
@Data
public class Topic implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 选题标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 选题简介
     */
    @TableField(value = "topic_desc")
    private String topicDesc;

    /**
     * 导师号
     */
    @TableField(value = "tch_number")
    private String teacherNumber;

    /**
     * 限定人数
     */
    @TableField(value = "limit_number")
    private Integer limitNumber;

    /**
     * 限定专业
     */
    @TableField(value = "limit_major")
    private Integer limitMajor;

    /**
     * 发布日期
     */
    @TableField(value = "publish_date")
    @DateTimeFormat(pattern = "yyy-MM-dd HH:mm:ss")
    private Date publishDate;

    /**
     * 已选人数
     */
    @TableField(value = "curr_number")
    private Object currentNumber;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}