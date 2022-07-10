package com.cd.moyu.paper.manager.service;

import com.cd.moyu.paper.manager.po.StudentTopic;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lenovo
* @description 针对表【stu_topic】的数据库操作Service
* @createDate 2022-07-04 22:51:01
*/
public interface StudentTopicService extends IService<StudentTopic> {
    StudentTopic getOneByStudentNumber(String studentNumber);
}
