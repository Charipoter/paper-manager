package com.cd.moyu.paper.manager.mapper;

import com.cd.moyu.paper.manager.dto.TeacherStatistic;
import com.cd.moyu.paper.manager.po.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author lenovo
* @description 针对表【teacher】的数据库操作Mapper
* @createDate 2022-07-04 22:51:01
* @Entity com.cd.moyu.paper.manager.po.Teacher
*/
public interface TeacherMapper extends BaseMapper<Teacher> {
    List<TeacherStatistic> studentCountPerTeacher();
}




