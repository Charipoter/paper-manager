package com.cd.moyu.paper.manager.controller;

import com.cd.moyu.paper.manager.common.bean.Result;
import com.cd.moyu.paper.manager.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/roles/user/statistic")
    public Result userCountPerRole() {
        return Result.ok("查询成功", roleService.userCountPerRole());
    }
}
