package com.cd.moyu.paper.manager.mapper;

import com.cd.moyu.paper.manager.dto.MajorStatistic;
import com.cd.moyu.paper.manager.po.Major;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author lenovo
* @description 针对表【major】的数据库操作Mapper
* @createDate 2022-07-04 22:51:01
* @Entity com.cd.moyu.paper.manager.po.Major
*/
public interface MajorMapper extends BaseMapper<Major> {
    List<MajorStatistic> studentCountPerMajor();
}




