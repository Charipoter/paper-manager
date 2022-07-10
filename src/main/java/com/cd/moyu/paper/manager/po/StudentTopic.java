package com.cd.moyu.paper.manager.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName stu_topic
 */
@TableName(value ="stu_topic")
@Data
public class StudentTopic implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学生号
     */
    @TableField(value = "stu_number")
    private String studentNumber;

    /**
     * 选题id
     */
    @TableField(value = "topic_id")
    private Integer topicId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}