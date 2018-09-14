package com.cn.connext.project.qrcode;

import com.alibaba.fastjson.JSONObject;
import com.cn.connext.project.qrcode.demo.MatrixToImageWriter;
import com.cn.connext.project.qrcode.demo.QRCodeUtil;
import com.cn.connext.project.qrcode.qrcodeUtil.WeixinUtil;
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

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import javax.annotation.Resource;

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



	/*生成微信测试二维码
	* 根据appid和secret先获取access_token
	* 以上两个参数用测试微信公众号获取:
	* 地址:https://mp.weixin.qq.com/debug/cgi-bin/sandboxinfo?action=showinfo&t=sandbox/index
	* */
	@Resource
	private WeixinUtil weixinUtil;
	@Test
	public void test06() {
		//用access_token获取ticket
		String qrCodeTicket = weixinUtil.getQrcodeTicket("13_0_BCTACkly6KnAQQGpktV2ME31Banrqo2YJJ5B66sPYZeuxR13TipEwFM-A6ZY36AybCrEgWHPml8wSSccUFkDF5Gre0ax8XxUGVscpLByLhjGsF9ASSJOeBiq9FmG0fxV3oxV9Wbu6WIk6mMINeAJAYUZ");
		try {
			URL url = new URL(qrCodeTicket);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			File file = new File("D:/wechatqrcode/wechat.jpg");
			BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
			OutputStream os = new FileOutputStream(file);
			int len;
			byte[] arr = new byte[1024];
			while ((len = bis.read(arr)) != -1) {
				os.write(arr, 0, len);
				os.flush();
			}
		}catch (Exception e){
			System.out.println(e.toString());
		}
	}
}
