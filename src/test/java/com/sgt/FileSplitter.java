package com.sgt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * 文本文件切割工具
 * 将一个大文件按固定行数分割成多个小文件
 */
public class FileSplitter {

    /**
     * 切割文件
     *
     * @param inputFile     源文件
     * @param outputDir     输出目录（如果不存在会自动创建）
     * @param linesPerFile  每个小文件包含的行数
     * @throws IOException 读写异常
     */
    public static void splitFile(File inputFile, String outputDir, int linesPerFile) throws IOException {
        if (!inputFile.exists() || !inputFile.isFile()) {
            throw new IllegalArgumentException("输入文件不存在或不是普通文件");
        }
        if (linesPerFile <= 0) {
            throw new IllegalArgumentException("每份行数必须大于 0");
        }

        File outDir = new File(outputDir);
        if (!outDir.exists()) {
            if (!outDir.mkdirs()) {
                throw new IOException("无法创建输出目录: " + outputDir);
            }
        }

        // 获取文件基本名和扩展名
        String fileName = inputFile.getName();
        int dotIndex = fileName.lastIndexOf('.');
        String baseName = dotIndex > 0 ? fileName.substring(0, dotIndex) : fileName;
        String extension = dotIndex > 0 ? fileName.substring(dotIndex) : "";

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8))) {

            String line;
            int lineCount = 0;
            int fileIndex = 1;
            BufferedWriter writer = null;

            while ((line = reader.readLine()) != null) {
                // 当 lineCount 能被 linesPerFile 整除时，创建新的输出文件
                if (lineCount % linesPerFile == 0) {
                    if (writer != null) {
                        writer.close();
                    }
                    String partName = String.format("%s-part-%d%s", baseName, fileIndex, extension);
                    File partFile = new File(outDir, partName);
                    writer = new BufferedWriter(
                            new OutputStreamWriter(new FileOutputStream(partFile), StandardCharsets.UTF_8));
                    fileIndex++;
                }
                writer.write(line);
                writer.newLine();
                lineCount++;
            }

            // 关闭最后一个文件
            if (writer != null) {
                writer.close();
            }

            System.out.printf("切割完成！共切割为 %d 个文件，保存在 %s 目录下。%n", fileIndex - 1, outputDir);
        }
    }

    /**
     * 使用示例
     */
    public static void main(String[] args) {
        try {
            // 参数：源文件路径，输出目录，每份行数
            splitFile(new File("D:\\Intellij\\sgtSpringBootDemo\\src\\test\\java\\com\\sgt\\dsfls.txt"), "D:\\sun\\ouput", 5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}