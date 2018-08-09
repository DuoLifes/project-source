package com.cn.connext.project.datapoi.excelUtil;

import com.cn.connext.project.datapoi.entity.MediaType;
import com.cn.connext.project.datapoi.repository.MediaTypeRepository;
import com.cn.connext.project.datapoi.service.MediaTypeService;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ImportUtil {

    @Resource
    private MediaTypeRepository mediaTypeRepository;

    public void importMediaType() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //创建工作簿
            XSSFWorkbook workbook = new XSSFWorkbook();
            //新建工作表
            XSSFSheet sheet = workbook.createSheet("MediaType");
            CellStyle cellStyle = workbook.createCellStyle();
            // 设置这些样式
            cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
            cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
            cellStyle.setBorderRight(CellStyle.BORDER_THIN);
            cellStyle.setBorderTop(CellStyle.BORDER_THIN);
            cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
            XSSFFont contentFont = workbook.createFont(); // 定义字体
            contentFont.setFontName("微软雅黑");//设置字体
            contentFont.setFontHeightInPoints((short) 10);//设置字号
            contentFont.setBold(true);//设置加粗
            cellStyle.setFont(contentFont);
            //查询数据
            List<MediaType> list=mediaTypeRepository.findAll();
            for(int i=0;i<list.size();i++){
                XSSFRow row = sheet.createRow(i);
                XSSFCell cell1 = row.createCell(0);
                cell1.setCellStyle(cellStyle);
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
}
