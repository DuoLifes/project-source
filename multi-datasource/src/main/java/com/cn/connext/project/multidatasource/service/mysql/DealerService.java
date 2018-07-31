package com.cn.connext.project.multidatasource.service.mysql;

import com.cn.connext.project.multidatasource.entity.mysql.Dealer;
import com.cn.connext.project.multidatasource.repository.mysql.DealerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DealerService {

    @Resource
    private DealerRepository dealerRepository;

    public List<Dealer> findAll(){
        return dealerRepository.findAll();
    }

}
