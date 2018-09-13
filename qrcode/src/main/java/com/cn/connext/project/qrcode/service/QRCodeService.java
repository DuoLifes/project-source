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

    //二维码路径
    private final static String filePath = "D:/image/";

    private final static String logoPath="http://localhost:8508/test.jpg";

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String nowDate = formatter.format(new Date());

    @Resource
    private QRCodeUtil qrCodeUtil;


    /**
     * 生成二维码（普通二维码）。
     *
     * @param qrCodeParams
     */
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
