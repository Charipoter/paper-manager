package com.cd.moyu.paper.manager.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName stu_tch
 */
@TableName(value ="stu_tch")
@Data
public class StudentTeacher implements Serializable {
    /**
     * 
     */
    @TableId(value = "id")
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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}