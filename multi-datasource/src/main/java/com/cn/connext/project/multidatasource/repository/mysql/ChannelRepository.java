package com.cn.connext.project.multidatasource.repository.mysql;

import com.cn.connext.project.framework.repository.ConnextRepository;
import com.cn.connext.project.multidatasource.entity.mysql.Channel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ChannelRepository extends ConnextRepository<Channel, String> {

    @Transactional
    @Modifying
    @Query(value = "TRUNCATE TABLE `channel`", nativeQuery = true)
    void clear();
}
