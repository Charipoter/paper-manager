package com.cd.moyu.paper.manager.aop;

import com.cd.moyu.paper.manager.common.bean.Result;
import com.cd.moyu.paper.manager.exception.NormalException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackages = "com.cd.moyu.paper.manager.controller")
@ResponseBody
public class ExceptionHandlerAdvice {
    @ExceptionHandler(NormalException.class)
    Result handleNormal(NormalException exception) {
        return Result.fail(exception.getMessage(), exception.getCode());
    }
}
