package com.cd.moyu.paper.manager.service.impl;

import com.cd.moyu.paper.manager.common.bean.Assert;
import com.cd.moyu.paper.manager.common.consts.StatusCode;
import com.cd.moyu.paper.manager.exception.NormalException;
import com.cd.moyu.paper.manager.po.*;
import com.cd.moyu.paper.manager.service.*;
import com.cd.moyu.paper.manager.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentVoServiceImpl implements StudentVoService {
    @Autowired
    private StudentService studentService;
    @Autowired
    private MajorService majorService;
    @Autowired
    private StudentTopicService studentTopicService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private TopicService topicService;
    @Override
    public StudentVo getOneByUserId(Integer userId) throws NormalException {
        Student student = studentService.getOneByUserId(userId);
        Assert.checkArgument(student != null, "信息不存在", StatusCode.FAIL);
        Major major = majorService.getById(student.getMajorId());
        StudentTopic studentTopic = studentTopicService.getOneByStudentNumber(student.getStudentNumber());
        if (studentTopic == null) {
            return new StudentVo(student, major);
        } else {
            Topic topic = topicService.getById(studentTopic.getTopicId());
            Teacher teacher = teacherService.getOneByTeacherNumber(topic.getTeacherNumber());
            return new StudentVo(student, major, topic, teacher);
        }

    }
}
