package com.cd.moyu.paper.manager.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cd.moyu.paper.manager.dto.PaperQuery;
import com.cd.moyu.paper.manager.dto.TopicQuery;
import com.cd.moyu.paper.manager.po.Paper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cd.moyu.paper.manager.vo.PaperVo;
import com.cd.moyu.paper.manager.vo.TopicVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author lenovo
* @description 针对表【paper】的数据库操作Mapper
* @createDate 2022-07-06 15:51:25
* @Entity com.cd.moyu.paper.manager.po.Paper
*/
public interface PaperMapper extends BaseMapper<Paper> {
    List<PaperVo> pagePaperVo(Page<PaperVo> page, @Param("query") PaperQuery query);
}




