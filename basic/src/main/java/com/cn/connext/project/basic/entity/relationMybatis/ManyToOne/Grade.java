package com.cn.connext.project.basic.entity.relationMybatis.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class Grade {

    private Long id;

    private String name;

}
