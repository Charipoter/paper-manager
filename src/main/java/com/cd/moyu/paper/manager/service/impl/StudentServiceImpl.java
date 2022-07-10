package com.cd.moyu.paper.manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cd.moyu.paper.manager.po.Student;
import com.cd.moyu.paper.manager.service.StudentService;
import com.cd.moyu.paper.manager.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【student】的数据库操作Service实现
* @createDate 2022-07-04 22:51:01
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

    @Override
    public Student getOneByStudentNumber(String studentNumber) {
        return getOne(new QueryWrapper<Student>().eq("stu_number", studentNumber));
    }

    @Override
    public Student getOneByUserId(Integer userId) {
        return getOne(new QueryWrapper<Student>().eq("user_id", userId));
    }
}




