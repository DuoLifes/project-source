package com.cn.connext.project.datapoi.webapi;

import com.cn.connext.project.datapoi.entity.MediaType;
import com.cn.connext.project.datapoi.service.MediaTypeService;
import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.framework.query.QueryBuilder;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

@WebAPI("/api/data-poi/mediaTypePoi")
public class MediaTypePOI {

    @Resource
    private MediaTypeService mediaTypeService;

    //基本导出文档
    @GetMapping("/import")
    public void impot() {
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

    //基本导入文档
    @GetMapping("/export")
    public void export() {
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
    @GetMapping("/importMediaType")
    public void importMediaType() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //创建工作簿
            XSSFWorkbook workbook = new XSSFWorkbook();
            //新建工作表
            XSSFSheet sheet = workbook.createSheet("MediaType");
            List<MediaType> list=mediaTypeService.findAll();
            for(int i=0;i<list.size();i++){
                XSSFRow row = sheet.createRow(i);
                XSSFCell cell1 = row.createCell(0);
                cell1.setCellValue(list.get(i).getId());
                XSSFCell cell2 = row.createCell(1);
                cell2.setCellValue(list.get(i).getName());
                XSSFCell cell3 = row.createCell(2);
                cell3.setCellValue(list.get(i).getCode());
                XSSFCell cell4 = row.createCell(3);
                cell4.setCellValue(sdf.format(list.get(i).getUpdateTime()));
                XSSFCell cell5 = row.createCell(4);
                cell5.setCellValue(list.get(i).getRemark());
                XSSFCell cell6 = row.createCell(5);
                if (list.get(i).getIsInvalid()){
                    cell6.setCellValue(1);
                }else{
                    cell6.setCellValue(0);
                }
                XSSFCell cell7 = row.createCell(6);
                cell7.setCellValue(list.get(i).getCreateIndex());
            }
            FileOutputStream outputStream = new FileOutputStream("d:\\工作簿.xlsx");
            workbook.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    //文档导入数据库
    @GetMapping("/exportMediaType")
    public void exportMediaType() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            FileInputStream inputStream = new FileInputStream("d:\\工作簿.xlsx");
            //将输入流转换为workbook
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            //获取工作表
            XSSFSheet sheet = workbook.getSheetAt(0);
            for(int i=0;i<sheet.getPhysicalNumberOfRows();i++){
                MediaType mediaType=new MediaType();
                XSSFRow row = sheet.getRow(i);
                XSSFCell cell0 = row.getCell(0);
                XSSFCell cell1 = row.getCell(1);
                XSSFCell cell2 = row.getCell(2);
                XSSFCell cell3 = row.getCell(3);
                XSSFCell cell4 = row.getCell(4);
                mediaType.setId(cell0.getStringCellValue());
                mediaType.setName(cell1.getStringCellValue());
                mediaType.setCode(cell2.getStringCellValue());
                mediaType.setUpdateTime(format.parse(cell3.getStringCellValue()));
                mediaType.setRemark(cell4.getStringCellValue());
                mediaTypeService.create(mediaType);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
