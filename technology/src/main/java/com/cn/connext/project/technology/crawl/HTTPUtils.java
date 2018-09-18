package com.cn.connext.project.technology.crawl;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.springframework.stereotype.Component;
import java.io.IOException;

/**  
* <p>Title: 模拟浏览器工具类</p>
* <p>Description: </p>  
* @author 张帅
* @date 2018年9月17日
*/

@Component
public class HTTPUtils {
	public static HttpResponse getRawHtml(HttpClient client, String personalUrl) {
		HttpGet get = new HttpGet(personalUrl);
		// 设置头部信息进行浏览器模拟行为
		get.setHeader("Accept", "text/html,application/xhtml+xml," +
                "application/xml;q=0.9,image/webp,*/*;q=0.8");
		get.setHeader("Accept-Encoding", "gzip, deflate, sdch, br");
		get.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
		get.setHeader("Connection", "keep-alive");
		get.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 " +
                "Safari/537.36");
		HttpResponse response = null;
		try {
			response = client.execute(get);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return response;
	}
}
