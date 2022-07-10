package com.cd.moyu.paper.manager.service;

import com.cd.moyu.paper.manager.dto.MajorStatistic;
import com.cd.moyu.paper.manager.po.Major;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author lenovo
* @description 针对表【major】的数据库操作Service
* @createDate 2022-07-04 22:51:01
*/
public interface MajorService extends IService<Major> {
    Major getOneByMajorName(String name);
    List<MajorStatistic> studentCountPerMajor();
}
