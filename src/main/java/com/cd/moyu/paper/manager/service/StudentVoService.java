package com.cd.moyu.paper.manager.service;

import com.cd.moyu.paper.manager.exception.NormalException;
import com.cd.moyu.paper.manager.vo.StudentVo;

public interface StudentVoService {
    StudentVo getOneByUserId(Integer userId) throws NormalException;
}
