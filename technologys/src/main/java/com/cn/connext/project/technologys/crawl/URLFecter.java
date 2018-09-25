package com.cn.connext.project.technologys.crawl;

import com.cn.connext.project.technologys.entity.CrawlData;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**  
* <p>Title: HttpClient访问URL</p>
* <p>Description: </p>  
* @author 张帅
* @date 2018年9月17日
*/

@Component
public class URLFecter {

	public static List<CrawlData> URLParser (HttpClient client, String url) throws Exception {
        //用来接收解析的数据
        List<CrawlData> dataList = new ArrayList<CrawlData>();
        //获取网站响应的html，这里调用了HTTPUtils类
        HttpResponse response = HTTPUtils.getRawHtml(client, url);      
        //获取响应状态码
        int StatusCode = response.getStatusLine().getStatusCode();
        //如果状态响应码为200，则获取html实体内容或者json文件
        if(StatusCode == 200){
            String entity = EntityUtils.toString (response.getEntity(),"utf-8");
            //包装页面实体
            if (url.contains("autohome")){
                String urlId = url.substring(url.indexOf("b_")+2,url.indexOf(".html"));
                dataList = DataAnalysis.getautohomeData(entity,urlId);
            }else if (url.contains("bitauto")){
                dataList = DataAnalysis.getbitautoData(entity);
            }
            EntityUtils.consume(response.getEntity());
        }else {
            //否则，消耗掉实体
            EntityUtils.consume(response.getEntity());
        }
        return dataList;
    }

}
