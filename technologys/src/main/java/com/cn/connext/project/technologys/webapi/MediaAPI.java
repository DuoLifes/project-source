package com.cn.connext.project.technologys.webapi;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.technologys.entity.Media;
import com.cn.connext.project.technologys.entity.Orders;
import com.cn.connext.project.technologys.repository.MediaRepository;
import com.cn.connext.project.technologys.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebAPI("/api/technology/media")
public class MediaAPI {

    @Resource
    private MediaRepository mediaRepository;

    @GetMapping("/create")
    public Media create() {
        Media media = new Media();
        media.setMediaTypeId("433E44B0-C6B3-4E15-8F1E-C626BA248A8C");
        media.setCode("SA09776");
        media.setName("测试媒体");
        media.setRemark("测试媒体备注");
        return mediaRepository.save(media);
    }

    @GetMapping("/findAll")
    public List<Media> findAll() {
        return mediaRepository.findAll();
    }

    /*排序&分页*/
    @GetMapping("/sort")
    public Page<Media> sortList() {
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        orders.add(new Sort.Order(Sort.Direction.ASC, "createIndex"));
        Pageable pageable = new PageRequest(0, 20, new Sort(orders));
        return mediaRepository.findAll(pageable);
    }

    /*添加多个字段排序*/
    @GetMapping("/sort1")
    public List<Media> sortList1() {
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "createIndex"));
        orders.add(new Sort.Order(Sort.Direction.DESC, "updateTime"));
        return mediaRepository.findAll(new Sort(orders));
    }

    /*排序*/
    @GetMapping("/sort2")
    public List<Media> sortList2() {
        Sort sort = new Sort(Sort.Direction.DESC, "createIndex");
        return mediaRepository.findAll(sort);
    }

    /*重写排序:备注: > 是从小到大正序  < 是从大到小倒序*/
    @GetMapping("/sort3")
    public List<Media> sortList3() {
        List<Media> list = mediaRepository.findAll();
        if (list != null && list.size() > 0) {
            Collections.sort(list, new Comparator<Media>() {
                @Override
                public int compare(Media o1, Media o2) {
                    return (o1.getCreateIndex() < o2.getCreateIndex()) ? 1 : -1;
                }
            });
        }
        return list;
    }
}