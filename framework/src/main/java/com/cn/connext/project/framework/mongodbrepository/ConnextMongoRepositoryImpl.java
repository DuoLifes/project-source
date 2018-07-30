package com.cn.connext.project.framework.mongodbrepository;

import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings({"unchecked", "Duplicates"})
public class ConnextMongoRepositoryImpl<T, ID extends Serializable>
        extends SimpleMongoRepository<T, ID> implements ConnextMongoRepository<T, ID> {
    protected final MongoOperations mongoTemplate;

    protected final MongoEntityInformation<T, ID> entityInformation;

    /**
     * Creates a new {@link SimpleMongoRepository} for the given {@link MongoEntityInformation} and {@link MongoTemplate}.
     *
     * @param metadata        must not be {@literal null}.
     * @param mongoOperations must not be {@literal null}.
     */
    public ConnextMongoRepositoryImpl(MongoEntityInformation<T, ID> metadata, MongoOperations mongoOperations) {
        super(metadata, mongoOperations);

        this.mongoTemplate = mongoOperations;
        this.entityInformation = metadata;
    }

    protected Class<T> getEntityClass() {
        return entityInformation.getJavaType();
    }

    @Override
    public WriteResult updateFirst(Query query, Update update) {
        return mongoTemplate.updateFirst(query, update, getEntityClass());
    }

    @Override
    public WriteResult update(Query query, Update update) {
        return mongoTemplate.updateMulti(query, update, getEntityClass());
    }

    @Override
    public T findOne(Query query) {
        return mongoTemplate.findOne(query, getEntityClass());
    }

    public void batchCreate(List<T> list) {
        mongoTemplate.insertAll(list);
    }

    public List<T> findAll(Query query)
    {
        return mongoTemplate.find(query,getEntityClass());
    }
}
