package com.cd.moyu.paper.manager.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cd.moyu.paper.manager.dto.TopicQuery;
import com.cd.moyu.paper.manager.dto.TopicTitle;
import com.cd.moyu.paper.manager.po.Topic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cd.moyu.paper.manager.vo.TopicVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author lenovo
* @description 针对表【topic】的数据库操作Mapper
* @createDate 2022-07-06 20:07:06
* @Entity com.cd.moyu.paper.manager.po.Topic
*/
public interface TopicMapper extends BaseMapper<Topic> {
    List<TopicVo> pageTopicVo(Page<TopicVo> page, @Param("query") TopicQuery query);
    List<TopicTitle> selectTopicTitleByTeacherNumber(@Param("teacherNumber") String teacherNumber);
}




