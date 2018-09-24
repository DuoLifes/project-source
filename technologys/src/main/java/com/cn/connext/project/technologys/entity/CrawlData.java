package com.cn.connext.project.technologys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

/**
 * 任务抓取到的数据详情 - 实体定义
 * 开发人员: 张帅
 * 修订日期: 2018-09-18 16:47:03
 */
@Entity
@Table(name = "crawlData")
public class CrawlData {
    /**
     * ID
     */
    @Id
    private String id;

    /**
     * 自增字段
     */
    @Column
    private Long createdIndex;

    /**
     * 车款
     */
    @Column
    private String type;

    /**
     * 车款Code
     */
    @Column
    private String typeCode;

    /**
     * 抓取时间
     */
    @Column
    private Date dateTime;

    /**
     * 厂商价
     */
    @Column
    private String price;

    /**
     * 报价
     */
    @Column
    private String dealerOffer;

    /**
     * 优惠幅度
     */
    @Column
    private String discount;



    /**
     * 默认实例化方法
     */
    public CrawlData() {
        id = UUID.randomUUID().toString().toUpperCase();
        dateTime = new Date();
    }

    //region getter & setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCreatedIndex() {
        return createdIndex;
    }

    public void setCreatedIndex(Long createdIndex) {
        this.createdIndex = createdIndex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDealerOffer() {
        return dealerOffer;
    }

    public void setDealerOffer(String dealerOffer) {
        this.dealerOffer = dealerOffer;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}

