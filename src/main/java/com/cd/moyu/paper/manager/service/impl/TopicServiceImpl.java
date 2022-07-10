package com.cd.moyu.paper.manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cd.moyu.paper.manager.dto.TopicQuery;
import com.cd.moyu.paper.manager.dto.TopicTitle;
import com.cd.moyu.paper.manager.po.Topic;
import com.cd.moyu.paper.manager.service.TopicService;
import com.cd.moyu.paper.manager.mapper.TopicMapper;
import com.cd.moyu.paper.manager.vo.TopicVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author lenovo
* @description 针对表【topic】的数据库操作Service实现
* @createDate 2022-07-04 22:51:01
*/
@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic>
    implements TopicService{

    @Override
    public Page<TopicVo> pageTopicVo(TopicQuery query) {
        Page<TopicVo> page = new Page<>(query.getPageIndex(), query.getPageSize());
        List<TopicVo> topicVos = getBaseMapper().pageTopicVo(page, query);
        page.setRecords(topicVos);
        return page;
    }

    @Override
    public List<TopicTitle> selectTopicTitleByTeacherNumber(String teacherNumber) {
        return getBaseMapper().selectTopicTitleByTeacherNumber(teacherNumber);
    }

}




