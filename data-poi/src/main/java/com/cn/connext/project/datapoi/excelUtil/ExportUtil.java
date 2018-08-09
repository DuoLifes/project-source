package com.cn.connext.project.datapoi.excelUtil;

import com.cn.connext.project.datapoi.entity.MediaType;
import com.cn.connext.project.datapoi.repository.MediaTypeRepository;
import com.cn.connext.project.datapoi.service.MediaTypeService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;

@Service
public class ExportUtil {
    @Resource
    private MediaTypeRepository mediaTypeRepository;

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
                cell4.setCellType(Cell.CELL_TYPE_STRING);//设置单元格数据类型
                mediaType.setRemark(cell4.getStringCellValue());
                mediaTypeRepository.create(mediaType);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
