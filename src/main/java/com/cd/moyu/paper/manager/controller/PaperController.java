package com.cd.moyu.paper.manager.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cd.moyu.paper.manager.common.bean.Assert;
import com.cd.moyu.paper.manager.common.bean.Result;
import com.cd.moyu.paper.manager.common.consts.StatusCode;
import com.cd.moyu.paper.manager.dto.PaperFile;
import com.cd.moyu.paper.manager.dto.PaperQuery;
import com.cd.moyu.paper.manager.dto.TopicQuery;
import com.cd.moyu.paper.manager.exception.NormalException;
import com.cd.moyu.paper.manager.po.Paper;
import com.cd.moyu.paper.manager.service.PaperService;
import com.cd.moyu.paper.manager.vo.PaperVo;
import com.cd.moyu.paper.manager.vo.TopicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.server.ExportException;

@RestController
public class PaperController {
    @Autowired
    private PaperService paperService;

    @GetMapping("/papers/student/{studentNumber}")
    public Result getOneByStudentNumber(@PathVariable String studentNumber) throws NormalException {

        Paper existPaper = paperService.getOneByStudentNumber(studentNumber);
        Assert.checkArgument(existPaper != null, "毕业设计不存在", StatusCode.FAIL);

        return Result.ok("获取成功", existPaper);
    }

    @PreAuthorize("hasAuthority('student')")
    @PostMapping("/papers")
    @Transactional(rollbackFor = NormalException.class)
    public Result saveOne(Paper paper, MultipartFile paperFile) throws NormalException {

        try {
            Paper existPaper = paperService.getOneByStudentNumber(paper.getStudentNumber());

            if (existPaper != null) {
                paperService.removePaperWithFile(existPaper);
            }

            paperService.save(paper);
            paper.setSaveUrl(paperService.savePaperFile(paperFile));
            // 完善url信息
            paperService.updateSaveUrl(paper.getStudentNumber(), paper.getSaveUrl());

        } catch (IOException e) {
            throw new NormalException("毕业设计保存失败", StatusCode.FAIL);
        }

        return Result.ok("存储成功", paper);
    }

    @PreAuthorize("hasAuthority('teacher')")
    @PostMapping ("/papers/page")
    public Result selectPage(@RequestBody PaperQuery paperQuery) {

        Page<PaperVo> paperVos = paperService.pagePaperVo(paperQuery);

        return Result.ok("查询成功", paperVos);
    }

    @PreAuthorize("hasAuthority('teacher')")
    @PutMapping("/papers/{paperId}/comment")
    public Result updateCommentByPaperId(@PathVariable Integer paperId,
                                         String comment) throws NormalException {

        boolean flag = paperService.updateCommentByPaperId(paperId, comment);
        Assert.checkArgument(flag, "论文不存在", StatusCode.FAIL);

        return Result.ok("评语成功");
    }

    @PreAuthorize("hasAuthority('teacher')")
    @GetMapping("/papers/{paperId}/download")
    public byte[] downloadPaperFile(@PathVariable Integer paperId,
                                    HttpServletResponse response) {

        Paper paper = paperService.getById(paperId);
        // 获取该文件的输入流
        try (FileInputStream inputStream = new FileInputStream(paper.getSaveUrl())) {

            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            //设置响应头
            response.addHeader("Content-Disposition", "attachment;filename=" +
                    paperService.getFileNameFromUrl(paper.getSaveUrl())
            );

            return bytes;
        } catch (Exception e) {
            return null;
        }
    }
}
