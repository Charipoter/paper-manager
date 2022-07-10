package com.cd.moyu.paper.manager.service;

import com.cd.moyu.paper.manager.po.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lenovo
* @description 针对表【user】的数据库操作Service
* @createDate 2022-07-05 18:00:20
*/
public interface UserService extends IService<User> {
    User getOneByAccount(String account);
}
