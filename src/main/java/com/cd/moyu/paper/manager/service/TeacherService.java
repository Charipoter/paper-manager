package com.cd.moyu.paper.manager.service;

import com.cd.moyu.paper.manager.dto.TeacherStatistic;
import com.cd.moyu.paper.manager.po.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author lenovo
* @description 针对表【teacher】的数据库操作Service
* @createDate 2022-07-04 22:51:01
*/
public interface TeacherService extends IService<Teacher> {
    Teacher getOneByTeacherNumber(String teacherNumber);
    Teacher getOneByUserId(Integer userId);
    List<TeacherStatistic> studentCountPerTeacher();
}
