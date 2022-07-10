package com.cd.moyu.paper.manager.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cd.moyu.paper.manager.dto.PaperQuery;
import com.cd.moyu.paper.manager.dto.TopicQuery;
import com.cd.moyu.paper.manager.exception.NormalException;
import com.cd.moyu.paper.manager.po.Paper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cd.moyu.paper.manager.vo.PaperVo;
import com.cd.moyu.paper.manager.vo.TopicVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
* @author lenovo
* @description 针对表【paper】的数据库操作Service
* @createDate 2022-07-04 22:51:01
*/
public interface PaperService extends IService<Paper> {
    Paper getOneByStudentNumber(String studentNumber);
    void updateSaveUrl(String studentNumber, String saveUrl);
    String savePaperFile(MultipartFile file) throws IOException;
    boolean removePaperWithFile(Paper paper) throws NormalException, IOException;
    Page<PaperVo> pagePaperVo(PaperQuery query);
    boolean updateCommentByPaperId(Integer paperId, String comment);
    String getFileNameFromUrl(String url);

}
