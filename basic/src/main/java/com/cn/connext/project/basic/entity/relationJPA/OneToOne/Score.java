package com.cn.connext.project.basic.entity.relationJPA.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "score")
@JsonIgnoreProperties(value = { "student" })//查询时过滤某个字段，防止陷入死循环。
public class Score implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "chinese_score")//语文分数
    private Integer chinese;
    @Column(name = "math_score")//数学分数
    private Integer math;

    @OneToOne(mappedBy = "score")//一对一外键关联需要在非主体类中标注出他在主题类中的名字（student是主题,因此score在student里的实体是score）
    private Student student;
}
