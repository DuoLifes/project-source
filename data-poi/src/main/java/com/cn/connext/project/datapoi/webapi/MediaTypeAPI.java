package com.cn.connext.project.datapoi.webapi;

import com.cn.connext.project.datapoi.entity.MediaType;
import com.cn.connext.project.datapoi.service.MediaTypeService;
import com.cn.connext.project.framework.annotation.QueryInfo;
import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.framework.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 媒体类型信息 - WebAPI访问接口
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */
@WebAPI("/api/data-poi/mediaType")
public class MediaTypeAPI {

    /**
     * 媒体类型信息 - 业务服务对象
     */
    @Resource
    private MediaTypeService mediaTypeService;


    /**
     * 创建新的媒体类型信息。
     *
     * @param mediaType 所要创建的媒体类型信息对象实例
     * @return 返回所创建的对象实例
     */
    @PostMapping
    public MediaType create(@RequestBody MediaType mediaType) {
        mediaTypeService.create(mediaType);
        return mediaType;
    }

    /**
     * 修改已有媒体类型信息。
     *
     * @param mediaType 所要修改的媒体类型信息对象实例
     * @return 返回修改后对象实例
     */
    @PutMapping
    public MediaType modify(@RequestBody MediaType mediaType) {
        mediaTypeService.modify(mediaType);
        return mediaType;
    }

    /**
     * 根据主键删除媒体类型信息。
     *
     * @param id 主键 - 唯一编号
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        mediaTypeService.delete(id);
    }

    /**
     * 根据主键查找媒体类型信息。
     *
     * @param id 主键 - 唯一编号
     * @return 返回所匹配的媒体类型信息对象实例
     */
    @GetMapping("/{id}")
    public MediaType findItem(@PathVariable String id) {
        return mediaTypeService.findItem(id);
    }

    /**
     * 根据查询构造器，分页查询匹配的记录。
     *
     * @param queryBuilder 查询构造器
     * @return 返回数据分页信息
     */
    @GetMapping
    public Page<MediaType> findPage(QueryBuilder<MediaType> queryBuilder) {
        return mediaTypeService.findPage(queryBuilder);
    }

    /**
     * 根据查询构造器，查询所有匹配的记录。
     *
     * @param queryBuilder 查询构造器
     * @return 返回数据集合信息
     */
    @GetMapping("/list")
    public List<MediaType> findList(QueryBuilder<MediaType> queryBuilder) {
        return mediaTypeService.findList(queryBuilder);
    }

}

