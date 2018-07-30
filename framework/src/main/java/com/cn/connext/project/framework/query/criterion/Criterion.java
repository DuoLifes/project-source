package com.cn.connext.project.framework.query.criterion;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Create with com.spring.boot.criterion
 *
 * @author zhangpeiyu
 * @version 2018/3/7 23:49
 */
public interface Criterion {
    enum Operator {
        EQ, NE, LIKE, GT, LT, GTE, LTE, AND, OR, IS_MEMBER, IS_NOT_MEMBER
    }

    Predicate toPredicate(Root<?> root, CriteriaQuery<?> query,
                          CriteriaBuilder builder);
}
