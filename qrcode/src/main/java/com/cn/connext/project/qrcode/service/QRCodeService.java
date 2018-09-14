package com.cn.connext.project.qrcode.service;

import com.cn.connext.project.qrcode.cache.FileCache;
import com.cn.connext.project.qrcode.cache.TokenCache;
import com.cn.connext.project.qrcode.entity.QRCodeParams;
import com.cn.connext.project.qrcode.qrcodeUtil.QRCodeUtil;
import com.cn.connext.project.qrcode.qrcodeUtil.QRParamsException;
import com.cn.connext.project.qrcode.qrcodeUtil.WeixinUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class QRCodeService {

    /*系统日志*/
    private final static Logger logger = LoggerFactory.getLogger(QRCodeService.class);
    /*时间格式化*/
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String nowDate = formatter.format(new Date());

    //二维码存放路径
    private final static String filePath = "D:/QRcode/";
    //logo路径
    private final static String logoPath="http://localhost:8508/test.jpg";

    @Resource
    private QRCodeUtil qrCodeUtil;
    @Resource
    private TokenCache tokenCache;
    @Resource
    private WeixinUtil weixinUtil;
    @Resource
    private FileCache fileCache;


    //生成普通二维码
    @Transactional
    public Map<String, Object> createQrCode(QRCodeParams qrCodeParams) {
        //返回报文
        Map<String,Object> resMap = new HashMap<>();
        String resUrls = "";
        //获取链接内容
        String[] split = qrCodeParams.getContent();
        //设置前/背景色
        qrCodeParams.setOnColor(qrCodeParams.getOnColor().replace("#",""));
        qrCodeParams.setOffColor(qrCodeParams.getOffColor().replace("#",""));
        if(qrCodeParams.getOnColor().equals("")){
            qrCodeParams.setOnColor("000000");
        }
        if(qrCodeParams.getOffColor().equals("")){
            qrCodeParams.setOffColor("FFFFFF");
        }
        //设置二维码图片名
        for(int i = 0;i < split.length;i++){
            String fileName = "";
            if(qrCodeParams.getImgType().equals("0")){
                if(isChinese(split[i])){
                    fileName = nowDate+".jpg";
                } else {
                    fileName = qrCodeParams.getApplyScope()+nowDate+".jpg";
                }
            } else {
                if(isChinese(split[i])){
                    fileName = nowDate+".png";
                } else {
                    fileName = qrCodeParams.getApplyScope()+nowDate+".png";
                }
            }
            //是否插入logo
            if(qrCodeParams.getInsertLogo()){
                qrCodeParams.setLogoPath(logoPath);
            }
            qrCodeParams.setTxt(split[i]);//二维码内容
            qrCodeParams.setFileName(fileName);//二维码图片名称
            qrCodeParams.setFilePath(filePath);//二维码图片存放路径
            try {
                String qRcodeFileName = qrCodeUtil.generateQRImage(qrCodeParams);
                if((i+1)==split.length){
                    resUrls += qRcodeFileName;
                } else {
                    resUrls += qRcodeFileName;
                }
            } catch (QRParamsException e){
                e.printStackTrace();
                resMap.put("code","10002");
                resMap.put("msg","二维码生成失败,请检查参数是否正确");
                resMap.put("imgUrl","");
                return resMap;
            }
        }
        resMap.put("code","10001");
        resMap.put("msg","二维码生成成功");
        resMap.put("imgUrl",resUrls);
        return resMap;
    }
    //####################################################################################################//
    /*内部调用*/
    //字符串中不能包含中文和斜杠（/）和逗号（，）
    public static final boolean isChinese(String strName) {
        char[] ch = strName.toCharArray();
        if(strName.indexOf("/")<0 && strName.indexOf(",")<0){
            for (int i = 0; i < ch.length; i++) {
                char c = ch[i];
                if (isChinese(c)) {
                    return true;
                }
            }
        } else {
            return true;
        }
        return false;
    }
    // 判断字符串中是否包含汉字
    // GENERAL_PUNCTUATION 判断中文的“号
    // CJK_SYMBOLS_AND_PUNCTUATION 判断中文的。号
    // HALFWIDTH_AND_FULLWIDTH_FORMS 判断中文的，号
    private static final boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }
    //####################################################################################################//

    //生成二维码（微信二维码）
    public Map<String,Object> createWeChatQrCode(String appId,String appSecret,String imgType){
        Long nowTime = new Date().getTime();
        //根据appId;appSecret获取acsess_token
        Map<String,Object> tokenMap = tokenCache.getToken(appId,appSecret);
        String time = String.valueOf(tokenMap.get("time"));
        long interval = (nowTime - Long.valueOf(time))/1000;
        logger.info("两个时间相差"+interval+"秒");
        if(interval>7000){
            logger.info("token过时，重新获取");
            tokenCache.clear(appId);
            tokenMap = tokenCache.getToken(appId,appSecret);
        }
        Map<String,Object> resMap = new HashMap<>();
        if(!tokenMap.get("code").equals("10001")){
            resMap.put("code",tokenMap.get("code"));
            resMap.put("msg","appId或appSecret不正确");
            resMap.put("imgUrl","");
            tokenCache.clear(appId);
            return resMap;
        }
        //根据acsess_token获取ticket
        String qrCodeTicket = weixinUtil.getQrcodeTicket(String.valueOf(tokenMap.get("token")));
        logger.info("qrCodeUrl:"+qrCodeTicket);
        String fileName = "";
        if(imgType.equals("0")){
            fileName = "wechat-"+nowDate+".jpg";
        } else {
            fileName = "wechat-"+nowDate+".png";
        }
        try {
            //根据ticket换取二维码
            URL url = new URL(qrCodeTicket);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            File file = new File(filePath+fileName);
            BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
            OutputStream os = new FileOutputStream(file);
            int len;
            byte[] arr = new byte[1024];
            while ((len = bis.read(arr)) != -1) {
                os.write(arr, 0, len);
                os.flush();
            }
            // File转换成MutipartFile(上传二维码)
            FileInputStream inputStream = new FileInputStream(filePath+"/"+fileName);
            MultipartFile multipartFile = new MockMultipartFile("file",fileName,"jpg",inputStream);
            String qRcodeFileName = fileCache.uploadImage(multipartFile);
            //file.delete();
            os.close();
            resMap.put("code","10001");
            resMap.put("msg","二维码生成成功");
            resMap.put("imgUrl",qRcodeFileName);
            return resMap;
        } catch (Exception e) {
            e.printStackTrace();
            resMap.put("code","10002");
            resMap.put("msg","二维码生成失败");
            resMap.put("imgUrl","");
            return resMap;
        }
    }

}
