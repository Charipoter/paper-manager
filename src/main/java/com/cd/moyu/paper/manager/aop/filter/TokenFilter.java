package com.cd.moyu.paper.manager.aop.filter;

import com.alibaba.fastjson.JSON;
import com.cd.moyu.paper.manager.common.bean.Result;
import com.cd.moyu.paper.manager.common.consts.StatusCode;
import com.cd.moyu.paper.manager.po.AuthUser;
import com.cd.moyu.paper.manager.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@Component
public class TokenFilter extends OncePerRequestFilter {

    @Value("${jwt.tokenHeader}")
    private String header;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {

        // header的值是在yml文件中定义的 “Authorization”
        String token = request.getHeader(header);

        if (!(token == null || token.length() == 0)) {
            String username;

            try {
                Claims claims = JwtUtil.parseJWT(token);
                username = claims.getSubject();
            } catch (Exception e) {
                e.printStackTrace();
                writeBack(request,response,"非法Token，请重新登陆");
                return;
            }

            String redisToken = (String) redisTemplate.opsForValue().get(("token_" + username));
            if (redisToken == null || redisToken.length() == 0) {
                writeBack(request,response,"token校验失败");
                return;
            }

            //对比前端发送请求携带的的token是否与redis中存储的一致
            if (redisToken.equals(token)) {
                AuthUser authUser = (AuthUser) redisTemplate.opsForValue().get("user_" + username);
                if (Objects.isNull(authUser)) {
                    writeBack(request,response,"未登录");
                    return;
                }
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authUser, null, authUser.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        chain.doFilter(request, response);
    }
    private void writeBack(HttpServletRequest request,
                           HttpServletResponse response,
                           String msg) throws IOException, ServletException {
        //跨域设置
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Method", "POST,GET");

        Result result = Result.fail(msg, StatusCode.TOKEN_EXPIRED);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(result));
    }
}
