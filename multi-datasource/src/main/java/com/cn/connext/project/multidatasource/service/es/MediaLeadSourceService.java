package com.cn.connext.project.multidatasource.service.es;

import com.cn.connext.project.multidatasource.entity.es.MediaLeadSource;
import com.cn.connext.project.multidatasource.repository.es.MediaLeadSourceRepository;
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
