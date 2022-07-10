package com.cd.moyu.paper.manager.controller;

import com.cd.moyu.paper.manager.common.bean.Assert;
import com.cd.moyu.paper.manager.common.bean.Result;
import com.cd.moyu.paper.manager.common.consts.StatusCode;
import com.cd.moyu.paper.manager.exception.NormalException;
import com.cd.moyu.paper.manager.po.Major;
import com.cd.moyu.paper.manager.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MajorController {
    @Autowired
    private MajorService majorService;

    @PostMapping("/majors")
    public Result saveOne(Major major) throws NormalException {

        Major existMajor = majorService.getOneByMajorName(major.getMajorName());
        Assert.checkArgument(existMajor == null, "专业已经存在", StatusCode.FAIL);

        majorService.save(major);

        return Result.ok("添加成功", major);
    }

    @GetMapping("/majors/{majorName}")
    public Result getOneByMajorName(@PathVariable String majorName) throws NormalException {

        Major existMajor = majorService.getOneByMajorName(majorName);
        Assert.checkArgument(existMajor != null, "专业不存在", StatusCode.FAIL);

        return Result.ok("查询成功", existMajor);
    }

    @GetMapping("/majors")
    public Result selectAll() {

        return Result.ok("查询成功", majorService.list());
    }

    @GetMapping("/majors/student/statistics")
    public Result studentCountPerMajor() {

        return Result.ok("查询成功", majorService.studentCountPerMajor());
    }
}
