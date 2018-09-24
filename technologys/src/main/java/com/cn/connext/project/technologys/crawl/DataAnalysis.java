package com.cn.connext.project.technologys.crawl;

import com.cn.connext.project.technologys.entity.CrawlData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 解析HTML 里的元素
 */
@Component
public class DataAnalysis {

    /**
     * 解析易车网 爬虫爬到的数据
     * @param html
     * @return
     * @throws Exception
     */
    public static List<CrawlData> getbitautoData(String html) throws Exception {
        // 获取的数据，存放在集合中
        List<CrawlData> data = new ArrayList<CrawlData>();
        // 采用Jsoup解析
        Document doc = Jsoup.parse(html);
        // 获取html标签中的内容
        Elements elements = doc.select(".car_price").select("tbody");
        for (Element ele : elements) {
            Elements nice=ele.select("tbody tr");
            for(Element n:nice) {
                String href = n.select("tr a").attr("href");
                String vehicleModel = n.select("tr a").eq(0).text();
                String price = n.select(".t_r").eq(0).text();
                price = price.replace(" ","");
                String dealerOffer = n.select(".t_r").eq(2).text();
                dealerOffer = dealerOffer.replace(" ","");
                if(!"".equals(vehicleModel)){
                    String code = href.substring(href.indexOf("_")+8,href.indexOf("."));
                    CrawlData crawlData = new CrawlData();
                    crawlData.setType(vehicleModel);
                    crawlData.setTypeCode(code);
                    crawlData.setPrice(price.substring(0,price.indexOf("万")));
                    BigDecimal bd1 = new BigDecimal(price.substring(0,price.indexOf("万")));
                    BigDecimal bd2 = new BigDecimal(dealerOffer.substring(0,dealerOffer.indexOf("万")));
                    crawlData.setDiscount(String.valueOf(bd1.subtract(bd2)));
                    crawlData.setDealerOffer(dealerOffer.substring(0,dealerOffer.indexOf("万")));
                    data.add(crawlData);

                }
            }
        }
        return data;
    }

    /**
     * 解析汽车之家 爬虫爬到的数据
     * @param html
     * @return
     * @throws Exception
     */
    public static List<CrawlData> getautohomeData(String html,String urlId) throws Exception {
        // 获取的数据，存放在集合中
        List<CrawlData> data = new ArrayList<CrawlData>();
        // 采用Jsoup解析
        Document doc = Jsoup.parse(html);
        // 获取html标签中的内容
        Elements elements = doc.select("#tab_"+urlId).select("tbody");
        for (Element ele : elements) {
            Elements nice=ele.select("tbody tr");
            for(Element n:nice) {
                String href = n.select("tr .txt-left a").attr("href");
            	String vehicleModel = n.select("tr .txt-left a").text();
            	String price = n.children().eq(1).text();
                price = price.replace(" ","");
            	String dealer_offer = n.select(".this-number").text();
                String dealer_offer1 = n.children().eq(2).text();
                dealer_offer = dealer_offer.replace(" ","");
                dealer_offer1 = dealer_offer1.replace(" ","");
                if(dealer_offer1.indexOf("万") != 2&&"".equals(dealer_offer)){
                    dealer_offer = dealer_offer1;
                }
                if("".equals(price)){
            		price = n.select(".text").text();
            		dealer_offer = n.select(".text").text();
            	}
                if(!"".equals(vehicleModel)){
                    String code = href.substring(href.indexOf("_")+1,href.indexOf("."));
                    CrawlData crawlData = new CrawlData();
                    crawlData.setType(vehicleModel);
                    crawlData.setTypeCode(code);
                    crawlData.setPrice(price.substring(0,price.indexOf("万")));
                    BigDecimal bd1 = new BigDecimal(price.substring(0,price.indexOf("万")));
                    BigDecimal bd2 = new BigDecimal(dealer_offer.substring(0,dealer_offer.indexOf("万")));
                    crawlData.setDiscount(String.valueOf(bd1.subtract(bd2)));
                    crawlData.setDealerOffer(dealer_offer.substring(0,dealer_offer.indexOf("万")));
                    data.add(crawlData);
                }
            }
        }
        return data;
    }
}
