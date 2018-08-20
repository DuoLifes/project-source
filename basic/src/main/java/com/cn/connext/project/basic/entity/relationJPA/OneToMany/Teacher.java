package com.cn.connext.project.basic.entity.relationJPA.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)   //设置 id 为自增长
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="grade_id")//关联的表为grade表，其主键是id
    @JsonIgnoreProperties(value = "list") //可以在查询的时候过滤不必查询的字段
    private Grade grade;

}
