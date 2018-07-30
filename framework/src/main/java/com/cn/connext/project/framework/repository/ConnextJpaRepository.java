package com.cn.connext.project.framework.repository;


import com.cn.connext.project.framework.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("SpringJavaAutowiringInspection")
public class ConnextJpaRepository<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements ConnextRepository<T, ID> {

    private final JpaEntityInformation entityInformation;
    private final EntityManager entityManager;

    public ConnextJpaRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        this.entityManager = entityManager;
    }

    @Transactional
    public <S extends T> S create(S entity) {
        this.entityManager.persist(entity);
        return entity;
    }


    @Transactional
    public <S extends T> void batchCreate(List<S> entityList, int batchSize) {
        for (int i = 0; i < entityList.size(); i++) {
            entityManager.persist(entityList.get(i));
            if ((i + 1) % batchSize == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
    }

    @Transactional
    public <S extends T> S modify(S entity) {
        this.entityManager.merge(entity);
        return entity;
    }

    @Override
    public Page<T> findPage(QueryBuilder<T> queryBuilder) {
        return this.findAll(queryBuilder.getSpecification(), queryBuilder.getPageable());
    }

    @Override
    public List<T> findList(QueryBuilder<T> queryBuilder) {
        return this.findAll(queryBuilder.getSpecification(), queryBuilder.getPageable().getSort());
    }

}