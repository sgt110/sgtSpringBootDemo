/*
 * Project: sgtSpringBootDemo
 *
 * File Created at 2021-12-21
 *
 * Copyright 2012-2015 Greenline.com Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Greenline Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Greenline.com.
 */
package com.sgt;

/**
 * TODO
 *
 * @author WEIYI
 * @version V1.0
 * @since 2021-12-21 13:52
 */

import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import lombok.Data;

/**
 * 单元格合并策略类
 */
@Data
public class ExcelFillCellMergeStrategy implements CellWriteHandler {
    /**
     * 哪几列的字段需要合并
     */
    private int[] mergeColumnIndex;
    /**
     * 从第几行开始合并
     */
    private Integer[] mergeRowIndex;

    private List<Integer> mergeRowIndexList;

    public ExcelFillCellMergeStrategy() {
    }

    public ExcelFillCellMergeStrategy(Integer[] mergeRowIndex, int[] mergeColumnIndex) {
        this.mergeRowIndex = mergeRowIndex;
        this.mergeColumnIndex = mergeColumnIndex;
        mergeRowIndexList = new ArrayList<>(mergeRowIndex.length);
        Collections.addAll(mergeRowIndexList, mergeRowIndex);
    }

    @Override
    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row,
        Head head, Integer integer, Integer integer1, Boolean aBoolean) {

    }

    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell,
        Head head, Integer integer, Boolean aBoolean) {

        Workbook workbook = writeSheetHolder.getSheet().getWorkbook();
        CellStyle cellStyle = workbook.createCellStyle();
        Font cellFont = workbook.createFont();
        //加粗
        cellFont.setBold(true);
        //字体大小
        cellFont.setFontHeightInPoints((short) 12);
        //居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setFont(cellFont);
        cell.setCellStyle(cellStyle);
        //设置 自动换行
        cellStyle.setWrapText(true);
    }

    @Override
    public void afterCellDataConverted(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder,
        CellData cellData, Cell cell, Head head, Integer integer, Boolean aBoolean) {

    }

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder,
        List<CellData> list, Cell cell, Head head, Integer integer, Boolean aBoolean) {

        //当前行
        int curRowIndex = cell.getRowIndex();
        //当前列
        int curColIndex = cell.getColumnIndex();

        if (curRowIndex > 1) {
            if (mergeRowIndexList.contains(curRowIndex)) {
                return;
            } else {
                for (int i = 0; i < mergeColumnIndex.length; i++) {
                    if (curColIndex == mergeColumnIndex[i]) {
                        mergeWithPrevRow2(writeSheetHolder, cell, curRowIndex, curColIndex);
                        break;
                    }
                }
            }
        }
    }

    private void mergeWithPrevRow(WriteSheetHolder writeSheetHolder, Cell cell, int curRowIndex, int curColIndex) {
        //获取当前行的当前列的数据和上一行的当前列列数据，通过上一行数据是否相同进行合并
        Object curData =
            cell.getCellTypeEnum() == CellType.STRING ? cell.getStringCellValue() : cell.getNumericCellValue();
        Cell preCell = cell.getSheet().getRow(curRowIndex - 1).getCell(curColIndex);
        Object preData =
            preCell.getCellTypeEnum() == CellType.STRING ? preCell.getStringCellValue() : preCell.getNumericCellValue();

        // 比较当前行的第一列的单元格与上一行是否相同，相同合并当前单元格与上一行
        //
        if (curData.equals(preData)) {
            Sheet sheet = writeSheetHolder.getSheet();
            List<CellRangeAddress> mergeRegions = sheet.getMergedRegions();
            boolean isMerged = false;
            for (int i = 0; i < mergeRegions.size() && !isMerged; i++) {
                CellRangeAddress cellRangeAddr = mergeRegions.get(i);
                // 若上一个单元格已经被合并，则先移出原有的合并单元，再重新添加合并单元
                if (cellRangeAddr.isInRange(curRowIndex - 1, curColIndex)) {
                    sheet.removeMergedRegion(i);
                    cellRangeAddr.setLastRow(curRowIndex);
                    sheet.addMergedRegion(cellRangeAddr);
                    isMerged = true;
                }
            }
            // 若上一个单元格未被合并，则新增合并单元
            if (!isMerged) {
                CellRangeAddress cellRangeAddress = new CellRangeAddress(curRowIndex - 1, curRowIndex, curColIndex,
                    curColIndex);
                sheet.addMergedRegion(cellRangeAddress);
            }
        }
    }

    private void mergeWithPrevRow2(WriteSheetHolder writeSheetHolder, Cell cell, int curRowIndex, int curColIndex) {

        Sheet sheet = writeSheetHolder.getSheet();
        List<CellRangeAddress> mergeRegions = sheet.getMergedRegions();
        boolean isMerged = false;
        for (int i = 0; i < mergeRegions.size() && !isMerged; i++) {
            CellRangeAddress cellRangeAddr = mergeRegions.get(i);
            // 若上一个单元格已经被合并，则先移出原有的合并单元，再重新添加合并单元
            if (cellRangeAddr.isInRange(curRowIndex - 1, curColIndex)) {
                sheet.removeMergedRegion(i);
                cellRangeAddr.setLastRow(curRowIndex);
                sheet.addMergedRegion(cellRangeAddr);
                isMerged = true;
            }
        }
        // 若上一个单元格未被合并，则新增合并单元
        if (!isMerged) {
            CellRangeAddress cellRangeAddress = new CellRangeAddress(curRowIndex - 1, curRowIndex, curColIndex,
                curColIndex);
            sheet.addMergedRegion(cellRangeAddress);
        }
    }

    private void mergeWithPrevRow3(WriteSheetHolder writeSheetHolder, Cell cell, int curRowIndex, int curColIndex) {

    }

    //多次写入
}
