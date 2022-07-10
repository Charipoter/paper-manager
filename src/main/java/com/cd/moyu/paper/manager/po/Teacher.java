package com.cd.moyu.paper.manager.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName teacher
 */
@TableName(value ="teacher")
@Data
public class Teacher implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 研究领域
     */
    @TableField(value = "field")
    private String field;

    /**
     * 教师号
     */
    @TableField(value = "tch_number")
    private String teacherNumber;

    /**
     * 学术头衔
     */
    @TableField(value = "ac_title")
    private String academicTitle;

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