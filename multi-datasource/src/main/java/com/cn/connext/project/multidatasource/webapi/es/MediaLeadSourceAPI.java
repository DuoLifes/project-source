package com.cn.connext.project.multidatasource.webapi.es;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.multidatasource.entity.es.MediaLeadSource;
import com.cn.connext.project.multidatasource.service.es.MediaLeadSourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@WebAPI("/api/multi-datasource/mediaLeadSource")
public class MediaLeadSourceAPI {

    @Resource
    private MediaLeadSourceService mediaLeadSourceService;

    @PostMapping
    public MediaLeadSource create(@RequestBody MediaLeadSource mediaLeadSource){
        return mediaLeadSourceService.create(mediaLeadSource);
    }
}
