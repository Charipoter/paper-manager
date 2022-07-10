package com.cd.moyu.paper.manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cd.moyu.paper.manager.dto.TeacherStatistic;
import com.cd.moyu.paper.manager.po.Teacher;
import com.cd.moyu.paper.manager.service.TeacherService;
import com.cd.moyu.paper.manager.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author lenovo
* @description 针对表【teacher】的数据库操作Service实现
* @createDate 2022-07-04 22:51:01
*/
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>
    implements TeacherService{

    @Override
    public Teacher getOneByTeacherNumber(String teacherNumber) {
        return getOne(new QueryWrapper<Teacher>().eq("tch_number", teacherNumber));
    }

    @Override
    public Teacher getOneByUserId(Integer userId) {
        return getOne(new QueryWrapper<Teacher>().eq("user_id", userId));
    }

    @Override
    public List<TeacherStatistic> studentCountPerTeacher() {
        return getBaseMapper().studentCountPerTeacher();
    }
}




