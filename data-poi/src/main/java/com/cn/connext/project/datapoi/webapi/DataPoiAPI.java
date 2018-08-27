package com.cn.connext.project.datapoi.webapi;

import com.cn.connext.project.datapoi.excelUtil.ImportUtil;
import com.cn.connext.project.datapoi.excelUtil.ExportUtil;
import com.cn.connext.project.datapoi.service.DataPoiService;
import com.cn.connext.project.framework.annotation.WebAPI;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


@WebAPI("/api/data-poi/dataPoi")
public class DataPoiAPI {

    @Resource
    private ExportUtil exportUtil;
    @Resource
    private ImportUtil importUtil;
    //文档导出路径
    @Value("${project-source.data-poi.exportUrl}")
    private String exportUrl;
    //文件上传路径
    @Value("${project-source.data-poi.uploadPath}")
    private String uploadPath;
    @Resource
    private DataPoiService dataPoiService;

    //基本数据导出至文档
    @GetMapping("/export")
    public void export() {
        try {
            //创建工作簿
            XSSFWorkbook workbook = new XSSFWorkbook();
            //新建工作表
            XSSFSheet sheet = workbook.createSheet("张帅");
            //创建行，行号作为参数，第一行从0开始计算
            XSSFRow row = sheet.createRow(0);
            //创建单元格，row已经确定行号，列好作为参数，第一列从0开始计算
            XSSFCell cell = row.createCell(2);
            //设置单元格（第一行第三列）
            cell.setCellValue("张帅好腻害");
            FileOutputStream outputStream = new FileOutputStream("d:\\工作簿.xlsx");
            workbook.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    //从文档导出数据
    @GetMapping("/import")
    public void imports() {
        try {
            FileInputStream inputStream = new FileInputStream("d:\\工作簿.xlsx");
            //将输入流转换为workbook
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            //获取工作表
            XSSFSheet sheet = workbook.getSheetAt(0);
            //获取行
            XSSFRow row = sheet.getRow(0);
            //获取单元格（第一行第三列）
            XSSFCell cell = row.getCell(2);

            System.out.println("单元格内容为:" + cell.getStringCellValue());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    //从数据库导出数据到文档
    @GetMapping("/exportMediaType")
    public void exportMediaType() {
        exportUtil.exportMediaType();
    }

    //文档导入数据库
    @GetMapping("/importsMediaType")
    public void importsMediaType() {
        importUtil.importMediaType();
    }

    //从es导出至文档
    @GetMapping("/exportByEs")
    public void exportByEs(){
        try {
            String filename="测试ES导出工作簿.csv";
            String url=exportUrl+filename;
            File file = new File(url);
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream=dataPoiService.exportByEs(outputStream);
            outputStream.flush();
            outputStream.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    //上传文件
    @GetMapping("/upload")
    public void upload(){
        //@RequestPart("file") MultipartFile postFile 前端传参用此注解接收
        String filename="测试ES导出工作簿.csv";
        String url=exportUrl+filename;
        //要上传的文件路径
        File file = new File(url);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile("file", fileInputStream);
            dataPoiService.upload(multipartFile,filename,uploadPath);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //上传图片
    @PostMapping(value = "/image")
    public String uploadImage(@RequestPart("file") MultipartFile postFile) {
        return dataPoiService.savePostFile(postFile);
    }

    //远程文件上传
    @PostMapping(value = "/RemoteFile")
    public String captureImage(@RequestParam String url) {
        return dataPoiService.saveRemoteFile(url);
    }
}
