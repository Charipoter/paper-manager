package com.cd.moyu.paper.manager.service;

import com.cd.moyu.paper.manager.dto.RoleStatistic;
import com.cd.moyu.paper.manager.po.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author lenovo
* @description 针对表【role】的数据库操作Service
* @createDate 2022-07-06 09:18:36
*/
public interface RoleService extends IService<Role> {
    List<RoleStatistic> userCountPerRole();
}
