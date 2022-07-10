package com.cd.moyu.paper.manager.service.impl;

import com.cd.moyu.paper.manager.mapper.RoleMapper;
import com.cd.moyu.paper.manager.po.AuthUser;
import com.cd.moyu.paper.manager.po.Role;
import com.cd.moyu.paper.manager.po.User;
import com.cd.moyu.paper.manager.service.RoleService;
import com.cd.moyu.paper.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User existUser = userService.getOneByAccount(username);
        if (existUser == null) {
            throw new UsernameNotFoundException("账户不存在");
        }
        Role role = roleService.getById(existUser.getRoleId());
        return new AuthUser(existUser.getAccount(), existUser.getPassword(), existUser.getId(), role);
    }
}
