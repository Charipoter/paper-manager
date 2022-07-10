package com.cd.moyu.paper.manager.controller;

import com.cd.moyu.paper.manager.common.bean.Assert;
import com.cd.moyu.paper.manager.common.bean.Result;
import com.cd.moyu.paper.manager.common.consts.StatusCode;
import com.cd.moyu.paper.manager.exception.NormalException;
import com.cd.moyu.paper.manager.po.Teacher;
import com.cd.moyu.paper.manager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PreAuthorize("hasAuthority('teacher')")
    @PostMapping("/teachers")
    public Result saveOne(Teacher teacher) throws NormalException {

        try {
            teacherService.save(teacher);
        } catch (DuplicateKeyException e) {
            throw new NormalException("已有教师信息", StatusCode.FAIL);
        }

        return Result.ok("教师信息完善成功", teacher);
    }

    @GetMapping("/teachers/{teacherNumber}")
    public Result getOneByTeacherNumber(@PathVariable String teacherNumber) throws NormalException {

        Teacher existTeacher = teacherService.getOneByTeacherNumber(teacherNumber);
        Assert.checkArgument(existTeacher != null, "未完善教师信息", StatusCode.FAIL);

        return Result.ok("查找成功", existTeacher);
    }

    @GetMapping("/teachers/student/statistic")
    public Result studentCountPerTeacher() {

        return Result.ok("查询成功", teacherService.studentCountPerTeacher());
    }
}
