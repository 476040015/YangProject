package com.example.work.biz;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class ExcelRead {
    public static void main(String[] args) {
        String path = "D:\\2.xlsx";
        String result = readExcelFile(path);
        System.out.println(result);
    }

    public static String readExcelFile(String filePath) {
        File file = new File(filePath);
        try (FileInputStream fis = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // 读取第一个工作表
            return parseSheet(sheet);

        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading file: " + e.getMessage();
        }
    }

    private static String parseSheet(Sheet sheet) {
        JSONArray result = new JSONArray();
        for (Row row : sheet) {
            JSONObject json = new JSONObject();
            for (Cell cell : row) {
                String cellValue = getCellValue(cell);
                json.put("column_" + cell.getColumnIndex(), cellValue);
            }
            result.put(json);
        }
        return result.toString();
    }

    private static String getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    DecimalFormat df = new DecimalFormat("0");
                    return df.format(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return Boolean.toString(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }

}
