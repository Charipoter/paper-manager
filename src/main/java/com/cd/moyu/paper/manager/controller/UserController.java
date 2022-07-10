package com.cd.moyu.paper.manager.controller;

import com.cd.moyu.paper.manager.common.bean.Assert;
import com.cd.moyu.paper.manager.common.bean.Result;
import com.cd.moyu.paper.manager.common.consts.StatusCode;
import com.cd.moyu.paper.manager.exception.NormalException;
import com.cd.moyu.paper.manager.po.AuthUser;
import com.cd.moyu.paper.manager.po.Teacher;
import com.cd.moyu.paper.manager.po.User;
import com.cd.moyu.paper.manager.service.StudentService;
import com.cd.moyu.paper.manager.service.StudentVoService;
import com.cd.moyu.paper.manager.service.TeacherService;
import com.cd.moyu.paper.manager.service.UserService;
import com.cd.moyu.paper.manager.util.JwtUtil;
import com.cd.moyu.paper.manager.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@RestController
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    private StudentVoService studentVoService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(String account, String password) throws NormalException {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                account, password);
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        if (Objects.isNull(authenticate)) {
            //用户名密码错误
            throw new NormalException("用户名或密码错误", StatusCode.FAIL);
        }

        AuthUser authUser = (AuthUser) authenticate.getPrincipal();
        String username = authUser.getUsername();
        String token = JwtUtil.createJWT(username);

        //把token和用户信息存到redis中
        redisTemplate.opsForValue().set("token_" + username, token, 1, TimeUnit.HOURS);
        redisTemplate.opsForValue().set("user_" + username, authUser, 1, TimeUnit.HOURS);

        //将用户存入上下文中
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        return Result.ok("登录成功", new UserVo(authUser, token));
    }

    @GetMapping("/logout")
    public Result logout() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthUser authUser = (AuthUser) authentication.getPrincipal();
        String username = authUser.getUsername();

        //删除redis中存的信息
        redisTemplate.delete("token_" + username);
        redisTemplate.delete("user_" + username);
        //清除上下文
        SecurityContextHolder.clearContext();

        return Result.ok("注销成功");
    }

    @PostMapping("/users")
    public Result signIn(User user) throws NormalException {

        try {
            userService.save(user);
        } catch (DuplicateKeyException e) {
            throw new NormalException("已注册", StatusCode.USERNAME_EXIST);
        }

        return Result.ok("注册成功", user);
    }

    @PostMapping("/users/detail")
    public Result getUserDetailByUser(@RequestBody UserVo userVo) throws NormalException {

        String roleCode = userVo.getRoleCode();
        Assert.checkArgument(roleCode.length() > 0, "错误角色", StatusCode.FAIL);

        Object detail = switch (roleCode) {
            case "student" -> studentVoService.getOneByUserId(userVo.getId());
            case "teacher" -> teacherService.getOneByUserId(userVo.getId());
            default -> null;
        };
        Assert.checkArgument(detail != null, "查询成功", StatusCode.FAIL);

        return Result.ok("查询成功", detail);
    }
}
