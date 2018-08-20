package com.cn.connext.project.ibatisbasic.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Grade {

    private Long id;

    private String name;

    private List<Teacher> list=new ArrayList<>();

}
