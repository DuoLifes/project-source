package com.cn.connext.project.qrcode.cache;

import com.cn.connext.project.common.client.FileClient;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;

@Component
public class FileCache {

    @Resource
    private FileClient fileClient;

    @Cacheable("project.file.upload.uploadImage")
    public synchronized String uploadImage(MultipartFile postFile) {
        return fileClient.uploadImage(postFile);
    }
    @CacheEvict({"project.file.upload.uploadImage"})
    public synchronized void clear() {

    }
}
