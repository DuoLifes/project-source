package com.cn.connext.project.technologys.webapi;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.technologys.crawl.URLFecter;
import com.cn.connext.project.technologys.entity.CrawlData;
import com.cn.connext.project.technologys.repository.CrawlDataRepository;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

@WebAPI("/api/technology/crawl")
public class CrawlAPI {

    private static final org.slf4j.Logger logger= LoggerFactory.getLogger(CrawlAPI.class);

    @Resource
    private CrawlDataRepository crawlDataRepository;

    /**
     * 创建新的手动数据抓取任务。
     * @return 返回所创建的对象实例
     */
    @GetMapping("/start")
    public List<CrawlData> StartCrawl() {
        try {
            // 初始化一个httpclient
            HttpClient client = HttpClients.createDefault();
            String url = "https://dealer.autohome.com.cn/2079692/b_370.html";
            // 抓取的数据
            List<CrawlData> dataList = URLFecter.URLParser(client, url);
            if(dataList.size()==0){
                logger.info("页面未获得有效数据");
            }
            for (CrawlData crawlData : dataList) {
                crawlDataRepository.save(crawlData);
            }
            return dataList;
        }catch (Exception e){
            logger.info("爬取数据失败:"+e);
        }
        return null;
    }
}
