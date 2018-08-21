package com.cn.connext.project.datapoi.service;

import com.cn.connext.project.datapoi.entity.MediaLeadSource;
import com.cn.connext.project.datapoi.repository.MediaLeadSourceRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class MediaLeadSourceService {

    @Resource
    private MediaLeadSourceRepository mediaLeadSourceRepository;

    public MediaLeadSource create(MediaLeadSource mediaLeadSource){
       return mediaLeadSourceRepository.create(mediaLeadSource);
    }


    public FileOutputStream exportByEs(QueryBuilder queryBuilder, FileOutputStream outputStream)throws IOException {
        return mediaLeadSourceRepository.exportByEs(queryBuilder,outputStream);
    }
}
