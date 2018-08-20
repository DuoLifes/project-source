package com.cn.connext.project.basic.entity.relationJPA.OneToOne;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
/*
* 双向一对一关联，主控方（维护方）:通过score_id外键来维护；外键命名默认为从表_id（被维护方_id）
*/

/*  四种防止查询序列化的时候陷入死循环的方式
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
@Table(name = "student")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property = "@id")
/*
*  该annotation用于标注在entity上。
 当entity被标注后，jackson在每一次序列化的时候都会为该实例生成专门的ID（也可以是实例自带的属性），
 通过这种方式辨别实例。这种方式适用于存在一个实体关联链的场景
 */

public class Student implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)   //设置 id 为自增长,做关联的情况尽量不要用，因为会在级联删除增加修改的时候带来麻烦
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL,optional=false )//设置映射级联,当student删除的时候，score对应也会删除(必须在主体类设置)
    @JoinColumn(name="scoreId")//关联的表为score表，其主键是id
    @JsonIgnoreProperties(value = "student") //可以在查询的时候过滤不必查询的字段
    //@JsonManagedReference     //通过这种方式确保在双向关系中只有单个反向的实例被序列化(只能从主表向从表方向序列化)
    private Score score;
}
