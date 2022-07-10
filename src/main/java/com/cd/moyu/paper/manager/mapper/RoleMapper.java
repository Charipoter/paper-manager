package com.cd.moyu.paper.manager.mapper;

import com.cd.moyu.paper.manager.dto.RoleStatistic;
import com.cd.moyu.paper.manager.po.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author lenovo
* @description 针对表【role】的数据库操作Mapper
* @createDate 2022-07-06 09:18:36
* @Entity com.cd.moyu.paper.manager.po.Role
*/
public interface RoleMapper extends BaseMapper<Role> {
    List<RoleStatistic> userCountPerRole();
}




