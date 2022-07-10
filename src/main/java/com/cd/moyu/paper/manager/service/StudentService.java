package com.cd.moyu.paper.manager.service;

import com.cd.moyu.paper.manager.po.Student;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lenovo
* @description 针对表【student】的数据库操作Service
* @createDate 2022-07-04 22:51:01
*/
public interface StudentService extends IService<Student> {
    Student getOneByStudentNumber(String studentNumber);
    Student getOneByUserId(Integer userId);
}
