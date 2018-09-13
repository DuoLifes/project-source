package com.cn.connext.project.qrcode;

import com.cn.connext.project.qrcode.demo.MatrixToImageWriter;
import com.cn.connext.project.qrcode.demo.QRCodeUtil;
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
}
