package com.cn.connext.project.qrcode.qrcodeUtil;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class WeixinUtil {

	private final static Logger logger = LoggerFactory.getLogger(WeixinUtil.class);

	//获取access_token
	private static final String ACCESS_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	//获取ticket
	private static final String CREATE_QRCODE_URL="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
	//根据ticket换取qrcode
	private static final String GET_QRCODE_URL="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
	//小程序二维码
	public String GET_QRCODES_URL="https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=ACCESS_TOKEN";

	/**
	 *
	 * <p>Get请求</p>
	 *
	 * @param url
	 * @return
	 * @author: 张帅
	 * @date: Created on 2018-9-14
	 */
	public static JSONObject doGetStr(String url){
		HttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet =new HttpGet(url);
		JSONObject jsonObject =null;
		try {
			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if(entity!=null){
				String result = EntityUtils.toString(entity,"UTF-8");
				jsonObject = JSONObject.parseObject(result);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
	/**
	 * <p>post请求</p>
	 *
	 * @param url
	 * @param outStr
	 * @return
	 * @author: 张帅
	 * @date: Created on 2018-9-14
	 */
	public static JSONObject doPostStr(String url,String outStr){
		HttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost =new HttpPost(url);
		JSONObject jsonObject =null;
		try {
			httpPost.setEntity(new StringEntity(outStr,"UTF-8"));
			HttpResponse response = httpClient.execute(httpPost);
			String result = EntityUtils.toString(response.getEntity(),"UTF-8");
			jsonObject = JSONObject.parseObject(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}


	/**
	 *
	 * <p>获取AccessToken</p>
	 *
	 * @return
	 * @author: 张帅
	 * @date: Created on 2018-9-14
	 */
	public JSONObject getAccessToken(String appId,String appSecret){
		String url = ACCESS_TOKEN_URL.replace("APPID", appId).replace("APPSECRET", appSecret);
		JSONObject jsonObject = doGetStr(url);
		logger.info("tokenObject："+jsonObject);
		return jsonObject;
	}

	/**
	 *
	 * <p>获取二维码的ticket</p>
	 *
	 * @return
	 * @author: 张帅
	 * @date: Created on 2018-9-14
	 */
	public String getQrcodeTicket(String token){
		String result = "";
		String url = CREATE_QRCODE_URL.replace("ACCESS_TOKEN",token);
		JSONObject jsonObject = doPostStr(url,"{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"test\"}}}");
		logger.info("ticketObject"+jsonObject);
		if(jsonObject!=null){
			result = jsonObject.getString("ticket");
			logger.info("ticket:"+result);
		}
		String qrcodeUrl = GET_QRCODE_URL.replace("TICKET",result);
		return qrcodeUrl;
	}

	/**
	 * 获取小程序二维码
	 * @param token
	 * @return
	 */
	public String getQrcodeUrl(String token){
		String  result = "";
		String url = GET_QRCODES_URL.replace("ACCESS_TOKEN",token);
		JSONObject jsonObject = doPostStr(url,"{\"scene\": \"123\", \"page\": \"page/newCar/carInfo/carFrom\"}");
		if(jsonObject!=null){
			result = jsonObject.getString("ticket");
			logger.info(jsonObject.toString());
		}
		String qrcodeUrl = GET_QRCODES_URL.replace("TICKET",result);
		return qrcodeUrl;
	}
}
