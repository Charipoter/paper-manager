package com.cd.moyu.paper.manager.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cd.moyu.paper.manager.common.bean.Assert;
import com.cd.moyu.paper.manager.common.bean.Result;
import com.cd.moyu.paper.manager.common.consts.StatusCode;
import com.cd.moyu.paper.manager.exception.NormalException;
import com.cd.moyu.paper.manager.po.Student;
import com.cd.moyu.paper.manager.po.StudentTopic;
import com.cd.moyu.paper.manager.service.StudentService;
import com.cd.moyu.paper.manager.service.StudentTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentTopicService studentTopicService;

    @PreAuthorize("hasAuthority('student')")
    @PostMapping("/students")
    public Result saveOne(Student student) throws NormalException {

        try {
            studentService.save(student);
        } catch (DuplicateKeyException e) {
            throw new NormalException("已有学生信息", StatusCode.FAIL);
        }

        return Result.ok("学生信息完善成功", student);
    }

    @GetMapping("/students/{studentNumber}")
    public Result getOneByStudentNumber(@PathVariable String studentNumber) throws NormalException {

        Student existStudent = studentService.getOneByStudentNumber(studentNumber);
        Assert.checkArgument(existStudent != null, "未完善学生信息", StatusCode.FAIL);

        return Result.ok("查找成功", existStudent);
    }

    @PreAuthorize("hasAuthority('student')")
    @PostMapping("/students/{studentNumber}/topic/{topicId}")
    public Result chooseTopic(@PathVariable String studentNumber,
                              @PathVariable Integer topicId) throws NormalException {

        StudentTopic st = new StudentTopic();
        st.setStudentNumber(studentNumber);
        st.setTopicId(topicId);

        try {
            studentTopicService.save(st);

            return Result.ok("选择成功", st);
        } catch (Exception e) {
            throw new NormalException("已选择过选题", StatusCode.FAIL);
        }
    }

    @PreAuthorize("hasAuthority('student')")
    @DeleteMapping("/students/{studentNumber}")
    public Result cancelTopicChoice(@PathVariable String studentNumber) throws NormalException {

        boolean exist = studentTopicService.remove(new QueryWrapper<StudentTopic>().eq("stu_number", studentNumber));
        Assert.checkArgument(exist, "还未选择选题", StatusCode.FAIL);

        return Result.ok("退选成功");
    }
}
