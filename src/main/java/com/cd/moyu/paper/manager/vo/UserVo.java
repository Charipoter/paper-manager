package com.cd.moyu.paper.manager.vo;

import com.cd.moyu.paper.manager.po.AuthUser;
import com.cd.moyu.paper.manager.po.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVo {
    private Integer id;
    private String account;
    private String roleCode;
    private String roleDesc;
    private String token;
    public UserVo(AuthUser user, String token) {
        this.id = user.getId();
        this.account = user.getUsername();
        this.token = token;
        Role role = user.getRole();
        this.roleCode = role.getRoleCode();
        this.roleDesc = role.getRoleDesc();
    }
}
