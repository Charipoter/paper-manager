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
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 账号
     */
    @TableField(value = "account")
    private String account;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 标识角色
     */
    @TableField(value = "role_id")
    private Integer roleId;

    /**
     * 注册日期
     */
    @TableField(value = "reg_date")
    @DateTimeFormat(pattern = "yyy-MM-dd HH:mm:ss")
    private Date regDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}