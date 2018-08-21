package com.cn.connext.project.datapoi.excelUtil;

import org.springframework.stereotype.Service;

import java.io.FileOutputStream;


@Service
public class ExportHeaderUtil {

    public FileOutputStream exportHeader(FileOutputStream outputStream) throws Exception{

            String newLine = System.getProperty("line.separator");

            String[] excelHeader = new String[]{"编码", "名称", "类型", "备注", "创建时间"};
            for (String s : excelHeader) {
                outputStream.write(s.getBytes());
                outputStream.write(",".getBytes());
            }
        outputStream.write(newLine.getBytes());
            return outputStream;
    }
}
