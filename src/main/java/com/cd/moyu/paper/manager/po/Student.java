package com.cd.moyu.paper.manager.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName student
 */
@TableName(value ="student")
@Data
public class Student implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学生姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 学号
     */
    @TableField(value = "stu_number")
    private String studentNumber;

    /**
     * 专业
     */
    @TableField(value = "major_id")
    private Integer majorId;

    /**
     * 联系电话
     */
    @TableField(value = "phone_number")
    private String phoneNumber;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Integer userId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}