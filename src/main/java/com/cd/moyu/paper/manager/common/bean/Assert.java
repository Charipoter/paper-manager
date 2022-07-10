package com.cd.moyu.paper.manager.common.bean;

import com.cd.moyu.paper.manager.common.consts.StatusCode;
import com.cd.moyu.paper.manager.exception.NormalException;

public class Assert {
    public static void checkArgument(boolean expression, String errorMessage, StatusCode code) throws NormalException {
        if (!expression) {
            throw new NormalException(errorMessage, code);
        }
    }
}
