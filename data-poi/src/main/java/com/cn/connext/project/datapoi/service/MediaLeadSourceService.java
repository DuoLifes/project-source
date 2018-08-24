package com.cn.connext.project.datapoi.service;

import com.cn.connext.project.datapoi.entity.MediaLeadSource;
import com.cn.connext.project.datapoi.repository.MediaLeadSourceRepository;
import com.cn.connext.project.framework.exception.ServiceException;
import com.cn.connext.project.framework.io.FileUtils;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class MediaLeadSourceService {

    @Resource
    private MediaLeadSourceRepository mediaLeadSourceRepository;

    //创建文档
    public MediaLeadSource create(MediaLeadSource mediaLeadSource){
       return mediaLeadSourceRepository.create(mediaLeadSource);
    }

    //从es导出至文档
    public FileOutputStream exportByEs( FileOutputStream outputStream)throws IOException {
        return mediaLeadSourceRepository.exportByEs(outputStream);
    }

    //文件上传
    public String upload(MultipartFile file, String fileName,String uploadPath){
        if(file.getSize()<=0){
            throw new ServiceException("File_EMPTY_Error", "所要上传的文件不能为空。");
        }

        try {
            FileUtils.prepareFolder(uploadPath);
            FileUtils.saveFileUtf(uploadPath + fileName, file.getBytes());
            return uploadPath + fileName;
        } catch (Exception e) {
            System.out.println("保存文件发生错误:" +e);
            throw new ServiceException("File_Save_Error", "保存文件发生错误。");
        }
    }
}
