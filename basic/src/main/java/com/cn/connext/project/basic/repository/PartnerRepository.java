package com.cn.connext.project.basic.repository;

import com.cn.connext.project.basic.domain.PageAble;
import com.cn.connext.project.basic.entity.Partner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface PartnerRepository {

    //根据code查询所有实体，返回集合
    List<Partner> findByCode(String code);

    //查询所有实体只包含特定字段
    List<Partner> findIdAndName();

    //通过注入SQL的方式映射
    @Select("select * from partner")
    List<Partner> findAll();

    //动态查询
    List<Partner> selectByCode(String code);

    //查询总条数
    public int findCount();

    //分页查询方法1
    List<Partner> findByPage(Map<String, Object> map);

    //分页查询方法2
    List<Partner> findPage(PageAble pageAble);

    //分组聚合
    List<Partner> findGroup();
}
