package com.cn.connext.project.datapoi.service;

import com.cn.connext.project.datapoi.entity.MediaType;
import com.cn.connext.project.datapoi.repository.MediaTypeRepository;
import com.cn.connext.project.framework.query.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


/**
 * 媒体类型信息 - 业务服务对象
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */
@Service
public class MediaTypeService {

    /**
     * 系统日志
     */
    private final static Logger logger = LoggerFactory.getLogger(MediaTypeService.class);
    /**
     * 媒体类型信息 - 数据访问接口
     */
    @Resource
    private MediaTypeRepository mediaTypeRepository;


    /**
     * 创建新的媒体类型信息。
     *
     * @param mediaType 所要创建的媒体类型信息对象实例
     * @return 返回所创建的对象实例
     */
    public MediaType create(MediaType mediaType) {
        return mediaTypeRepository.create(mediaType);
    }

    /**
     * 修改已有媒体类型信息。
     *
     * @param mediaType 所要修改的媒体类型信息对象实例
     * @return 返回修改后对象实例
     */
    public MediaType modify(MediaType mediaType) {
        //createIndex默认不变
        mediaType.setCreateIndex(mediaTypeRepository.findOne(mediaType.getId()).getCreateIndex());
        return mediaTypeRepository.save(mediaType);
    }

    /**
     * 根据主键删除媒体类型信息。
     *
     * @param id 主键 - 唯一编号
     */
    public void delete(String id) {
        mediaTypeRepository.delete(id);
    }

    /**
     * 根据主键查找媒体类型信息。
     *
     * @param id 主键 - 唯一编号
     * @return 返回所匹配的媒体类型信息对象实例
     */
    public MediaType findItem(String id) {
        return mediaTypeRepository.findOne(id);
    }

    /**
     * 根据查询构造器，分页查询匹配的记录。
     *
     * @param queryBuilder 查询构造器
     * @return 返回数据分页信息
     */
    public Page<MediaType> findPage(QueryBuilder<MediaType> queryBuilder) {
        return mediaTypeRepository.findPage(queryBuilder);
    }

    /**
     * 根据查询构造器，查询所有匹配的记录。
     *
     * @param queryBuilder 查询构造器
     * @return 返回数据集合信息
     */
    public List<MediaType> findList(QueryBuilder<MediaType> queryBuilder) {
        return mediaTypeRepository.findList(queryBuilder);
    }

}

