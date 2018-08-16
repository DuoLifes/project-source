package com.cn.connext.project.multidatasource.service.mongo;

import com.cn.connext.project.multidatasource.entity.mongo.MediaInfoSource;
import com.cn.connext.project.multidatasource.repository.mongo.MediaInfoSourceRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MediaInfoSourceService {

    @Resource
    private MediaInfoSourceRepository mediaInfoSourceRepository;

    @Resource
    private MongoTemplate mongoTemplate;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


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

    //根据id查询文档
    public MediaInfoSource findDocumentById(String id){
      return  mediaInfoSourceRepository.findOne(id);
    }

    //条件查询文档  Criteria构造查询条件
    public List<MediaInfoSource> findDocumentByName(Object name){
        return  mongoTemplate.find(new Query(Criteria.where("name").is(name)),MediaInfoSource.class);
    }

    //多条件查询 Criteria构造查询条件
    public List<MediaInfoSource> findOneByNameAndRemark(Object name,Object remark){
        Object a=null;
        //And条件查询语句构造
        //Criteria andCriteria=Criteria.where("name").is(name).and("remark").is(remark);
        //范围查询语句构造
        Criteria rangeCriteria=Criteria.where("createTime").lt(a);
        //Or条件查询语句构造
        Criteria orCriteria=new Criteria().orOperator(Criteria.where("name").is(name),Criteria.where("remark").is(remark));
        return mongoTemplate.find(new Query(rangeCriteria),MediaInfoSource.class);
    }

}
