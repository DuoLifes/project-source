//package com.cn.connext.project.basic.entity.relationJPA.OneToMany;
//
//import com.cn.connext.project.basic.entity.relationJPA.OneToOne.Score;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.Data;
//
//import javax.persistence.*;
//
//@Data
//@Entity
//@Table(name = "grade")
//public class Student {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)   //设置 id 为自增长
//    private Long id;
//
//    @Column(name = "name")
//    private String name;
//
//    @OneToOne(cascade = CascadeType.ALL )//设置映射级联,当student删除的时候，score对应也会删除(必须在主体类设置)
//    @JoinColumn(name="score_id")//关联的表为score表，其主键是id
//    @JsonIgnoreProperties(value = "student") //可以在查询的时候过滤不必查询的字段
//    private Score score;
//
//    //@ManyToOne()
//}
