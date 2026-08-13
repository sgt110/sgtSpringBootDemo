package com.sgt.util;

import javax.imageio.ImageIO;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class GenerateImageWithTable {
    public static void main(String[] args) {
        int width = 800;
        int height = 600;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        // 设置背景颜色
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        // 设置表格边框颜色和线条粗细
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));

        // 绘制表格
        int rowCount = 5;
        int colCount = 4;
        int cellWidth = width / colCount;
        int cellHeight = height / rowCount;
        for (int i = 0; i <= rowCount; i++) {
            g2d.drawLine(0, i * cellHeight, width, i * cellHeight);
        }
        for (int j = 0; j <= colCount; j++) {
            g2d.drawLine(j * cellWidth, 0, j * cellWidth, height);
        }

        // 在表格中添加文字
        g2d.setFont(new Font("Arial", Font.PLAIN, 20));
        g2d.setColor(Color.BLACK);
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < colCount; c++) {
                g2d.drawString("Cell " + r + "," + c, c * cellWidth + 10, (r + 1) * cellHeight - 10);
            }
        }

        g2d.dispose();

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(image, "png", baos);
            baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
