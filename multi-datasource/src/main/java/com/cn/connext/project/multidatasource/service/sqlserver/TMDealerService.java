package com.cn.connext.project.multidatasource.service.sqlserver;
import com.cn.connext.project.multidatasource.entity.sqlserver.TMDealer;
import com.cn.connext.project.multidatasource.repository.sqlserver.TMDealerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TMDealerService {

    @Resource
    private TMDealerRepository tmDealerRepository;

    public List<TMDealer> finAll(){
        return tmDealerRepository.findAll();
    }
}
