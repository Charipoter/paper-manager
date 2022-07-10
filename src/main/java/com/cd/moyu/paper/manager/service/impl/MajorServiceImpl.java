package com.cd.moyu.paper.manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cd.moyu.paper.manager.dto.MajorStatistic;
import com.cd.moyu.paper.manager.po.Major;
import com.cd.moyu.paper.manager.service.MajorService;
import com.cd.moyu.paper.manager.mapper.MajorMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author lenovo
* @description 针对表【major】的数据库操作Service实现
* @createDate 2022-07-04 22:51:01
*/
@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major>
    implements MajorService{

    @Override
    public Major getOneByMajorName(String name) {
        return getOne(new QueryWrapper<Major>().eq("major_name", name));
    }

    @Override
    public List<MajorStatistic> studentCountPerMajor() {
        return getBaseMapper().studentCountPerMajor();
    }
}




