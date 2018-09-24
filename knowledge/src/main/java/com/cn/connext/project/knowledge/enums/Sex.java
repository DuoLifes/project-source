package com.cn.connext.project.knowledge.enums;

public enum  Sex {
    man("男"),
    woman("女");
    private String value;

    Sex(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
