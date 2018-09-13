package com.cn.connext.project.qrcode.qrcodeUtil;

import com.cn.connext.project.framework.exception.ServiceException;
import com.cn.connext.project.qrcode.cache.FileCache;
import com.cn.connext.project.qrcode.entity.QRCodeParams;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

/**
 * 二维码工具类
 *
 */
@Component
public class QRCodeUtil {

    @Resource
    private FileCache fileCache;

    String qrcodeUrl= "D:\\file";

    private static int width = 300;              //二维码宽度
    private static int height = 300;             //二维码高度
    private static int onColor = 0xFF000000;     //前景色
    private static int offColor = 0xFFFFFFFF;    //背景色
    private static int margin = 1;               //白边大小，取值范围0~4
    private static ErrorCorrectionLevel level = ErrorCorrectionLevel.L;  //二维码容错率


    /**
     * 生成二维码
     * @param params
     * QRCodeParams属性：txt、fileName、filePath不得为空；
     * @throws QRParamsException
     */
    public String generateQRImage(QRCodeParams params)throws QRParamsException{

        if(params == null
                || params.getFileName() == null
                || params.getFilePath() == null
                || params.getTxt() == null){

            throw new QRParamsException("参数错误");
        }
        try{
            initData(params);

            String imgPath = params.getFilePath();
            String imgName = params.getFileName();
            String txt = params.getTxt();

            String FilePath = qrcodeUrl;

            if(params.getLogoPath() != null && !"".equals(params.getLogoPath().trim())){
                String x = generateQRImage(txt, params.getLogoPath(), FilePath, imgName, params.getSuffixName());
                return x;
            }else{
                String x = generateQRImage(txt, FilePath, imgName, params.getSuffixName());
                return x;
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new QRParamsException("参数错误");
        }
    }

    /*内部调用*/
    //####################################################################################################//
    private static void initData(QRCodeParams params){
        if(params.getWidth() != null && !params.getWidth().equals("") && !params.getWidth().equals("null")){
            width = params.getWidth();
        }
        if(params.getHeight() != null && !params.getHeight().equals("") && !params.getHeight().equals("null")){
            height = params.getHeight();
        }
        if(params.getOnColor() != null && !params.getOnColor().equals("") && !params.getOnColor().equals("null")){
            onColor =  Integer.parseInt(params.getOnColor(),16);
        }
        if(params.getOffColor() != null && !params.getOffColor().equals("") && !params.getOffColor().equals("null")){
            offColor = Integer.parseInt(params.getOffColor(),16);
        }
        if(params.getLevel() != null){
            level = params.getLevel();
        }
    }

    //####################################################################################################//
    /**
     * 生成带logo的二维码图片
     * @param txt          //二维码内容
     * @param logoPath     //logo绝对物理路径
     * @param imgPath      //二维码保存绝对物理路径
     * @param imgName      //二维码文件名称
     * @param suffix       //图片后缀名
     * @throws Exception
     */
    public String generateQRImage(String txt, String logoPath, String imgPath, String imgName, String suffix) throws Exception{
        File filePath = new File(imgPath);
        if(!filePath.exists()){
            filePath.mkdirs();
        }
        if(imgPath.endsWith("/")){
            imgPath += imgName;
        }else{
            imgPath += "/"+imgName;
        }
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, level);
        hints.put(EncodeHintType.MARGIN, margin);  //设置白边
        BitMatrix bitMatrix = new MultiFormatWriter().encode(txt, BarcodeFormat.QR_CODE, width, height, hints);
        File qrcodeFile = new File(imgPath);
        writeToFile(bitMatrix, suffix, qrcodeFile, logoPath);
        // File转换成MutipartFile
//        File file = WebFileUtils.createFileByUrl(qrcodeFile.getPath(), "jpg");
        FileInputStream inputStream = new FileInputStream(qrcodeFile);
        MultipartFile multipartFile = new MockMultipartFile("file",imgName,"jpg",inputStream);
        String x = fileCache.uploadImage(multipartFile);
        qrcodeFile.delete();
        return x;
    }
    //####################################################################################################//

    /**
     * 生成二维码
     * @param txt          //二维码内容
     * @param imgPath      //二维码保存物理路径
     * @param imgName      //二维码文件名称
     * @param suffix       //图片后缀名
     */
    public String generateQRImage(String txt, String imgPath, String imgName, String suffix) throws Exception{
        File filePath = new File(imgPath);
        if(!filePath.exists()){
            filePath.mkdirs();
        }
        File imageFile = new File(imgPath,imgName);
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        // 指定纠错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, level);
        // 指定编码格式
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.MARGIN, margin);   //设置白边
        try {
            MatrixToImageConfig config = new MatrixToImageConfig(onColor, offColor);
            BitMatrix bitMatrix = new MultiFormatWriter().encode(txt,BarcodeFormat.QR_CODE, width, height, hints);
            MatrixToImageWriter.writeToPath(bitMatrix, suffix, imageFile.toPath(), config);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // File转换成MutipartFile
//        File file = WebFileUtils.createFileByUrl(imageFile.getPath(), "jpg");
        FileInputStream inputStream = new FileInputStream(imageFile);
        //MockMultipartFile类型文件主要用于测试
        MultipartFile multipartFile = new MockMultipartFile("file",imgName,"jpg",inputStream);
        String x = fileCache.uploadImage(multipartFile);
        imageFile.delete();

        return x;

    }

    //####################################################################################################//
    /**
     *
     * @param matrix 二维码矩阵相关
     * @param format 二维码图片格式
     * @param file 二维码图片文件
     * @param logoPath logo路径
     * @throws IOException
     */
    public static void writeToFile(BitMatrix matrix,String format,File file,String logoPath) throws IOException {

        BufferedImage image = toBufferedImage(matrix);
        Graphics2D gs = image.createGraphics();

        int ratioWidth = image.getWidth()*2/10;
        int ratioHeight = image.getHeight()*2/10;
        //载入logo
        Image img = ImageIO.read(FileUtils.getInputStreamByGet(logoPath));
        int logoWidth = img.getWidth(null)>ratioWidth?ratioWidth:img.getWidth(null);
        int logoHeight = img.getHeight(null)>ratioHeight?ratioHeight:img.getHeight(null);

        int x = (image.getWidth() - logoWidth) / 2;
        int y = (image.getHeight() - logoHeight) / 2;

        gs.drawImage(img, x, y, logoWidth, logoHeight, null);
        gs.setColor(Color.black);
        gs.setBackground(Color.WHITE);
        gs.dispose();
        img.flush();
        if(!ImageIO.write(image, format, file)){
            throw new IOException("Could not write an image of format " + format + " to " + file);
        }
    }

    //####################################################################################################//
    public static BufferedImage toBufferedImage(BitMatrix matrix){
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int x=0;x<width;x++){
            for(int y=0;y<height;y++){
                image.setRGB(x, y, matrix.get(x, y) ? onColor : offColor);
            }
        }
        return image;
    }

    //####################################################################################################//
}