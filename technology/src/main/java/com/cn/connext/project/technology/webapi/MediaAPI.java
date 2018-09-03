package com.cn.connext.project.technology.webapi;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.technology.entity.Media;
import com.cn.connext.project.technology.repository.MediaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import javax.annotation.Resource;
import java.util.List;

@WebAPI("/api/technology/media")
public class MediaAPI {

    @Resource
    private MediaRepository mediaRepository;

    @GetMapping("/create")
    public Media create(){
        Media media=new Media();
        media.setMediaTypeId("433E44B0-C6B3-4E15-8F1E-C626BA248A8C");
        media.setCode("SA09776");
        media.setName("测试媒体");
        media.setRemark("测试媒体备注");
        return mediaRepository.save(media);
    }

    @GetMapping("/findAll")
    public List<Media> findAll() {
        return mediaRepository.findAll();
    }
}