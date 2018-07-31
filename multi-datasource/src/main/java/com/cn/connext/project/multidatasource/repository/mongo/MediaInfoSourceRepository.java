package com.cn.connext.project.multidatasource.repository.mongo;

import com.cn.connext.project.framework.mongodbrepository.ConnextMongoRepository;
import com.cn.connext.project.multidatasource.entity.mongo.MediaInfoSource;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaInfoSourceRepository extends ConnextMongoRepository<MediaInfoSource, String> {
}

