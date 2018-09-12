package com.cn.connext.project.qrcode.service;

import com.cn.connext.project.qrcode.entity.QRCodeParams;
import com.cn.connext.project.qrcode.qrcodeUtil.QRCodeUtil;
import com.cn.connext.project.qrcode.qrcodeUtil.QRParamsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class QRCodeService {

    /**
     * 系统日志
     */
    private final static Logger logger = LoggerFactory.getLogger(QRCodeService.class);

    //上传文件及生成二维码的路径前缀
    private final static String filePath = "D:\\file";
//    //上传文件及生成二维码的显示地址
//    private final static String fileShowPath = "/static/images/";

    @Resource
    private QRCodeUtil qrCodeUtil;


    /**
     * 生成二维码（普通二维码）。
     *
     * @param qrCodeParams
     */
    @Transactional
    public Map<String, Object> createQrCode(QRCodeParams qrCodeParams) {
        Map<String,Object> resMap = new HashMap<>();
        String resUrls = "";
        String[] split = qrCodeParams.getContent();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = formatter.format(new Date());
        String uuid = "";
        if (qrCodeParams.getContent()[0].indexOf("qrCode")>0){
            uuid = qrCodeParams.getContent()[0].substring(qrCodeParams.getContent()[0].indexOf("qrCode")+7,qrCodeParams.getContent()[0].length());
        }
        qrCodeParams.setOnColor(qrCodeParams.getOnColor().replace("#",""));
        qrCodeParams.setOffColor(qrCodeParams.getOffColor().replace("#",""));
        for(int i = 0;i < split.length;i++){
            String fileName = "";
            if(qrCodeParams.getImgType().equals("0")){
                if(isChinese(split[i])){
                    fileName = "other-"+String.valueOf(System.currentTimeMillis())+".jpg";
                } else {
                    fileName = split[i] + "-"+qrCodeParams.getApplyScope()+"-"+nowDate+".jpg";
                }
            } else {
                if(isChinese(split[i])){
                    fileName = "other-"+String.valueOf(System.currentTimeMillis())+".png";
                } else {
                    fileName = split[i] + "-"+qrCodeParams.getApplyScope()+"-"+nowDate+".png";
                }
            }
            qrCodeParams.setTxt(split[i]);
            fileName="p.jpg";
            qrCodeParams.setFileName(fileName);
            qrCodeParams.setFilePath(filePath);

            if(qrCodeParams.getOnColor().equals("")){
                qrCodeParams.setOnColor("000000");
            }
            if(qrCodeParams.getOffColor().equals("")){
                qrCodeParams.setOffColor("FFFFFF");
            }

            try {
                if (qrCodeParams.getExpiryDate() != null){
                    qrCodeParams.getContent()[0] = qrCodeParams.getContent()[0]+"&expiryDate="+qrCodeParams.getExpiryDate().toString();
                    qrCodeParams.setContent(qrCodeParams.getContent());
                }
                String x = qrCodeUtil.generateQRImage(qrCodeParams);

                if((i+1)==split.length){
                    resUrls += x;
                } else {
                    resUrls += x;
                }

                //return fileShowPath+qrCodeParams.getFileName();
            } catch (QRParamsException e){
                e.printStackTrace();
                resMap.put("code","10002");
                resMap.put("msg","二维码生成失败,请检查参数是否正确");
                resMap.put("imgUrl","");
                resMap.put("qrCode",uuid);
                return resMap;
            }
        }
        resMap.put("code","10001");
        resMap.put("msg","二维码生成成功");
        resMap.put("imgUrl",resUrls);
        resMap.put("qrCode",uuid);
        return resMap;
    }




    /*内部调用*/

    //####################################################################################################//
    /**
     * 字符串中不能包含中文和斜杠（/）和逗号（，）
     * @param strName
     * @return
     */
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

    /**
     * 判断字符串中是否包含汉字
     * @param c
     * @return
     */
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
}
