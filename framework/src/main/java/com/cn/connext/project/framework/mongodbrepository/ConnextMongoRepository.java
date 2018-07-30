package com.cn.connext.project.framework.mongodbrepository;

import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface ConnextMongoRepository<T, ID extends Serializable>
        extends MongoRepository<T, ID> {

    WriteResult updateFirst(Query query, Update update);

    WriteResult update(Query query, Update update);

    <S extends T> S findOne(Query query);

    void batchCreate(List<T> list);
}
