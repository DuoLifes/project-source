package com.cn.connext.project.framework.repository;

import com.cn.connext.project.framework.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface ConnextRepository<T, ID extends Serializable>
        extends JpaRepository<T, ID> {

    <S extends T> S create(S entity);

    <S extends T> void batchCreate(List<S> entityList, int batchSize);

    <S extends T> S modify(S entity);

    Page<T> findPage(QueryBuilder<T> queryBuilder);

    List<T> findList(QueryBuilder<T> queryBuilder);
}
