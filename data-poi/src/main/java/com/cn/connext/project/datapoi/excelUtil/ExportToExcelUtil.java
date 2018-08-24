package com.cn.connext.project.datapoi.excelUtil;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class ExportToExcelUtil {

    private Logger logger = LoggerFactory.getLogger(ExportToExcelUtil.class);

    String newLine = System.getProperty("line.separator");

    public FileOutputStream export(SearchResponse searchResponse, FileOutputStream outputStream) throws IOException {
        for (SearchHit hits : searchResponse.getHits()) {
            outputStream.write(hits.getSource().get("id") == null ? "".getBytes() : (hits.getSource().get("id").toString()).getBytes());
            outputStream.write(",".getBytes());
            outputStream.write(hits.getSource().get("name") == null ? "".getBytes() : (hits.getSource().get("name").toString()).getBytes());
            outputStream.write(",".getBytes());
            outputStream.write(hits.getSource().get("type") == null ? "".getBytes() : (hits.getSource().get("type").toString()).getBytes());
            outputStream.write(",".getBytes());
            outputStream.write(hits.getSource().get("remark") == null ? "".getBytes() : (hits.getSource().get("remark").toString()).getBytes());
            outputStream.write(",".getBytes());
            outputStream.write(hits.getSource().get("createTime") == null ? "".getBytes() : (hits.getSource().get("createTime").toString()).getBytes());
            outputStream.write(newLine.getBytes());
        };
        return outputStream;
    }
}
