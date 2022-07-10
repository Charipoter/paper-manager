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
 * @TableName paper
 */
@TableName(value ="paper")
@Data
public class Paper implements Serializable {
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
     * 教师号
     */
    @TableField(value = "tch_number")
    private String teacherNumber;

    /**
     * 论文状态
     */
    @TableField(value = "state")
    private String state;

    /**
     * 教师评语
     */
    @TableField(value = "comment")
    private String comment;

    /**
     * 选题id
     */
    @TableField(value = "topic_id")
    private Integer topicId;

    /**
     * 论文保存路径
     */
    @TableField(value = "save_url")
    private String saveUrl;

    /**
     * 论文提交时间
     */
    @TableField(value = "submit_date")
    @DateTimeFormat(pattern = "yyy-MM-dd HH:mm:ss")
    private Date submitDate;

    /**
     * 论文审批时间
     */
    @TableField(value = "check_date")
    @DateTimeFormat(pattern = "yyy-MM-dd HH:mm:ss")
    private Date checkDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}