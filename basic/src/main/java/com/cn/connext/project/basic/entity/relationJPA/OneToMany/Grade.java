package com.cn.connext.project.basic.entity.relationJPA.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "grade")
public class Grade {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)   //设置 id 为自增长
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "grade",cascade=CascadeType.ALL)//一对一外键关联需要在非主体类中标注出他在主题类中的名字（teacher是主体,因此grade在teacher里的实体是grade）
    @JsonIgnoreProperties(value = "grade")//查询时过滤某个字段，防止陷入死循环。
    private List<Teacher> list=new ArrayList<>();
}
