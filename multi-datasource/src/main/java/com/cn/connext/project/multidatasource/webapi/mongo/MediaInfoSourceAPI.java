package com.cn.connext.project.multidatasource.webapi.mongo;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.multidatasource.entity.mongo.MediaInfoSource;
import com.cn.connext.project.multidatasource.service.mongo.MediaInfoSourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@WebAPI("/api/multi-datasource/mediaInfoSource")
public class MediaInfoSourceAPI {

    @Resource
    private MediaInfoSourceService mediaInfoSourceService;

    //创建文档
    @PostMapping("/create")
    public MediaInfoSource create(@RequestBody MediaInfoSource mediaInfoSource){
        return mediaInfoSourceService.create(mediaInfoSource);
    }

    //创建文档集合
    @GetMapping("/createList")
    public void createList(){
        mediaInfoSourceService.createList();
    }

    //删除文档
    @GetMapping("/delete")
    public void delete(@RequestParam String id){
         mediaInfoSourceService.delete(id);
    }

}
