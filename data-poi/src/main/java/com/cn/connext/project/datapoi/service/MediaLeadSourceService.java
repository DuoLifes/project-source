package com.cn.connext.project.datapoi.service;

import com.cn.connext.project.datapoi.entity.MediaLeadSource;
import com.cn.connext.project.datapoi.repository.MediaLeadSourceRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MediaLeadSourceService {

    @Resource
    private MediaLeadSourceRepository mediaLeadSourceRepository;

    public MediaLeadSource create(MediaLeadSource mediaLeadSource){
       return mediaLeadSourceRepository.create(mediaLeadSource);
    }
}
