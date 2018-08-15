package com.cn.connext.project.basic.webapi;

import com.cn.connext.project.basic.cache.GlobalCacheManager;
import com.cn.connext.project.basic.cache.MediaCache;
import com.cn.connext.project.basic.entity.Media;
import com.cn.connext.project.basic.mq.BasicDataSourceProductor;
import com.cn.connext.project.basic.queryinfo.MediaQuery;
import com.cn.connext.project.basic.service.MediaService;
import com.cn.connext.project.framework.JSON;
import com.cn.connext.project.framework.annotation.QueryInfo;
import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.framework.query.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 媒体信息 - WebAPI访问接口
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */
@WebAPI("/api/basic/media")
public class MediaAPI {

    /**
     * 媒体信息 - 业务服务对象
     */
    @Resource
    private MediaService mediaService;
    @Resource
    private BasicDataSourceProductor basicDataSourceProductor;
    @Resource
    private MediaCache mediaCache;
    @Resource
    private GlobalCacheManager globalCacheManager;


    private static final Logger logger = LoggerFactory.getLogger(MediaAPI.class);

    /**
     * 创建新的媒体信息。
     *
     * @param media 所要创建的媒体信息对象实例
     * @return 返回所创建的对象实例
     */
    @PostMapping
    public Media create(@RequestBody Media media) {
        return mediaService.create(media);
    }

    /**
     * 修改已有媒体信息。
     *
     * @param media 所要修改的媒体信息对象实例
     * @return 返回修改后对象实例
     */
    @PutMapping
    public Media modify(@RequestBody Media media) {
        return mediaService.modify(media);
    }

    /**
     * 根据主键删除媒体信息。
     *
     * @param id 主键 - 唯一编号
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        mediaService.delete(id);
    }

    /**
     * 根据主键查找媒体信息。
     *
     * @param id 主键 - 唯一编号
     * @return 返回所匹配的媒体信息对象实例
     */
    @GetMapping("/{id}")
    public Media findItem(@PathVariable String id) {
        return mediaService.findItem(id);
    }

    /**
     * 根据查询构造器，分页查询匹配的记录。
     *
     * @param queryBuilder 查询构造器
     * @return 返回数据分页信息
     */
    @GetMapping
    @QueryInfo(MediaQuery.class)
    public Page<Media> findPage(QueryBuilder<Media> queryBuilder) {
        return mediaService.findPage(queryBuilder);
    }

    /**
     * 根据查询构造器，查询所有匹配的记录。
     * @return 返回数据集合信息
     */
    @GetMapping("/list")
    public List<Media> findList() {
        return mediaService.findList();
    }

    @GetMapping("/cache")
    public List<Media> findAll() {
        return mediaCache.getMediaList();
    }

    @GetMapping("/clearCache")
    public void clearCache(){
        globalCacheManager.clearCache("Media");
    }

    @GetMapping("/send")
    public void send(){
        Media media=new Media();
        media.setId("001");
        media.setCode("Tengxun");
        media.setName("腾讯");
        String msg= JSON.toJsonString(media).toString();
        basicDataSourceProductor.send(msg);
    }

    //JPA封装方法直接调用
    @GetMapping("/findAllByCodeAndName")
    public List<Media> findAllByCodeAndName(@RequestParam String code,@RequestParam String name){
        return mediaService.findAllByCodeAndName(code,name);
    }

    //JPA自定义SQL
    @GetMapping("/findAllByCode")
    public List<Media> findAllByCode(@RequestParam String code){
        return mediaService.findAllByCode(code);
    }

    //按例查询（example）
    @PostMapping("/findByExample")
    public List<Media> findByExample(@RequestBody Media media){
        media.setUpdateTime(null);//用按例Example查询，默认情况下会忽略空值。
        media.setId(null);//由于默认实例化这三个字段有值，会影响查询。
        media.setIsInvalid(null);//所以无关查询字段要置空。
        return mediaService.findByExample(media);
    }

    //自定义按例查询
    @PostMapping("/findByCustomExample")
    public List<Media> findByCustomExample(@RequestBody Media media){
        return mediaService.findByCustomExample(media);
    }

    //Criteria API动态查询
    @PostMapping("/findByCriteria")
    public List<Media> findByCriteria(@RequestBody Media media){
        return mediaService.findByCriteria(media);
    }

}

