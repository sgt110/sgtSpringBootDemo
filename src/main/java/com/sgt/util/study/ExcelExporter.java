package com.sgt.util.study;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ExcelExporter {

    public static void exportToExcel(String[][] data, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            FileChannel channel = fos.getChannel();
            // 创建Excel文件头
            String excelHeader = "Name\tAge\tGender\n";
            // 创建ByteBuffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put(excelHeader.getBytes());
            // 遍历数据数组，将每行数据写入ByteBuffer
            for (String[] row : data) {
                String rowData = String.join("\t", row) + "\n";
                buffer.put(rowData.getBytes());
            }
            // 切换ByteBuffer为读模式
            buffer.flip();
            // 写入文件
            channel.write(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void exportToExcel2(String[][] data, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // 创建Excel文件头
            String excelHeader = "Name\tAge\tGender\n";
            // 写入文件头
            writer.write(excelHeader);
            // 遍历数据数组，将每行数据写入文件
            for (String[] row : data) {
                String rowData = String.join("\t", row) + "\n";
                writer.write(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[][] data ={{"1","2","3"},{"4","5","6"}};
        exportToExcel(data,"D:\\sun\\测试.xlsx");
    }

}
