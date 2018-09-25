package com.cn.connext.project.knowledge.webapi;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.knowledge.domain.Genericity;
import com.cn.connext.project.knowledge.entity.Media;
import com.cn.connext.project.knowledge.service.MediaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import javax.annotation.Resource;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 媒体信息 - WebAPI访问接口
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */
@WebAPI("/api/knoledge/media")
public class MediaAPI {

    /**
     * 媒体信息 - 业务服务对象
     */
    @Resource
    private MediaService mediaService;

    private static final Logger logger = LoggerFactory.getLogger(MediaAPI.class);

    /**
     * 根据查询构造器，查询所有匹配的记录。
     * @return 返回数据集合信息
     */
    @GetMapping("/list")
    public List<Media> findList() {
        return mediaService.findList();
    }


    /*验证泛型的使用*/
    @GetMapping("/genericity")
    public List<Media> findAll(){
        List<Media> list=mediaService.findList();
        Genericity genericity=new Genericity();
        /*把Media集合传入泛型类genericity中进行业务逻辑处理*/
        genericity.list=list;
        return genericity.toList();
    }

    /*学习lamda表达式*/
    @GetMapping("/lamda01")
    public Hashtable<String, String> findMap01(){
        Hashtable<String, String> hashtable = new Hashtable<>();
        mediaService.findList().stream()
                .filter(media -> media.getRemark()!=null)
                .filter(media -> "AAA".equals(media.getRemark()))//两个filter过滤是并且的关系
                .forEach(media ->hashtable.put(media.getId(),media.getRemark()));
        return hashtable;
    }
    @GetMapping("/lamda02")
    public Map<String, Media> findMap02(){
        Map<String, Media> map = mediaService.findList().stream()
                .collect(Collectors.toMap(o -> o.getId(),o -> o));
        return map;
    }
    @GetMapping("/lamda03")
    public long count(){
        long count=mediaService.findList().stream()
                .filter(media -> "SA".equals(media.getCode()))
                .filter(media -> media.getCode().toString().length()>2).count();
        return count;
    }
}

