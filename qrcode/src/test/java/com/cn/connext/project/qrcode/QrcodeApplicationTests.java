package com.cn.connext.project.qrcode;

import com.alibaba.fastjson.JSONObject;
import com.cn.connext.project.qrcode.demo.MatrixToImageWriter;
import com.cn.connext.project.qrcode.demo.QRCodeUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QrcodeApplicationTests {

	/*创建二维码基础方法,不带logo，属性自定义*/
	@Test
	public void test01(){
		try {
			String content = "https://www.baidu.com";
			String path = "D:/image/";
			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			Map hints = new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 400, 400,hints);
			File file = new File(path,"01.jpg");
			MatrixToImageWriter.writeToFile(bitMatrix, "jpg", file);
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*创建二维码带logo*/
	@Test
	public void test02() {
		try {
			String content = "https://www.baidu.com";
			QRCodeUtil.encode(content, "D:/file/test.jpg", "D:/image/", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*创建二维码不带logo*/
	@Test
	public void test03(){
		try {
			String content = "https://www.baidu.com";
			OutputStream output = new FileOutputStream("D:/image/test02.jpg");
			QRCodeUtil.encode1(content, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*解析二维码,解析结果是二维码的content,也就是链接*/
	@Test
	public void test04(){
		try {
			File file=new File("D:/image/test02.jpg");
			String qRcode=QRCodeUtil.decode(file);
			System.out.println("qRcode=="+qRcode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test05() {
		String APPID="wx0ede6a51a216c27a";
		String APPSECRET="62a0aeec6c1bc91f04fc53b936765ad5";
		String ACCESS_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
		String url = ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		HttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		JSONObject jsonObject = null;
		try {
			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String result = EntityUtils.toString(entity, "UTF-8");
				jsonObject = JSONObject.parseObject(result);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
