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

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.fastjson.JSON;
import com.sgt.bo.DiseaseMedicareRelaImportBO;
import com.sgt.bo.TestBO;
import com.sgt.bo.TestBO2;
import com.sgt.util.MyDateUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

/**
 * TODO
 *
 * @author WEIYI
 * @version V1.0
 * @since 2021-12-21 13:52
 */
public class JTest {

    @Test
    public void test1() throws IOException {
        List<DiseaseMedicareRelaImportBO> list = new ArrayList<>();
        OutputStream outputStream = new FileOutputStream("C:\\Users\\WEIYI\\Desktop\\新建文件夹\\test.xlsx");
        int[] mergeColumnIndex = { 0, 1, 2, 5 };
        Integer[] mergeRowIndex = { 1,2,3,4,5 };
        ExcelFillCellMergeStrategy excelFillCellMergeStrategy = new ExcelFillCellMergeStrategy(mergeRowIndex,
            mergeColumnIndex);
        ExcelWriter excelWriter = EasyExcel.write(outputStream, DiseaseMedicareRelaImportBO.class)
            .excludeColumnFiledNames(DiseaseMedicareRelaImportBO.excludeColumnFiledNames())
            .excludeColumnFiledNames(DiseaseMedicareRelaImportBO.excludeColumnFiledNames2())
            .build();
        for (int i = 0; i < 5; i++) {
            DiseaseMedicareRelaImportBO book = new DiseaseMedicareRelaImportBO();
            book.setDiseaseCode(i + "");
            book.setMedicareDiseaseCode(i + "");
            book.setDiseaseName("海贼王" + i);
            book.setMedicareDiseaseName("海贼王" + i);
            book.setZfje("支付宝");
            book.setZfmc(new BigDecimal(1));

            list.add(book);
        }
        WriteSheet writeSheet = EasyExcel.writerSheet("结算记录").build();

        excelWriter.write(list, writeSheet);
        //        EasyExcel.write().registerWriteHandler(excelFillCellMergeStrategy)
        //        excelWriter.merge(0,0,4,5);
        excelWriter.finish();
        outputStream.close();
    }

    @Test
    public void test2() throws IOException {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list1.add(i);
        }
        List<Integer> list2= new ArrayList<>();
//        list2.add(3);
//        list2.add(6);
//        list2.add(7);
        for (int i = 0; i < 9; i++) {
            list2.add(i);
        }

        list1.removeAll(list2);
        System.out.println(list1);
    }
    @Test
    public void test3() throws IOException {
        TestBO a = new TestBO();
        a.setA(1);
        TestBO2 b = new TestBO2();
        a.setB(b);
        b.setA(1111);
        b.setB(22222);
        System.out.println(JSON.toJSONString(a));
    }

    @Test
    public void test4() throws IOException {
        List<TestBO> testBOList = new ArrayList<>();
        TestBO a = new TestBO();
        a.setA(1);
        testBOList.add(a);
        TestBO b = new TestBO();
        b.setA(2);
        testBOList.add(b);
        TestBO2 c = new TestBO2();
        c.setA(99999);
        testBOList.forEach(x->
            fill(x,c));
        System.out.println(testBOList);
    }
    @Test
    public void test5() throws IOException {
        TestBO a = new TestBO();
        a.setA(1);
        a.setC(3);
        TestBO b = new TestBO();
        BeanUtils.copyProperties(a,b);
        b.setC(4);
        System.out.println(JSON.toJSONString(b));
    }

    /**
     * easyExcel 测试多次写入
     * @throws IOException
     */
    @Test
    public void test6() throws IOException {
        List<DiseaseMedicareRelaImportBO> list = new ArrayList<>();
        OutputStream outputStream = new FileOutputStream("C:\\Users\\WEIYI\\Desktop\\新建文件夹\\test2.xlsx");
        ExcelWriter excelWriter = EasyExcel.write(outputStream, DiseaseMedicareRelaImportBO.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("数据上报统计").build();
        for (int i = 0;i<6;i++){
            for (int j = 0; j < 5; j++) {
                DiseaseMedicareRelaImportBO book = new DiseaseMedicareRelaImportBO();
                book.setDiseaseCode(i*j + "");
                book.setMedicareDiseaseCode(i*j + "");
                book.setDiseaseName("海贼王" + i*j);
                book.setMedicareDiseaseName("海贼王" + i*j);
                book.setZfje("支付宝");
                book.setZfmc(new BigDecimal(1).divide(BigDecimal.valueOf((j+1)),4, RoundingMode.HALF_EVEN));

                list.add(book);
            }
            excelWriter.write(list, writeSheet);
        }
        excelWriter.finish();
        outputStream.close();
    }

    private void fill(TestBO x, TestBO2 c) {
        x.setC(c.getA());
    }


    @Test
    public void test7() {
        List<String> list = new ArrayList<String>();          //实例,新建一个96条的list集合,将他平均分成几等份
        for (int i = 0; i < 12308; i++) {
            list.add(i + "");
        }
        List<List<String>> atList = subList2(list,10);
        System.out.println(atList);
    }

    @Test
    public void test() {
        Random random = new Random();
        for (int i = 0; i < 1; i++) {
            System.out.println(random.nextInt(10102));
        }
        System.out.println(MyDateUtils.format(new Date(), MyDateUtils.FORMAT_YMDHMS_SHORT));
        System.out.println(MyDateUtils.parse("2022-07-1 00:00:00", MyDateUtils.FORMAT_YMDHMS_SHORT));
        System.out.println(MyDateUtils.parse("2022-07-9 00:00:00", MyDateUtils.FORMAT_YMDHMS_SHORT));
        System.out.println(MyDateUtils.parse("2022-07-10 00:00:00", MyDateUtils.FORMAT_YMDHMS_SHORT));
        System.out.println(MyDateUtils.parse("2022-07-31 00:00:00", MyDateUtils.FORMAT_YMDHMS_SHORT));
    }

    public static <T> List<List<T>> subList2(List<T> list, int pages) {
        List<List<T>> subList = new ArrayList<>();
        if (list == null || list.size() == 0) {
            return subList;
        }
        List<T> sub = null;
        //取每页数量
        int nums = list.size() / pages;
        //取多出来的数量
        int remain = list.size() % pages;


        for (int i = 0; i < pages; i++) {
            if (i < remain) {
                sub = list.subList(i * (nums + 1), (i + 1) * (nums + 1));
            } else {
                sub = list.subList((i - remain) * nums + remain * (nums + 1),
                    Math.min(((i - remain + 1) * nums + remain * (nums + 1)), list.size()));
            }
            subList.add(sub);
        }
        return subList;
    }
}
