package com.cn.connext.project.multidatasource.webapi.mongo;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.multidatasource.entity.mongo.MediaInfoSource;
import com.cn.connext.project.multidatasource.service.mongo.MediaInfoSourceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@WebAPI("/api/multi-datasource/mediaInfoSource")
public class MediaInfoSourceAPI {

    @Resource
    private MediaInfoSourceService mediaInfoSourceService;

    @PostMapping
    public MediaInfoSource create(@RequestBody MediaInfoSource mediaInfoSource){
        return mediaInfoSourceService.create(mediaInfoSource);
    }
}
