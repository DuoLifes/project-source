package com.cn.connext.project.multidatasource.service.mongo;

import com.cn.connext.project.multidatasource.entity.es.MediaLeadSource;
import com.cn.connext.project.multidatasource.entity.mongo.MediaInfoSource;
import com.cn.connext.project.multidatasource.repository.mongo.MediaInfoSourceRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MediaInfoSourceService {

    @Resource
    private MediaInfoSourceRepository mediaInfoSourceRepository;

    //创建文档
    public MediaInfoSource create(MediaInfoSource mediaInfoSource){
       return mediaInfoSourceRepository.save(mediaInfoSource);
    }

    //创建文档集合
    public void createList(){
        List<MediaInfoSource> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            MediaInfoSource mediaInfoSource=new MediaInfoSource();
            mediaInfoSource.toString(mediaInfoSource,i);
            list.add(mediaInfoSource);
        }
        mediaInfoSourceRepository.batchCreate(list);
    }

    //删除文档
    public void delete(String id){
        mediaInfoSourceRepository.delete(id);
    }


    //修改文档

}
