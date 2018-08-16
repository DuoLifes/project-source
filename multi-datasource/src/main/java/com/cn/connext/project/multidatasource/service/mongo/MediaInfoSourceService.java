package com.cn.connext.project.multidatasource.service.mongo;

import com.cn.connext.project.multidatasource.entity.mongo.MediaInfoSource;
import com.cn.connext.project.multidatasource.repository.mongo.MediaInfoSourceRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        for(int i=1;i<=10;i++){
            MediaInfoSource mediaInfoSource=new MediaInfoSource();
            mediaInfoSource.toString(mediaInfoSource,i);
            list.add(mediaInfoSource);
        }
        mediaInfoSourceRepository.batchCreate(list);
    }

    //根据id删除文档
    public void delete(String id){
        mediaInfoSourceRepository.delete(id);
    }

    //修改文档
    public void update(Object name,Object remark){
        Criteria orCriteria=new Criteria().orOperator(Criteria.where("name").is(name),Criteria.where("remark").is(remark));
        Query query=new Query(orCriteria);
        Update update=new Update();
        Object upName="陈奕迅";
        Object upRemark="歌神";
        update.rename("type","社会王");//用来指定一个字段的新名字
        update.set("name",upName);
        update.set("remark",upRemark);
        mediaInfoSourceRepository.update(query,update);
        //updateFirst修改符合条件的第一条文档
        //mongoTemplate.findAndModify()
    }

    //根据id查询文档
    public MediaInfoSource findDocumentById(String id){
      return  mediaInfoSourceRepository.findOne(id);
    }

    //单条件查询文档  Criteria构造查询条件
    public List<MediaInfoSource> findDocumentByName(Object name){
        return  mongoTemplate.find(new Query(Criteria.where("name").is(name)),MediaInfoSource.class);
    }

    //多条件查询 Criteria构造查询条件
    public List<MediaInfoSource> findOneByNameAndRemark(Object name,Object remark){
        //And条件查询语句构造
        //Criteria andCriteria=Criteria.where("name").is(name).and("remark").is(remark);
        //范围查询语句构造
        //Criteria rangeCriteria=Criteria.where("createTime").gt(begin).lt(end);
        //Or条件查询语句构造
        Criteria orCriteria=new Criteria().orOperator(Criteria.where("name").is(name),Criteria.where("remark").is(remark));
        return mongoTemplate.find(new Query(orCriteria),MediaInfoSource.class);
    }

    //案例查询（Example）
    public Page<MediaInfoSource> findByExample(MediaInfoSource mediaInfoSource){
        mediaInfoSource.setId(null);//无关查询条件置空
        mediaInfoSource.setCreateTime(null);//初始化实体默认值清空
        Example <MediaInfoSource> example=Example.of(mediaInfoSource);
        return mediaInfoSourceRepository.findAll(example,new PageRequest(0,5));
    }

    //自定义案例查询
    public Page<MediaInfoSource> findByCustomExample(MediaInfoSource mediaInfoSource){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith())//模糊查询匹配开头，即{name}%
                .withMatcher("type" ,ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{type}%
                .withMatcher("remark" ,ExampleMatcher.GenericPropertyMatchers.endsWith())//模糊查询匹配结尾，即%{remark}
                .withIgnorePaths("id")//忽略字段，即不管id是什么值都不加入查询条件
                .withIgnorePaths("createTime");//忽略字段，即不管updateTime是什么值都不加入查询条件
        Example<MediaInfoSource> example = Example.of(mediaInfoSource ,matcher);
        return  mediaInfoSourceRepository.findAll(example,new PageRequest(0,5));
    }

    //查询数量
    public Long count(){
        return mediaInfoSourceRepository.count();
    }

    //按条件查询数量
    public Long countByExample(MediaInfoSource mediaInfoSource){
        mediaInfoSource.setId(null);//无关查询条件置空
        mediaInfoSource.setCreateTime(null);//初始化实体默认值清空
        Example <MediaInfoSource> example=Example.of(mediaInfoSource);
        return mediaInfoSourceRepository.count(example);
    }

    //分组聚合（可以显示其他字段）
    public GroupByResults<MediaInfoSource> group(){
        GroupBy groupBy = GroupBy.key("name","remark").initialDocument("{createTime:[],count:0}")
                .reduceFunction("function(doc, prev){" + "prev.createTime.push(doc.createTime);" + "prev.count+=1}");
        return mongoTemplate.group("mediaInfoSource", groupBy,MediaInfoSource.class);
    }

    //条件查询再分组聚合
    public GroupByResults<MediaInfoSource> findByGroup(Object name, Object remark){
        GroupBy groupBy = GroupBy.key("name","remark").initialDocument("{createTime:[],count:0}")
                .reduceFunction("function(doc, prev){" + "prev.createTime.push(doc.createTime);" + "prev.count+=1}");
        Criteria orCriteria=new Criteria().orOperator(Criteria.where("name").is(name),Criteria.where("remark").is(remark));
        return mongoTemplate.group(orCriteria,"mediaInfoSource",groupBy,MediaInfoSource.class);
    }
}
