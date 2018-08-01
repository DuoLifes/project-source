package com.cn.connext.project.basic.service;

import com.cn.connext.project.basic.domain.PageAble;
import com.cn.connext.project.basic.domain.PageInfo;
import com.cn.connext.project.basic.entity.Partner;
import com.cn.connext.project.basic.repository.PartnerRepository;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class PartnerService {

    @Resource
    private PartnerRepository partnerRepository;

    public List<Partner> findByCode(String code){
        return partnerRepository.findByCode(code);
    }

    public List<Partner> findIdAndName(){
        return partnerRepository.findIdAndName();
    }

    public List<Partner> selectByCode(String code){
        return partnerRepository.selectByCode(code);
    }

    //分页查询方法1
    public List<Partner> findByPage(Map<String, Object> map){
        Map<String,Object> countMap=countMap(map);
        return partnerRepository.findByPage(countMap);
    }

    //分页查询方法2
    public List<Partner> findPage(PageAble pageAble) {
        return partnerRepository.findPage(pageAble);
    }

    //通用方法：计算begin值
    public Map countMap(Map<String, Object> map) {
        PageInfo<Partner>info=new PageInfo<Partner>();
        int count =partnerRepository.findCount();
        int pageIndex=(Integer)map.get("page");
        int size=(Integer)map.get("size");
        info.setCount(count);
        info.setSize(size);
        int total=info.getTotal();
        if(pageIndex>total) {
            pageIndex=total;
        }
        if(pageIndex<1) {
            pageIndex=1;
        }
        map.put("begin",(pageIndex-1)*info.getSize());
        map.put("size",info.getSize());
        return map;
    }
}
