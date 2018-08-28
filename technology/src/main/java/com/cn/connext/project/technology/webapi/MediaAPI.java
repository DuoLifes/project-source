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

    @GetMapping("/findAll")
    public List<Media> findAll() {
        return mediaRepository.findAll();
    }
}