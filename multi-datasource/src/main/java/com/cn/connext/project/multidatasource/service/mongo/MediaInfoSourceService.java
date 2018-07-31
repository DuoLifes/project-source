package com.cn.connext.project.multidatasource.service.mongo;

import com.cn.connext.project.multidatasource.entity.es.MediaLeadSource;
import com.cn.connext.project.multidatasource.entity.mongo.MediaInfoSource;
import com.cn.connext.project.multidatasource.repository.mongo.MediaInfoSourceRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MediaInfoSourceService {

    @Resource
    private MediaInfoSourceRepository mediaInfoSourceRepository;

    public MediaInfoSource create(MediaInfoSource mediaInfoSource){
       return mediaInfoSourceRepository.save(mediaInfoSource);
    }
}
