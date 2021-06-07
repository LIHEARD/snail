package com.theinterview;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestExcel {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream("C:\\Users\\lishiwei\\Desktop\\整理完成\\中成药-男科-皮肤-口腔.xlsx"));
        Sheet sheet = xssfWorkbook.getSheet("sheet1");
        for (Row row : sheet){
            System.out.println(row.getCell(0));
        }

    }
}
