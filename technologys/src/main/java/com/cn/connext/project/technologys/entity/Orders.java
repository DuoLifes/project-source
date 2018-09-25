package com.cn.connext.project.technologys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/*验证@MappedSuperclass注解作用*/
@Entity
@Table(name="orders")
public class Orders extends BaseData {
    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
