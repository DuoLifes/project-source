package com.cn.connext.project.basic.entity.relationMybatis.ManyToOne;

import lombok.Data;

@Data
public class Teacher {

    private Long id;

    private String name;

    private Grade grade;

}
