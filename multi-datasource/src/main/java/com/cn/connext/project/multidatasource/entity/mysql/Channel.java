package com.cn.connext.project.multidatasource.entity.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "channel")
public class Channel {

    @Id
    private String id;

    @Column
    private String parentId;

    @Column
    private Integer level;

    @Column
    private String name;

    @Column
    private String code;

    @Column
    private Boolean isTop;

    @Column
    private Boolean isNeedClear;

    @Column
    private Boolean isUseKey;

    @Column
    private String oldName;

    @Column
    private String channelKey;

    @Column
    private String activeName;

    @Column
    private String type;

    @Column
    private Boolean isClaim;

    @Column
    private Date updateTime;

    @Column
    private String remark;

    @Column
    private Boolean isInvalid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getTop() {
        return isTop;
    }

    public void setTop(Boolean top) {
        isTop = top;
    }

    public Boolean getNeedClear() {
        return isNeedClear;
    }

    public void setNeedClear(Boolean needClear) {
        isNeedClear = needClear;
    }

    public Boolean getUseKey() {
        return isUseKey;
    }

    public void setUseKey(Boolean useKey) {
        isUseKey = useKey;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getChannelKey() {
        return channelKey;
    }

    public void setChannelKey(String channelKey) {
        this.channelKey = channelKey;
    }

    public String getActiveName() {
        return activeName;
    }

    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getClaim() {
        return isClaim;
    }

    public void setClaim(Boolean claim) {
        isClaim = claim;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getInvalid() {
        return isInvalid;
    }

    public void setInvalid(Boolean invalid) {
        isInvalid = invalid;
    }

}
