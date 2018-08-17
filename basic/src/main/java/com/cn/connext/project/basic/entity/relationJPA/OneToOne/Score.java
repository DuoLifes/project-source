package com.cn.connext.project.basic.entity.relationJPA.OneToOne;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/*
* 双向一对一关联，被维护方:通过mappedBy注解定义关系是双向的，而且mappedBy注释指定了这个实体是被关系维护端的那个属性所维护。
*/

/*
* 1.   @JsonIgnore
* 在不希望被序列化的field或property上使用@JsonIgnore标记，即可使该属性在序列化和解序列化的过程中不被访问。
* 2.    @JsonManagedReference and @JsonBackReference.
* 将@JsonManagedReference标记在父类对子类的引用变量上，并将@JsonBackReference标记在子类对父类的引用变量上。
* 通过这种方式确保在双向关系中只有单个反向的实例被序列化
* 3.    @JsonIdentityInfo
* 该annotation用于标注在entity上。当entity被标注后，jackson在每一次序列化的时候都会为该实例生成专门的ID（也可以是实例自带的属性），
* 通过这种方式辨别实例。这种方式适用于存在一个实体关联链的场景。比如Order -> OrderLine -> User -> Order
* 4.    @JsonIgnoreProperties 个人心中的全场最佳
* @JsonIgnoreProperties不同于@JsonIgnore在于，你可以注明该变量中的哪个属相不被序列化。从而允许在双向访问上都不存在环或是缺失。
* */

@Data
@Entity
@Table(name = "score")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property = "@id")  //该annotation用于标注在entity上。
// 当entity被标注后，jackson在每一次序列化的时候都会为该实例生成专门的ID（也可以是实例自带的属性），
// 通过这种方式辨别实例。这种方式适用于存在一个实体关联链的场景
public class Score implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//主键自增
    private Long id;

    @Column(name = "chinese_score")//语文分数
    private Integer chinese;

    @Column(name = "math_score")//数学分数
    private Integer math;

    @OneToOne(mappedBy = "score",cascade=CascadeType.ALL)//一对一外键关联需要在非主体类中标注出他在主题类中的名字（student是主体,因此score在student里的实体是score）
    @JsonIgnoreProperties(value = "score")//查询时过滤某个字段，防止陷入死循环。
    //@JsonBackReference  //通过这种方式确保在双向关系中只有单个反向的实例被序列化(只能从主表向从表方向序列化)
    //@JsonIgnore   //被标记的属性在序列化和解序列化的过程中不被访问
    private Student student;
}
