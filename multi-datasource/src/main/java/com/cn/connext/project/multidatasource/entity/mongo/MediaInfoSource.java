package com.cn.connext.project.multidatasource.entity.mongo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document
public class MediaInfoSource {

    @Id
    private String id;
    private String name;
    private String type;
    private String remark;
    private Date createTime;

    public MediaInfoSource() {
        id = UUID.randomUUID().toString().toUpperCase();
        createTime = new Date();
    }

    public MediaInfoSource toString(MediaInfoSource mediaInfoSource, Integer i){
        mediaInfoSource.name="名称"+i;
        mediaInfoSource.type="媒体"+i;
        mediaInfoSource.remark="备注"+i;
        return mediaInfoSource;
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
