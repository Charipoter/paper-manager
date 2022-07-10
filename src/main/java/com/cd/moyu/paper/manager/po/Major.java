package com.cd.moyu.paper.manager.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName major
 */
@TableName(value ="major")
@Data
public class Major implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 专业名称
     */
    @TableField(value = "major_name")
    private String majorName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}