package com.cn.connext.project.technologys.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/*各表都有的字段可以通过此注解定义在父类里，子类可以继承父类的属性*/
@MappedSuperclass
/*此注解为特定字段添加创建修改时间和执行人*/
/*同时在启动类添加注解@EnableJpaAuditing*/
@EntityListeners(AuditingEntityListener.class)
public class BaseData {
    @Id
    private String id;

    @Column
    @CreatedBy
    private String createBy;

    @Column
    /*添加当前时间*/
    @CreatedDate
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
