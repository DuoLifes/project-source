package com.cn.connext.project.multidatasource.webapi.mongo;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.multidatasource.entity.mongo.MediaInfoSource;
import com.cn.connext.project.multidatasource.service.mongo.MediaInfoSourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

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

    //根据id查询文档
    @GetMapping("/findDocumentById")
    public MediaInfoSource findDocumentById(@RequestParam String id){
        return mediaInfoSourceService.findDocumentById(id);
    }

    //条件查询文档 Criteria构造查询条件
    @GetMapping("/findDocumentByName")
    public List<MediaInfoSource> findOne(@RequestParam String name){
        return mediaInfoSourceService.findDocumentByName(name);
    }

    //多条件查询 Criteria构造查询条件
    @GetMapping("/findOneByNameAndRemark")
    public List<MediaInfoSource> findOneByNameAndRemark(@RequestParam String name,@RequestParam String remark){
        return mediaInfoSourceService.findOneByNameAndRemark(name,remark);
    }
}
