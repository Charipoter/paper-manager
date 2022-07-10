package com.cd.moyu.paper.manager.po;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.List;

public class AuthUser extends User {
    private Integer id;
    private Role role;
    public AuthUser(String username, String password, Integer id, Role role) {
        super(username, password, List.of(new SimpleGrantedAuthority(role.getRoleCode())));
        this.role = role;
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public Role getRole() {
        return role;
    }
}
