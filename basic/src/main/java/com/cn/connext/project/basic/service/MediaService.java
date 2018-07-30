package com.cn.connext.project.basic.service;

import com.cn.connext.project.basic.entity.Media;
import com.cn.connext.project.basic.repository.MediaRepository;
import com.cn.connext.project.basic.validator.MediaValidator;
import com.cn.connext.project.framework.query.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


/**
 * 媒体信息 - 业务服务对象
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */
@Service
public class MediaService {

    /**
     * 系统日志
     */
    private final static Logger logger = LoggerFactory.getLogger(MediaService.class);

    /**
     * 媒体信息 - 实体验证对象
     */
    @Resource
    private MediaValidator mediaValidator;

    /**
     * 媒体信息 - 数据访问接口
     */
    @Resource
    private MediaRepository mediaRepository;


    /**
     * 创建新的媒体信息。
     *
     * @param media 所要创建的媒体信息对象实例
     * @return 返回所创建的对象实例
     */
    public Media create(Media media) {
        media.toUpperCase(media);
        mediaValidator.createValidate(media);
        return mediaRepository.create(media);
    }

    /**
     * 修改已有媒体信息。
     *
     * @param media 所要修改的媒体信息对象实例
     * @return 返回修改后对象实例
     */
    public Media modify(Media media) {
        media.toUpperCase(media);
        mediaValidator.modifyValidate(media);
        return mediaRepository.save(media);
    }

    /**
     * 根据主键删除媒体信息。
     *
     * @param id 主键 - 唯一编号
     */
    public void delete(String id) {
        mediaValidator.deleteValidate(id);
        mediaRepository.delete(id);
    }

    /**
     * 根据主键查找媒体信息。
     *
     * @param id 主键 - 唯一编号
     * @return 返回所匹配的媒体信息对象实例
     */
    public Media findItem(String id) {
        return mediaRepository.findOne(id);
    }


    /**
     * 根据查询构造器，分页查询匹配的记录。
     *
     * @param queryBuilder 查询构造器
     * @return 返回数据分页信息
     */
    public Page<Media> findPage(QueryBuilder<Media> queryBuilder) {
        return mediaRepository.findPage(queryBuilder);
    }

    /**
     * 根据查询构造器，查询所有匹配的记录。
     * @return 返回数据集合信息
     */
    public List<Media> findList() {
        return mediaRepository.findAll();
    }
}