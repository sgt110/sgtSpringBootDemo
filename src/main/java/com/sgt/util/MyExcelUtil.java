package com.sgt.util;

import org.apache.commons.codec.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static cn.hutool.poi.excel.cell.CellUtil.getCellValue;
import static cn.hutool.poi.excel.cell.CellUtil.getMergedRegionValue;
import static cn.hutool.poi.excel.cell.CellUtil.isMergedRegion;
import static org.apache.tomcat.util.http.fileupload.FileUploadBase.CONTENT_TYPE;


/**
 * @author 孙官土
 * @description excel工具类
 * @date 2023/9/13 11:25
 */
public class MyExcelUtil {

    /***
     * 读取excel文件
     * @param inputStream 文件流
     * @return
     */
    public static List<String[]> readExcel(InputStream inputStream,String sheetName) throws IOException, ParseException {
        Workbook workbook = null;
        try {
            // 创建list存放读取的数据
            List<String[]> list = new ArrayList<>();
            // 这种方式 Excel 2003/2007/2010 都是可以处理的
            workbook = WorkbookFactory.create(inputStream);
            Sheet sheet;
            if (StringUtils.isBlank(sheetName)) {
                sheet = workbook.getSheetAt(0); //默认只读第一个sheet
            } else {
                sheet = workbook.getSheet(sheetName); //按照名字读
            }
            // 获取第一行
            Row row1 = sheet.getRow(0);
            // 第一行为空
            if (row1 == null) {
                return null;
            }
            int rowCount = sheet.getPhysicalNumberOfRows(); // 获取不为空的总行数
            int cellCount = row1.getPhysicalNumberOfCells(); // 从第一行获取不为空的总列数

            // 遍历每一行
            for (int r = 0; r < rowCount; r++) {
                Row row = sheet.getRow(r);
                if(row == null)
                    continue;

                // 创建一个数组 用来存储每一列的值
                String[] lineItem = new String[cellCount];
                // 遍历每一列
                for (int c = 0; c < cellCount; c++)
                {
                    Cell cell = row.getCell(c);
                    if (cell == null)
                    {
                        continue;
                    }
                    CellType cellType = cell.getCellType();
                    String cellValue = null;
                    if(CellType.STRING == cellType){ // 文本
                        cellValue = cell.getStringCellValue();
                    } else if(CellType.NUMERIC == cellType){
                        if (DateUtil.isCellDateFormatted(cell))
                        {
                            cellValue = MyDateUtils.format(cell.getDateCellValue(), MyDateUtils.FORMAT_YMDHMS); // 日期型
                        }
                        else
                        {
                            cellValue = String.valueOf(cell.getNumericCellValue()); // 数字
                            if (cellValue.endsWith(".0"))
                            {
                                cellValue = cellValue.substring(0, cellValue.length() - 2);
                            }
                            //防止科学计数法
                            BigDecimal bd = new BigDecimal(cellValue);
                            cellValue = bd.toPlainString();
                            if (cellValue.endsWith(".0"))
                            {
                                cellValue = cellValue.substring(0, cellValue.length() - 2);
                            }
                        }
                    } else if(CellType.BOOLEAN == cellType){
                        cellValue = String.valueOf(cell.getBooleanCellValue());
                    } else if(CellType.BLANK == cellType){
                        cellValue = cell.getStringCellValue();
                    } else {
                        cellValue = "error";
                    }

                    lineItem[c] = cellValue;
                }

                list.add(lineItem);
            }
            return list;

        } finally {
            try {
                if(inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String[]> readMergedExcel(InputStream inputStream,String sheetName) throws IOException, ParseException {
        Workbook workbook = null;
        try {
            // 创建list存放读取的数据
            List<String[]> list = new ArrayList<>();
            // 这种方式 Excel 2003/2007/2010 都是可以处理的
            workbook = WorkbookFactory.create(inputStream);
            Sheet sheet;
            if (StringUtils.isBlank(sheetName)) {
                sheet = workbook.getSheetAt(0); //默认只读第一个sheet
            } else {
                sheet = workbook.getSheet(sheetName); //按照名字读
            }
            // 获取第一行
            Row row1 = sheet.getRow(0);
            // 第一行为空
            if (row1 == null) {
                return null;
            }
            int rowCount = sheet.getLastRowNum(); // 获取不为空的总行数
            int cellCount = row1.getLastCellNum(); // 从第一行获取不为空的总列数

            // 遍历每一行
            for (int r = 0; r <= rowCount; r++) {
                Row row = sheet.getRow(r);
                if(row == null)
                    continue;

                // 创建一个数组 用来存储每一列的值
                String[] lineItem = new String[cellCount];
                // 遍历每一列
                for (int c = 0; c < cellCount; c++)
                {
                    // 判断当前单元格是否是合并单元格
                    if (isMergedRegion(sheet, c, r)) {
                        // 如果是合并单元格，获取合并单元格的值
                        lineItem[c] = (String) getMergedRegionValue(sheet, r, c);
                    } else {
                        Cell cell = row.getCell(c);
                        if (cell == null) {
                            continue;
                        }
                        // 如果不是合并单元格，获取单元格的值
                        CellType cellType = cell.getCellType();
                        String cellValue;
                        if (CellType.STRING == cellType) { // 文本
                            cellValue = cell.getStringCellValue();
                        } else if (CellType.NUMERIC == cellType) {
                            if (DateUtil.isCellDateFormatted(cell)) {
                                cellValue = MyDateUtils.format(cell.getDateCellValue(), MyDateUtils.FORMAT_YMDHMS); // 日期型
                            } else {
                                cellValue = String.valueOf(cell.getNumericCellValue()); // 数字
                                if (cellValue.endsWith(".0")) {
                                    cellValue = cellValue.substring(0, cellValue.length() - 2);
                                }
                                //防止科学计数法
                                BigDecimal bd = new BigDecimal(cellValue);
                                cellValue = bd.toPlainString();
                                if (cellValue.endsWith(".0")) {
                                    cellValue = cellValue.substring(0, cellValue.length() - 2);
                                }
                            }
                        } else if (CellType.BOOLEAN == cellType) {
                            cellValue = String.valueOf(cell.getBooleanCellValue());
                        } else if (CellType.BLANK == cellType) {
                            cellValue = cell.getStringCellValue();
                        } else {
                            cellValue = "error";
                        }
                        lineItem[c] = cellValue;
                    }
                }

                list.add(lineItem);
            }
            return list;

        } finally {

        }
    }


    public static void writeExcel(List<String[]> rowValues, String fileName, String sheetName, HttpServletResponse response) throws IOException {
        Workbook wb = new SXSSFWorkbook();
        //设置单元格式
        Font font = wb.createFont();
        font.setColor(Font.COLOR_NORMAL);
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        if (StringUtils.isBlank(sheetName)) {
            sheetName = "sheet1";
        }
        Sheet sheet = wb.createSheet(sheetName);
        for (int i = 0; i < rowValues.size(); i++) {
            Row currentRow = sheet.createRow(i);
            // 获取当前行的数据
            String[] cellValues = rowValues.get(i);
            for (int j = 0; j < cellValues.length; j++) {
                // 设置列宽
                sheet.setColumnWidth(j, 4100);
                Cell cell = currentRow.createCell(j);
                cell.setCellStyle(cellStyle);
                //每个单元格的值目前做 String 处理
                cell.setCellType(CellType.STRING);
                cell.setCellValue(cellValues[j]);
            }
        }
        OutputStream os = null;
        try {
            response.setContentType(CONTENT_TYPE);
            response.setCharacterEncoding(Charsets.UTF_8.name());
            response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s", new String(URLEncoder.encode(fileName + ".xlsx" , Charsets.UTF_8.name())
                    .getBytes(Charsets.UTF_8), Charsets.ISO_8859_1)));
            os = response.getOutputStream();
            wb.write(os);
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != wb) {
                try {
                    wb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static ByteArrayOutputStream creatExcel(String[] title, List<String[]> rowValues, String sheetName) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Workbook wb = new SXSSFWorkbook();
        //设置单元格式
        Font font = wb.createFont();
        font.setColor(Font.COLOR_NORMAL);
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        if (StringUtils.isBlank(sheetName)) {
            sheetName = "sheet1";
        }
        Sheet sheet = wb.createSheet(sheetName);
        //设置首行
        Row row0 = sheet.createRow(0);
        for (int i = 0; i < title.length; i++) {
            Cell cell = row0.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(title[i]);
        }
        for (int i = 0; i < rowValues.size(); i++) {
            Row currentRow = sheet.createRow(i + 1);
            // 获取当前行的数据
            String[] cellValues = rowValues.get(i);
            for (int j = 0; j < cellValues.length; j++) {
                // 设置列宽
                sheet.setColumnWidth(j, 4100);
                Cell cell = currentRow.createCell(j);
                cell.setCellStyle(cellStyle);
                //每个单元格的值目前做 String 处理
                cell.setCellType(CellType.STRING);
                cell.setCellValue(cellValues[j]);
            }
        }
        try {
            wb.write(baos); // write excel data to a byte array
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baos;

    }
}
