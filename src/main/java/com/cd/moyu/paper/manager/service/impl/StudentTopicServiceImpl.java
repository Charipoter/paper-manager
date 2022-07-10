package com.cd.moyu.paper.manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cd.moyu.paper.manager.po.StudentTopic;
import com.cd.moyu.paper.manager.service.StudentTopicService;
import com.cd.moyu.paper.manager.mapper.StudentTopicMapper;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【stu_topic】的数据库操作Service实现
* @createDate 2022-07-04 22:51:01
*/
@Service
public class StudentTopicServiceImpl extends ServiceImpl<StudentTopicMapper, StudentTopic>
    implements StudentTopicService{

    @Override
    public StudentTopic getOneByStudentNumber(String studentNumber) {
        return getOne(new QueryWrapper<StudentTopic>().eq("stu_number", studentNumber));
    }
}




