package com.cn.connext.project.qrcode.webapi;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.qrcode.entity.QRCodeParams;
import com.cn.connext.project.qrcode.service.QRCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Map;

@WebAPI("/api/qRcode")
public class QRCodeAPI {

    @Resource
    private QRCodeService qrCodeService;

    /*生成普通二维码*/
    @PostMapping("/create")
    public Map<String, Object> createQrCode(@RequestBody QRCodeParams qrCodeParams) {
        return qrCodeService.createQrCode(qrCodeParams);
    }

    /*生成二维码（微信二维码)*/
    @PostMapping("/createWeChatQrCode")
    public Map<String, Object> createWeChatQrCode(@RequestParam(value = "imgType",required = false)String imgType,
                                                  @RequestParam(value = "appId")String appId,
                                                  @RequestParam(value = "appSecret")String appSecret) {
        return qrCodeService.createWeChatQrCode(appId,appSecret,imgType);
    }

    /*生成二维码小程序*/
    @GetMapping("/createProgramQrCode")
    public Map<String, Object> createProgramQrCode(@RequestParam(value = "imgType",required = false)String imgType,
                                                   @RequestParam(value = "width",required = false)String width,
                                                   @RequestParam(value = "page",required = false)String page,
                                                   @RequestParam(value = "appId",required = false)String appId,
                                                   @RequestParam(value = "appSecret",required = false)String appSecret) {
        return qrCodeService.createProgramQrCode(imgType,width,page,appId,appSecret);
    }
}
