package com.cn.connext.project.datapoi.webapi;

import com.cn.connext.project.datapoi.entity.MediaLeadSource;
import com.cn.connext.project.datapoi.service.MediaLeadSourceService;
import com.cn.connext.project.framework.annotation.WebAPI;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@WebAPI("/api/data-poi/mediaLeadSource")
public class MediaLeadSourceAPI {

    @Resource
    private MediaLeadSourceService mediaLeadSourceService;

    @PostMapping
    public MediaLeadSource create(@RequestBody MediaLeadSource mediaLeadSource){
        return mediaLeadSourceService.create(mediaLeadSource);
    }
}
