package com.cn.connext.project.view.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

/**
 * 媒体合作伙伴 - 实体定义
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */

@Entity
@Table(name = "partner")
public class Partner {
    /**
     * 唯一标识
     */
    @Id
    private String id;

    /**
     * 媒体编号
     */
    @Column
    private String mediaId;

    /**
     * 媒体名称
     */
    @Column
    private String name;

    /**
     * 媒体代码
     */
    @Column
    private String code;

    /**
     * 访问标识
     */
    @Column
    private String token;

    /**
     * 备注信息
     */
    @Column
    private String remark;

    /**
     * 是否失效
     */
    @Column
    private Boolean invalid;

    /**
     * 更新时间
     */
    @Column
    private Date updateTime;

    /**
     * 创建次序
     */
    @Column
    private Integer createIndex;

    /**
     * 默认实例化方法
     */
    public Partner() {
        id = UUID.randomUUID().toString().toUpperCase();
        invalid = false;
        updateTime = new Date();
    }

    //region getter & setter

    /**
     * 获取唯一标识。
     */
    public String getId() {
        return id == null ? null : id.toUpperCase();
    }

    /**
     * 设置唯一标识。
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取媒体编号。
     */
    public String getMediaId() {
        return mediaId == null ? null : mediaId.toUpperCase();
    }

    /**
     * 设置媒体编号。
     */
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    /**
     * 获取媒体名称。
     */
    public String getName() {
        return name;
    }

    /**
     * 设置媒体名称。
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取媒体代码。
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置媒体代码。
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取访问标识。
     */
    public String getToken() {
        return token == null ? null : token.toUpperCase();
    }

    /**
     * 设置访问标识。
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获取备注信息。
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注信息。
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取是否失效。
     */
    public Boolean getInvalid() {
        return invalid;
    }

    /**
     * 设置是否失效。
     */
    public void setInvalid(Boolean invalid) {
        this.invalid = invalid;
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
     * 获取创建次序。
     */
    public Integer getCreateIndex() {
        return createIndex;
    }

    /**
     * 设置创建次序。
     */
    public void setCreateIndex(Integer createIndex) {
        this.createIndex = createIndex;
    }

    //endregion
}

