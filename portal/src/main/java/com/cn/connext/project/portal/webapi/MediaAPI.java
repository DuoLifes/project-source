package com.cn.connext.project.portal.webapi;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.portal.entity.Media;
import com.cn.connext.project.portal.repository.MediaEsRepository;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@WebAPI("/api/portal/media")
public class MediaAPI {

    @Resource
    private MediaEsRepository mediaEsRepository;

    @GetMapping
    public void create(){
        Media media=new Media();
        media.setId("004");
        media.setName("优酷网");
        mediaEsRepository.create(media);
    }
}
