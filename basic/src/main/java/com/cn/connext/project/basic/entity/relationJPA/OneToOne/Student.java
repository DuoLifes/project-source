package com.cn.connext.project.basic.entity.relationJPA.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "student")
//@JsonIgnoreProperties(value = { "score" })
public class Student implements Serializable {
    @Id
    @GeneratedValue
    private String id;
    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL )//设置映射级联,当student删除的时候，score对应也会删除(必须在主体类设置)
    @JoinColumn(name="score_id")//关联的表为score表，其主键是id
    private Score score;
}
