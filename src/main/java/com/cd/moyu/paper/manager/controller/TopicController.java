package com.cd.moyu.paper.manager.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cd.moyu.paper.manager.common.bean.Result;
import com.cd.moyu.paper.manager.dto.TopicQuery;
import com.cd.moyu.paper.manager.exception.NormalException;
import com.cd.moyu.paper.manager.po.Topic;
import com.cd.moyu.paper.manager.service.TopicService;
import com.cd.moyu.paper.manager.vo.TopicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public Result selectAll() {

        return Result.ok("查询成功", topicService.list());
    }

    @PreAuthorize("hasAuthority('teacher')")
    @PostMapping("/topics")
    public Result publishTopic(@RequestBody Topic topic) throws NormalException {

        topicService.save(topic);

        return Result.ok("发布成功", topic);
    }

    @PostMapping ("/topics/page")
    public Result selectPage(@RequestBody TopicQuery topicQuery) {

        Page<TopicVo> topicVos = topicService.pageTopicVo(topicQuery);

        return Result.ok("查询成功", topicVos);
    }

    @PreAuthorize("hasAuthority('teacher')")
    @DeleteMapping("/topics/{topicId}")
    public Result removeOneById(@PathVariable Integer topicId) {

        return Result.ok("删除成功", topicService.removeById(topicId));
    }

    @PreAuthorize("hasAuthority('teacher')")
    @PutMapping("/topics/{topicId}")
    public Result updateById(@PathVariable Integer topicId, String title, String topicDesc) {

        return Result.ok("修改成功", topicService.update(new UpdateWrapper<Topic>()
                .set("title", title)
                .set("topic_desc", topicDesc)
                .eq("id", topicId)));
    }

    @GetMapping("/topics/teacher/{teacherNumber}")
    public Result selectTopicTitleByTeacherNumber(@PathVariable String teacherNumber) {

        return Result.ok("查询成功", topicService.selectTopicTitleByTeacherNumber(teacherNumber));
    }

}
