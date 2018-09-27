package com.cn.connext.project.knowledge.entity;

import com.cn.connext.project.framework.GlobalIdBuilder;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 媒体信息 - 实体定义
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */
@Entity
@Table(name = "media")
public class Media implements Serializable {
    /**
     * 唯一编号
     */
    @Id
    private String id;
    /**
     * 媒体类型编号
     */
    @Column
    private String mediaTypeId;
    /**
     * 名称
     */
    @Column
    private String name;
    /**
     * 代码
     */
    @Column
    private String code;
    /**
     * 更新时间
     */
    @Column
    private Date updateTime;
    /**
     * 备注
     */
    @Column
    private String remark;
    /**
     * 是否可用
     */
    @Column
    private Boolean isInvalid;
    /**
     * 创建下标
     */
    @Column
    private Integer createIndex;

    /**
     * 默认实例化方法
     */
    public Media() {
        id = GlobalIdBuilder.newUUID();
        updateTime = new Date();
        isInvalid = false;
    }

    private static String toUpperCase(String args) {
        return args == null ? null : args.toUpperCase();
    }

    public Media toUpperCase(Media media) {
        media.id = toUpperCase(media.id);
        media.mediaTypeId = toUpperCase(media.mediaTypeId);
        return media;
    }

    //region getter & setter

    /**
     * 获取唯一编号。
     */
    public String getId() {
        return id == null ? null : id.toUpperCase();
    }

    /**
     * 设置唯一编号。
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取媒体类型编号。
     */
    public String getMediaTypeId() {
        return mediaTypeId == null ? null : mediaTypeId.toUpperCase();
    }

    /**
     * 设置媒体类型编号。
     */
    public void setMediaTypeId(String mediaTypeId) {
        this.mediaTypeId = mediaTypeId;
    }

    /**
     * 获取名称。
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称。
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取代码。
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置代码。
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取更新时间。
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间。
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取备注。
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注。
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取是否可用。
     */
    public Boolean getIsInvalid() {
        return isInvalid;
    }

    /**
     * 设置是否可用。
     */
    public void setIsInvalid(Boolean isInvalid) {
        this.isInvalid = isInvalid;
    }

    /**
     * 获取创建下标。
     */
    public Integer getCreateIndex() {
        return createIndex;
    }

    /**
     * 设置创建下标。
     */
    public void setCreateIndex(Integer createIndex) {
        this.createIndex = createIndex;
    }

    //endregion

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id +"\""+
                "\"updateTime\":\"" + updateTime + "\""+
                "\"isInvalid\":\"" + isInvalid + "\"" +
                "\"createIndex\":\"" + createIndex + "\"" +
                '}';
    }
}

