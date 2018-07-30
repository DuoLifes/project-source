package com.cn.connext.project.portal.entity;

/**
 * 媒体信息 - 实体定义
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */

public class Media {
    /**
     * 唯一编号
     */

    private String id;
    /**
     * 媒体名称
     */

    private String name;

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
}

