package com.cn.connext.project.datapoi;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@SpringBootTest
public class DataPoiApplicationTests {

	@Test
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
		}catch (Exception e){
			System.out.println(e.toString());
		}
	}

	@Test
	public void impot(){
		try{
			//创建工作簿
			XSSFWorkbook workbook=new XSSFWorkbook();
			//新建工作表
			XSSFSheet sheet=workbook.createSheet("张帅");
			//创建行，行号作为参数，第一行从0开始计算
			XSSFRow row=sheet.createRow(0);
			//创建单元格，row已经确定行号，列好作为参数，第一列从0开始计算
			XSSFCell cell=row.createCell(2);
			//设置单元格（第一行第三列）
			cell.setCellValue("张帅好腻害");
			FileOutputStream outputStream=new FileOutputStream("d:\\工作簿.xlsx");
			workbook.write(outputStream);
			outputStream.close();
		}catch (Exception e){
			System.out.println(e.toString());
		}
	}
}
