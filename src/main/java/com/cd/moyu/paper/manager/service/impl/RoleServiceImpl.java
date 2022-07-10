package com.cd.moyu.paper.manager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cd.moyu.paper.manager.dto.RoleStatistic;
import com.cd.moyu.paper.manager.po.Role;
import com.cd.moyu.paper.manager.service.RoleService;
import com.cd.moyu.paper.manager.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author lenovo
* @description 针对表【role】的数据库操作Service实现
* @createDate 2022-07-06 09:18:36
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

    @Override
    public List<RoleStatistic> userCountPerRole() {
        return getBaseMapper().userCountPerRole();
    }
}




