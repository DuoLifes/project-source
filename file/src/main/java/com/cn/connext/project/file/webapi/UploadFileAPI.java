package com.cn.connext.project.file.webapi;

import com.cn.connext.project.file.service.ImageFileService;
import com.cn.connext.project.framework.annotation.WebAPI;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;

@WebAPI("/api/file/upload")
public class UploadFileAPI {

    @Resource
    private ImageFileService imageFileService;

    /*上传图片*/
    @PostMapping(value = "/image")
    public String uploadImage(@RequestPart("file") MultipartFile postFile) {
        return imageFileService.savePostFile(postFile);
    }

    /*上传文件*/
    @PostMapping(value = "/export")
    public String uploadExport(@RequestPart("file") MultipartFile postFile,@RequestParam String fileName) {
        return imageFileService.saveExportFile(postFile,fileName);
    }

    /*根据url远程上传文件*/
    @PostMapping(value = "/image")
    public String captureImage(@RequestParam String url) {
        return imageFileService.saveRemoteFile(url);
    }

}
