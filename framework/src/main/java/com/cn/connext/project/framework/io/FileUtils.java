package com.cn.connext.project.framework.io;

import org.apache.commons.codec.binary.Hex;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileUtils {

    /**
     * 获取文件扩展名称
     *
     * @param filename abc.png /images/abc.png
     * @return
     */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return "";
    }

    public static String getMd5Code(byte[] data) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(data);
            return new String(Hex.encodeHex(md5.digest()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getMd5FileName(MultipartFile postFile) {
        String originalFileName = postFile.getOriginalFilename();
        String extensionName = FileUtils.getExtensionName(originalFileName);
        try {
            return FileUtils.getMd5Code(postFile.getBytes()) + "." + extensionName;
        } catch (IOException e) {
            return "";
        }
    }

    public static void prepareFolder(String path) {
        File storagePathDir = new File(path);
        if (!storagePathDir.exists()) {
            storagePathDir.mkdirs();
        }
    }

    public static boolean isFileExists(String path) {
        File file = new File(path);
        return file.exists();
    }

    public static void safeSave(String path, byte[] data) {
        if (isFileExists(path)) return;
        saveFile(path, data);
    }

    public static void saveFile(String path, byte[] data) {
        try {
            FileOutputStream out = new FileOutputStream(path);
            out.write(data);
            out.flush();
            out.close();
        } catch (Exception e) {
            throw new RuntimeException("save file error:" + e.getMessage());
        }
    }

    public static void saveFileUtf(String path, byte[] data) {
        try {
            FileOutputStream out = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
            osw.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB,(byte) 0xBF }));
            BufferedWriter bufw = new BufferedWriter(osw);
            osw.write(new String(data));
            if(osw!=null) {
                osw.flush();
                osw.close();
            }
            if(bufw!=null)
                bufw.close();
        } catch (Exception e) {
            throw new RuntimeException("saveFileUtf file error:" + e.getMessage());
        }
    }

    public static byte[] streamToBytes(InputStream inStream) {
        try {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            outStream.close();
            inStream.close();
            byte[] fileData = outStream.toByteArray();
            return fileData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
