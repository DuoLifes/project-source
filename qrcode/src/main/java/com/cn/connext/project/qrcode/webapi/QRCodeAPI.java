package com.cn.connext.project.qrcode.webapi;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.qrcode.entity.QRCodeParams;
import com.cn.connext.project.qrcode.service.QRCodeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.Map;

@WebAPI("/api/qRcode")
public class QRCodeAPI {

    @Resource
    private QRCodeService qrCodeService;

    @PostMapping("/create")
    public Map<String, Object> createQrCode(@RequestBody QRCodeParams qrCodeParams) {
        return qrCodeService.createQrCode(qrCodeParams);
    }
}
