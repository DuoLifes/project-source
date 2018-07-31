package com.cn.connext.project.multidatasource.repository.sqlserver;

import com.cn.connext.project.multidatasource.entity.sqlserver.TMDealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TMDealerRepository extends JpaRepository<TMDealer, String>, JpaSpecificationExecutor<TMDealer> {


}
