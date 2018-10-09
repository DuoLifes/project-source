package com.cn.connext.project.demo.webapi;

import com.cn.connext.project.demo.entity.Media;
import com.cn.connext.project.demo.service.MediaService;
import com.cn.connext.project.framework.annotation.WebAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * 媒体信息 - WebAPI访问接口
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */
@WebAPI("/api/demo/media")
public class MediaAPI {

    /**
     * 媒体信息 - 业务服务对象
     */
    @Resource
    private MediaService mediaService;

    private static final Logger logger = LoggerFactory.getLogger(MediaAPI.class);

    /**
     * 根据查询构造器，查询所有匹配的记录。
     * @return 返回数据集合信息
     */
    @GetMapping("/list")
    public List<Media> findList() {
        return mediaService.findList();
    }

    @PostMapping("/findOne")
    public Media findOne(@RequestParam String id){
        return mediaService.findOne(id);
    }

    /*遍历Map*/
    @GetMapping("/map")
    public void map(){
        Map<String, Media> map = new Hashtable<>();
        mediaService.findList().stream()
                .forEach(media ->map.put(media.getId(),media));

        /*遍历value*/
        for (Map.Entry<String, Media> maps : map.entrySet()) {
            System.out.println(maps.getValue().getName());
        }
        /*遍历key*/
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        /*根据key清除map的value*/
        map.remove("");
    }
}

