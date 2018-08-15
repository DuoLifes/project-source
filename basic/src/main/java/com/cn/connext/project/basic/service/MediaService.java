package com.cn.connext.project.basic.service;

import com.cn.connext.project.basic.entity.Media;
import com.cn.connext.project.basic.repository.MediaRepository;
import com.cn.connext.project.basic.validator.MediaValidator;
import com.cn.connext.project.framework.query.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.persistence.criteria.*;
import java.util.ArrayList;
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

    //JPA封装方法直接调用
    public List<Media> findAllByCodeAndName(String code,String name){
        return mediaRepository.findAllByCodeAndName(code,name);
    }

    //JPA自定义SQL
    public List<Media> findAllByCode(String code){
        return mediaRepository.findAllByCode(code);
    }

    //按例查询（example）
    public List<Media> findByExample(Media media){
        Example<Media> example = Example.of(media);
        List<Media> list = mediaRepository.findAll(example);
        return list;
    }

    //自定义按例查询
    public List<Media> findByCustomExample(Media media){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith())//模糊查询匹配开头，即{username}%
                .withMatcher("code" ,ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
                .withMatcher("remark" ,ExampleMatcher.GenericPropertyMatchers.endsWith())//模糊查询匹配结尾，即%{username}
                .withIgnorePaths("id")//忽略字段，即不管id是什么值都不加入查询条件
                .withIgnorePaths("updateTime")//忽略字段，即不管updateTime是什么值都不加入查询条件
                .withIgnorePaths("isInvalid");//忽略字段，即不管isInvalid是什么值都不加入查询条件
        Example<Media> example = Example.of(media ,matcher);
        return  mediaRepository.findAll(example);
    }

    //Criteria API动态查询
    public List<Media> findByCriteria(Media media){
        Specification query = new Specification<Media>() {
            @Override
            public Predicate toPredicate(Root<Media> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                    //创建查询条件容器
                    List<Predicate> predicateList_and = new ArrayList<>();
                    List<Predicate> predicateList_or = new ArrayList<>();
                    //获取要查询的字段
                    Path<String> pathCode = root.get("code");
                    Path<String> pathName = root.get("name");
                    Path<String> pathRemark = root.get("remark");
                    //将查询条件放入容器内
                    predicateList_and.add(cb.equal(pathCode,media.getCode()));
                    predicateList_and.add(cb.like(pathName, media.getName() + "%"));
                    predicateList_or.add(cb.equal(pathRemark, media.getRemark()));
                    //把查询容器集合转化为二维数组
                    Predicate[] predicates_and = predicateList_and.toArray(new Predicate[predicateList_and.size()]);
                    Predicate[] predicates_or = predicateList_or.toArray(new Predicate[predicateList_or.size()]);
                    //把Predicate类型的二维数组再次转化为Predicate类型进而拼接
                    Predicate predicate_and = cb.and(predicates_and);
                    Predicate predicate_or = cb.and(predicates_or);
                return cb.or(predicate_and, predicate_or);
            }
        };
        return mediaRepository.findAll(query);
    }


}