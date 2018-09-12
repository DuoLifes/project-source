package com.cn.connext.project.qrcode.entity;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.util.Date;

/**
 * 二维码生成实体类
 */
public class QRCodeParams {
    private String txt;                //二维码内容
    private String qrCodeUrl;          //二维码网络路径
    private String filePath;           //二维码生成物理路径
    private String fileName = "测试二维码";           //二维码生成图片名称（包含后缀名）
    private String logoPath;           //logo图片
    private Integer width = 430;           //二维码宽度
    private Integer height = 430;          //二维码高度
    private String onColor = "000000";  //前景色
    private String offColor = "FFFFFF"; //背景色
    private Integer margin = 1;            //白边大小，取值范围0~4
    private String imgType = "0";          //图片导出类型（0为jpg，1为png）
    private ErrorCorrectionLevel level = ErrorCorrectionLevel.L;  //二维码容错率
    private String applyScope = "AA";
    private Date expiryDate;
    private String[] content;
    private String page;

    public String[] getContent() {
        return content;
    }

    public void setContent(String[] content) {
        this.content = content;
    }

    public String getTxt() {
        return txt;
    }
    public void setTxt(String txt) {
        this.txt = txt;
    }
    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public Integer getWidth() {
        return width;
    }
    public void setWidth(Integer width) {
        this.width = width;
    }
    public Integer getHeight() {
        return height;
    }
    public void setHeight(Integer height) {
        this.height = height;
    }
    public String getQrCodeUrl() {
        return qrCodeUrl;
    }
    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }
    public String getLogoPath() {
        return logoPath;
    }
    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }
    public String getOnColor() {
        return onColor;
    }
    public void setOnColor(String onColor) {
        this.onColor = onColor;
    }
    public String getOffColor() {
        return offColor;
    }
    public void setOffColor(String offColor) {
        this.offColor = offColor;
    }
    public ErrorCorrectionLevel getLevel() {
        return level;
    }
    public void setLevel(ErrorCorrectionLevel level) {
        this.level = level;
    }
    public String getImgType() {
        return imgType;
    }
    public void setImgType(String imgType) {
        this.imgType = imgType;
    }
    public String getApplyScope() {
        return applyScope;
    }
    public void setApplyScope(String applyScope) {
        this.applyScope = applyScope;
    }
    public Date getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * 返回文件后缀名
     * @return
     */
    public String getSuffixName(){
        String imgName = this.getFileName();
        if(imgName != null && !"".equals(imgName)){
            String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
            return suffix;
        }
        return "";
    }
    public Integer getMargin() {
        return margin;
    }
    public void setMargin(Integer margin) {
        this.margin = margin;
    }
}
