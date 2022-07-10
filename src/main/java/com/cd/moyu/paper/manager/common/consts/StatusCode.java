package com.cd.moyu.paper.manager.common.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCode {
    /**
     * 成功
     */
    SUCCESS(20000, "操作成功"),
    /**
     * 失败
     */
    FAIL(51000, "操作失败"),
    /**
     * token过期
     */
    TOKEN_EXPIRED(51001,"token异常，请重新登录"),
    /**
     * 没有操作权限
     */
    PERMISSION_DENIED(51002, "没有操作权限"),
    /**
     * 未认证的请求
     */
    UNAUTHORIZED(51003, "未认证"),
    /**
     * 用户名已存在
     */
    USERNAME_EXIST(52001, "用户名已存在"),
    /**
     * 用户名不存在
     */
    USERNAME_NOT_EXIST(52002, "用户名不存在");
    /**
     * 状态码
     */
    private final Integer code;
    /**
     * 描述
     */
    private final String desc;
}
