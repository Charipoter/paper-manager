package com.cd.moyu.paper.manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cd.moyu.paper.manager.po.User;
import com.cd.moyu.paper.manager.service.UserService;
import com.cd.moyu.paper.manager.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-07-05 18:00:20
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Override
    public User getOneByAccount(String account) {
        return getOne(new QueryWrapper<User>()
                .eq("account", account)
        );
    }
}




