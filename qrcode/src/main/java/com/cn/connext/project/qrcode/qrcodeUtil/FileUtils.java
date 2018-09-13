package com.cn.connext.project.qrcode.qrcodeUtil;

import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.FileChannel;

/**
 * @Title: FileUtils
 * @Description: 文件（文件流转换、存储、拷贝、清空、写入）
 * @Company: 卜凡起的博客
 * @author    FANQIBU
 * @date       2018年2月2日
 */
@Component
public class FileUtils {
    // 通过get请求得到读取器响应数据的数据流
    public static InputStream getInputStreamByGet(String url) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = conn.getInputStream();
                return inputStream;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //inputStream转outputStream
    public static ByteArrayOutputStream parse(InputStream in)
    {
        try {
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            int ch;
            while ((ch = in.read()) != -1) {
                swapStream.write(ch);
            }
            return swapStream;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return  null;
    }
    //outputStream转inputStream
    public static ByteArrayInputStream parse(OutputStream out)
    {
        try {
            ByteArrayOutputStream   baos=new   ByteArrayOutputStream();
            baos=(ByteArrayOutputStream) out;
            ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());
            return swapStream;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return  null;
    }
    public static void main(String[] args) {
        InputStream is=getInputStreamByGet("http://mmbiz.qpic.cn/mmbiz_png/KYOtWWibVu2UiaFNlhrOrmD5OFRMXyDJMAPwwQSr5FZe7O99eoppFPxsvDEcwKBibicgKkDK7SUYT2ewUOGSheGGRg/0?wx_fmt=png");
        saveData(is,new File("d://ceshi.jpg"));
    }
    // 将服务器响应的数据流存到本地文件
    public static void saveData(InputStream is, File file) {
        try (BufferedInputStream bis = new BufferedInputStream(is);
             BufferedOutputStream bos = new BufferedOutputStream(
                     new FileOutputStream(file));) {
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>Title: copyFileUsingFileChannels</p>
     * <p>Description: 文件拷贝</p>
     * @param source
     * @param dest
     * @throws IOException
     */
    public synchronized  static  void copyFileUsingFileChannels(File source, File dest) throws IOException {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } finally {
            inputChannel.close();
            outputChannel.close();
        }
    }

}