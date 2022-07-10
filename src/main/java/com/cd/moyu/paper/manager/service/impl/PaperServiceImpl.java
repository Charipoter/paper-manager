package com.cd.moyu.paper.manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cd.moyu.paper.manager.common.bean.Assert;
import com.cd.moyu.paper.manager.common.consts.StatusCode;
import com.cd.moyu.paper.manager.common.strategy.FileUploadStrategyContext;
import com.cd.moyu.paper.manager.dto.PaperQuery;
import com.cd.moyu.paper.manager.exception.NormalException;
import com.cd.moyu.paper.manager.po.Paper;
import com.cd.moyu.paper.manager.po.Student;
import com.cd.moyu.paper.manager.service.PaperService;
import com.cd.moyu.paper.manager.mapper.PaperMapper;
import com.cd.moyu.paper.manager.vo.PaperVo;
import com.cd.moyu.paper.manager.vo.TopicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
* @author lenovo
* @description 针对表【paper】的数据库操作Service实现
* @createDate 2022-07-04 22:51:01
*/
@Service
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper>
    implements PaperService{
    @Autowired
    private FileUploadStrategyContext fusc;
    @Override
    public Paper getOneByStudentNumber(String studentNumber) {
        return getOne(new QueryWrapper<Paper>().eq("stu_number", studentNumber));
    }

    @Override
    public void updateSaveUrl(String studentNumber, String saveUrl) {
        update(new UpdateWrapper<Paper>()
                .eq("stu_number", studentNumber)
                .set("save_url", saveUrl)
        );
    }

    @Override
    public String savePaperFile(MultipartFile file) throws IOException {
        return fusc.upload(file);
    }

    @Override
    public boolean removePaperWithFile(Paper paper) throws NormalException, IOException {
        boolean flag = remove(new QueryWrapper<Paper>().eq("stu_number", paper.getStudentNumber()));
        Assert.checkArgument(flag, "移除论文失败", StatusCode.FAIL);
        return fusc.remove(paper.getSaveUrl());
    }

    @Override
    public Page<PaperVo> pagePaperVo(PaperQuery query) {
        Page<PaperVo> page = new Page<>(query.getPageIndex(), query.getPageSize());
        List<PaperVo> paperVos = getBaseMapper().pagePaperVo(page, query);
        page.setRecords(paperVos);
        return page;
    }

    @Override
    public boolean updateCommentByPaperId(Integer paperId, String comment) {
        return update(new UpdateWrapper<Paper>().set("comment", comment).eq("id", paperId));
    }

    @Override
    public String getFileNameFromUrl(String url) {
        // ./temp/ttt.txt
        int start = url.lastIndexOf('/') + 1, end = url.length();
        return url.substring(start, end);
    }
}




