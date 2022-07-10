package com.cd.moyu.paper.manager.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cd.moyu.paper.manager.dto.TopicQuery;
import com.cd.moyu.paper.manager.dto.TopicTitle;
import com.cd.moyu.paper.manager.po.Topic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cd.moyu.paper.manager.vo.TopicVo;

import java.util.List;

/**
* @author lenovo
* @description 针对表【topic】的数据库操作Service
* @createDate 2022-07-04 22:51:01
*/
public interface TopicService extends IService<Topic> {
    Page<TopicVo> pageTopicVo(TopicQuery query);
    List<TopicTitle> selectTopicTitleByTeacherNumber(String teacherNumber);
}
