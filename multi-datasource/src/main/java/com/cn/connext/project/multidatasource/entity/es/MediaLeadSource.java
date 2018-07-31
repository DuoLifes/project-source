package com.cn.connext.project.multidatasource.entity.es;


import java.util.Date;
import java.util.UUID;

public class MediaLeadSource {

    private String id;
    private String name;
    private String type;
    private String remark;
    private Date createTime;

    public MediaLeadSource() {
        id = UUID.randomUUID().toString().toUpperCase();
        createTime = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
