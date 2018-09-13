package com.cn.connext.project.datapoi.service;

import com.cn.connext.project.datapoi.repository.DataPoiRepository;
import com.cn.connext.project.framework.exception.ServiceException;
import com.cn.connext.project.framework.io.FileUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataPoiService {
    @Resource
    private DataPoiRepository dataPoiRepository;
    //图片仓库
    @Value("${project-source.data-poi.storagePath}")
    private String storagePath;
    //图片浏览URL
    private String internetUrl=storagePath;

    private static String DEFAULT_IMAGE_FORMAT = "jpg";

    private static List<String> ALLOWED_IMAGE_FORMATS = new ArrayList<String>() {{
        add("gif");
        add("png");
        add("bmp");
        add("tif");
        add("jpg");
        add("jpeg");
    }};


    //从es导出至文档
    public FileOutputStream exportByEs( FileOutputStream outputStream)throws IOException {
        return dataPoiRepository.exportByEs(outputStream);
    }

    //文件上传
    public String upload(MultipartFile file, String fileName,String uploadPath){
        if(file.getSize()<=0){
            throw new ServiceException("File_EMPTY_Error", "所要上传的文件不能为空。");
        }

        try {
            FileUtils.prepareFolder(uploadPath);
            FileUtils.saveFileUtf(uploadPath + fileName, file.getBytes());
            return uploadPath + fileName;
        } catch (Exception e) {
            System.out.println("保存文件发生错误:" +e);
            throw new ServiceException("File_Save_Error", "保存文件发生错误。");
        }
    }

    //图片上传
    public String savePostFile(MultipartFile postFile) {
        if(postFile.getSize()<=0){
            throw new ServiceException("File_EMPTY_Error", "所要上传的文件不能为空。");
        }
        try {
            String fileName = FileUtils.getMd5FileName(postFile);
            FileUtils.prepareFolder(storagePath);
            FileUtils.safeSave(storagePath + fileName, postFile.getBytes());
            return internetUrl + fileName;
        } catch (Exception e) {
            System.out.println(e);
            throw new ServiceException("File_Save_Error", "保存文件发生错误。");
        }
    }

    //远程文件上传
    public String saveRemoteFile(String url) {
        try {
            HttpClient client = HttpClients.createDefault();
            HttpGet httpget = new HttpGet(url);
            httpget.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
            httpget.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36");
            HttpResponse response = client.execute(httpget);
            HttpEntity entity = response.getEntity();
            InputStream inStream = entity.getContent();

            byte[] fileData = FileUtils.streamToBytes(inStream);

            String extensionName = getExtensionName(url, response);
            String fileName = FileUtils.getMd5Code(fileData) + "." + extensionName;
            FileUtils.prepareFolder(storagePath);
            FileUtils.safeSave(storagePath + fileName, fileData);

            return internetUrl + fileName;

        } catch (IOException e) {
            System.out.println(e);
            throw new ServiceException("File_Save_Error", "保存文件发生错误。");
        }
    }
    private String getExtensionName(String url, HttpResponse httpResponse) {
        String extensionName = getExtensionNameByHeader(httpResponse);
        if (extensionName == null) {
            extensionName = FileUtils.getExtensionName(url);
        }
        extensionName = getAllowedImageFormat(extensionName);
        return extensionName;
    }
    private String getExtensionNameByHeader(HttpResponse httpResponse) {
        Header[] header = httpResponse.getHeaders("Content-Type");
        if (header.length > 0) {
            String headerInfo = header[0].getValue();
            return headerInfo.replace("image/", "");
        }
        return null;
    }
    private String getAllowedImageFormat(String extName) {
        if (ALLOWED_IMAGE_FORMATS.contains(extName)) return extName;
        return DEFAULT_IMAGE_FORMAT;
    }
}
