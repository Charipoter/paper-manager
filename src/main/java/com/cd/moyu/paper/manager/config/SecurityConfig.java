package com.cd.moyu.paper.manager.config;

import com.alibaba.fastjson.JSON;
import com.cd.moyu.paper.manager.aop.filter.TokenFilter;
import com.cd.moyu.paper.manager.common.bean.Result;
import com.cd.moyu.paper.manager.common.consts.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private TokenFilter tokenFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 获取AuthenticationManager（认证管理器），登录时认证使用
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 使默认登出失效
        http.logout().logoutUrl("/anywhere");
        return http
                // 基于 token，不需要 csrf
                .csrf().disable()
                // 基于 token，不需要 session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 设置处理认证失败、鉴权失败
                .exceptionHandling()
                .accessDeniedHandler((req, resp, e) -> {
                    Result result = Result.fail("权限不足", StatusCode.PERMISSION_DENIED);
                    resp.setContentType("text/json;charset=utf-8");
                    resp.getWriter().write(JSON.toJSONString(result));
                })
                .authenticationEntryPoint((req, resp, e) -> {
                    Result result = Result.fail("未认证", StatusCode.UNAUTHORIZED);
                    resp.setContentType("text/json;charset=utf-8");
                    resp.getWriter().write(JSON.toJSONString(result));
                }).and()
                // 下面开始设置权限
                .authorizeRequests(authorize -> authorize
                        // 请求放开
                        .antMatchers("/login").anonymous()
                        // 权限限制
//                        .antMatchers("/students").hasAuthority("student")
//                        .antMatchers("/teachers").hasAuthority("teacher")
                        // 其他地址的访问均需验证权限
                        .anyRequest().authenticated()
                )
                // 添加 JWT 过滤器，JWT 过滤器在用户名密码认证过滤器之前
                .addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class)
                // 认证用户时用户信息加载配置，注入springAuthUserService
                .userDetailsService(userDetailsService)
                .build();
    }

    /**
     * 配置跨源访问(CORS)
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

}
