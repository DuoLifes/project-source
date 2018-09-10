package com.cn.connext.project.qrcode.repository;

import com.cn.connext.project.framework.repository.ConnextRepository;
import com.cn.connext.project.qrcode.entity.QrCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 二维码基础信息 - 数据访问接口定义
 * 开发人员: 张帅
 * 修订日期: 2018-05-31 17:31:23
 */
@Repository
public interface QrCodeRepository extends ConnextRepository<QrCode, String>, JpaRepository<QrCode, String>, JpaSpecificationExecutor<QrCode> {

    @Query(nativeQuery = true,value = "select * from qrCode where(code = ?1 or code = ?2 or code = ?3) and (state = ?4 or state = ?5 or state = ?6) and applyScope like %?9% order by updateTime desc limit ?7,?8")
    List<QrCode> findQrcodeList(@Param("code1") String code1, @Param("code2") String code2, @Param("code3") String code3, @Param("state4") String state4, @Param("state5") String state5, @Param("state6") String state6, @Param("page") Integer page, @Param("size") Integer size, @Param("applyScope") String applyScope);

    @Query(nativeQuery = true,value = "select count(*) from qrCode where(code = ?1 or code = ?2 or code = ?3) and (state = ?4 or state = ?5 or state = ?6) and applyScope like %?7%")
    Integer findQrcodeListCount(@Param("code1") String code1, @Param("code2") String code2, @Param("code3") String code3, @Param("state4") String state4, @Param("state5") String state5, @Param("state6") String state6, @Param("applyScope") String applyScope);

    @Query(nativeQuery = true,value = "select * from qrCode order by updateTime desc")
    List<QrCode> findAllQrcode();

    @Query(nativeQuery = true,value = "select * from qrCode where imgUrl = ?1 order by updateTime desc limit 0,1")
    QrCode findOneQrcode(@Param("imgUrl") String imgUrl);

}

