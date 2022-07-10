package com.cd.moyu.paper.manager.exception;

import com.cd.moyu.paper.manager.common.consts.StatusCode;

public class NormalException extends Exception {
    private StatusCode code;
    public NormalException(String msg, StatusCode code) {
        super(msg);
        this.code = code;
    }
    public StatusCode getCode() {
        return code;
    }
}
