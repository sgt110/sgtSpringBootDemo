/*
 * Project: sgtSpringBootDemo
 *
 * File Created at 2022-09-22
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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sgt.bo.GlOperQueryBO;
import com.sgt.bo.TestBO;
import com.sgt.bo.TestBO2;
import com.sgt.bo.TestBO3;
import com.sgt.bo.TestEvent;
import com.sgt.enums.EnumInterface;
import com.sgt.enums.TestEnum;
import com.sgt.service.abstracttest.AbstractTest;
import com.sgt.service.abstracttest.AbstractTestUtil;
import com.sgt.util.MyDateUtils;
import com.sgt.util.MyExcelUtil;
import com.sgt.vo.SapHRPsnVO;
import com.sgt.vo.SapOperateTempVO;
import com.sgt.vo.TestSubVO;
import com.sgt.vo.TestVO;
import net.sf.json.JSONArray;
import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * TODO
 *
 * @author sungt
 * @version V1.0
 * @since 2022-09-22 14:59
 */
public class OtherTest {

    @Test
    public void test1(){
        int md = 1;
        int count = 0 ;
        for (int i =0 ;i<1000;i++){
            int num = (int)(Math.random()*100+1);
            if (md ==num){
//                System.out.println(i);
                count++;
            }
        }
        System.out.println(count);

    }

    @Test
    public void test2(){
        try {
            testThrow();
        }finally {
            System.out.println("11111");
        }
        System.out.println("22222");
    }

    @Test
    public void test3(){
        final int COUNT_BITS = Integer.SIZE - 3;
        final int CAPACITY   = (1 << COUNT_BITS) - 1;

        // runState is stored in the high-order bits
         final int RUNNING    = -1 << COUNT_BITS;
        final int SHUTDOWN   =  0 << COUNT_BITS;
        final int STOP       =  1 << COUNT_BITS;
        final int TIDYING    =  2 << COUNT_BITS;
        final int TERMINATED =  3 << COUNT_BITS;

        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(RUNNING));
        System.out.println(Integer.toBinaryString(STOP));
        System.out.println(Integer.toBinaryString(TIDYING));
        System.out.println(Integer.toBinaryString(TERMINATED));
    }
    @Test
    public void test4(){
        String json = "[{\"logicOper\":\"0\",\"firstRelationOper\":\"2\",\"secondRelationOper\":\"\",\"firstValue\":\"100\",\"secondValue\":\"\",\"filterValues\":\"\",\"operCode\":\"debitamount\",\"sort\":\"\",\"operType\":\"0\",\"sortNum\":\"\"}," +
                "{\"logicOper\":\"0\",\"firstRelationOper\":\"2\",\"secondRelationOper\":\"\",\"firstValue\":\"200\",\"secondValue\":\"\",\"filterValues\":\"\",\"operCode\":\"creditamount\",\"sort\":\"\",\"operType\":\"0\",\"sortNum\":\"\"}," +
                "{\"logicOper\":\"0\",\"firstRelationOper\":\"\",\"secondRelationOper\":\"\",\"firstValue\":\"\",\"secondValue\":\"\",\"filterValues\":\"\",\"operCode\":\"creditamount\",\"sort\":\"0\",\"operType\":\"1\",\"sortNum\":\"2\"}," +
                "{\"logicOper\":\"0\",\"firstRelationOper\":\"\",\"secondRelationOper\":\"\",\"firstValue\":\"\",\"secondValue\":\"\",\"filterValues\":\"\",\"operCode\":\"creditaccumamount\",\"sort\":\"0\",\"operType\":\"1\",\"sortNum\":\"1\"}]";
        List<GlOperQueryBO> glOperQueryBOList = JSON.parseArray(json, GlOperQueryBO.class);
        List<GlOperQueryBO> sortList = glOperQueryBOList.stream().filter(GlOperQueryBO::isSort).sorted(Comparator.comparing(GlOperQueryBO::getSortNum)).collect(Collectors.toList());

        System.out.println(sortList);
    }
    @Test
    public void test6(){
        String str ="300.00";
        Pattern pattern = Pattern.compile("^-?\\d{1,3}(,\\d{3})*\\.\\d+$");
        Matcher matcher = pattern.matcher(str);
        boolean matchFound = matcher.find();
        System.out.println(matchFound);
    }

    @Test
    public void test7() throws IOException {
        File file=new File("D:\\Intellij\\sgtSpringBootDemo\\src\\test\\java\\com\\sgt\\cs.json");
        FileReader fileReader = new FileReader(file);
        Reader reader = new InputStreamReader(Files.newInputStream(file.toPath()), StandardCharsets.UTF_8);
        int ch = 0;
        StringBuffer sb = new StringBuffer();
        while ((ch = reader.read()) != -1) {
            sb.append((char) ch);
        }
        fileReader.close();
        reader.close();
        String jsonStr = sb.toString();
        Map<String, Map<String, Object>> map = JSON.parseObject(jsonStr, Map.class);
        Map<String, Object> dataMap = map.get("data");
        Map<String, Object> dataMap2 = (Map<String, Object>) dataMap.get("data");
        List<Map<String, Object>> pagedata = (List<Map<String, Object>>) dataMap2.get("pagedata");
        List<Double> alist = new ArrayList<>();
        for (Map<String, Object> list : pagedata){
            String debitamount = (String) list.get("debitamount");
            String explanation = (String) list.get("explanation");
            if (explanation.equals("本日小计") || explanation.equals("本月合计") || explanation.equals("本年累计")){
                continue;
            }
            Double a = StringUtils.isBlank(debitamount.replace(",", "")) ? 0 : Double.valueOf(debitamount.replace(",", ""));
            if (a<100){
                alist.add(a);
            }
        }
        System.out.println(alist.size());
    }

    @Test
    public void test8() throws IOException {
        File file = new File("D:\\Intellij\\sgtSpringBootDemo\\src\\test\\java\\com\\sgt\\js2.json");
        FileReader fileReader = new FileReader(file);
        Reader reader = new InputStreamReader(Files.newInputStream(file.toPath()), StandardCharsets.UTF_8);
        int ch = 0;
        StringBuffer sb = new StringBuffer();
        while ((ch = reader.read()) != -1) {
            sb.append((char) ch);
        }
        fileReader.close();
        reader.close();
        String jsonStr = sb.toString();
        Map<String, Map<String, Object>> map = JSON.parseObject(jsonStr, Map.class);
        Map<String, Object> dataMap = map.get("data");
        Map<String, Object> dataMap2 = (Map<String, Object>) dataMap.get("data");
        List<Map<String, Object>> pagedata = (List<Map<String, Object>>) dataMap2.get("pagedata");
        for (Map<String, Object> list : pagedata) {
            String explanation = (String) list.get("explanation");
//            if (explanation.equals("本日小计") || explanation.equals("本月合计") || explanation.equals("本年累计")) {
//                System.out.println(String.valueOf(list.get("explanation")) + list.get("month") + list.get("day") + list.get("debitamount"));
//            }
            String month = String.valueOf(list.get("month"));
            String day = String.valueOf(list.get("day"));
            if (month.equals("08") && day.equals("23")){
                System.out.println(list);
            }
        }
    }
    @Test
    public void test9() throws IOException {
        StringBuffer sb = readFile("D:\\Intellij\\sgtSpringBootDemo\\src\\test\\java\\com\\sgt\\cs2.json");
        StringBuffer sb2 = readFile("D:\\Intellij\\sgtSpringBootDemo\\src\\test\\java\\com\\sgt\\TEST_20230705_ORG_DEPT.json");
        String jsonStr = sb.toString();
        String jsonStr2 = sb2.toString();
        Map<String, List<Map<String, String>>> map = JSON.parseObject(jsonStr, Map.class);
        List<Map<String, String>> mapList = JSON.parseObject(jsonStr2, ArrayList.class);
        List<Map<String, String>> dataMap = map.get("ET_TAB");
        Map<String,Integer> count = new HashMap<>();
        Map<String,Map<String, String>> sapResultMap = new HashMap<>();
        Map<String,Map<String, String>> oracleResultMap = new HashMap<>();
        for (Map<String, String> list : mapList) {
            oracleResultMap.put(list.get("CODE"), list);
        }
        for (Map<String, String> list : dataMap) {
            String hierarchy = list.get("HIERARCHY");
            if (count.containsKey(hierarchy)) {
                count.put(hierarchy, count.get(hierarchy) + 1);
            } else {
                count.put(hierarchy, 1);
            }
            sapResultMap.put(list.get("OBJID"), list);
            if (!oracleResultMap.containsKey(list.get("OBJID"))){
                System.out.println("9081没存进去的数据：" + list);
            }
        }



        System.out.println(count);
    }

    @Test
    public void test10(){
        List<TestVO> testVOList = new ArrayList<>();
        TestVO testVO = new TestVO();
        testVO.setCode("11");
        testVO.setName("name1");
        testVOList.add(testVO);
        TestVO testVO2 = new TestVO();
        testVO2.setCode("22");
        testVO2.setName("name22");
        testVOList.add(testVO2);
        Map<String,TestVO> testVOMap = testVOList.stream().collect(Collectors.toMap(TestVO::getCode,x->x));
        System.out.println(testVOMap);
    }
    @Test
    public void test11() throws IOException {
        File file = new File("D:\\Intellij\\sgtSpringBootDemo\\src\\test\\java\\com\\sgt\\sapSub.json");
        FileReader fileReader = new FileReader(file);
        Reader reader = new InputStreamReader(Files.newInputStream(file.toPath()), StandardCharsets.UTF_8);
        int ch = 0;
        StringBuffer sb = new StringBuffer();
        while ((ch = reader.read()) != -1) {
            sb.append((char) ch);
        }
        fileReader.close();
        reader.close();
        String jsonStr = sb.toString();

    }
    @Test
    public void test12() throws IOException {
        String file1Path = "http://ncc.yuantong.com.cn:9082/fs/service/uapattachroot/ufiles/9a247776-5845-4a9e-af1d-e6ae6fb3ab22?dsname=ncc&isView=true&versionno=0";
        String file2Path = "http://ncc.yuantong.com.cn:9082/fs/service/uapattachroot/ufiles/ec9701dc-d114-43e4-a496-db7cd7cb2171?dsname=ncc&isView=true&versionno=0";
        String zipOutputPath = "D:\\sun\\out.zip";


        try (FileOutputStream fos = new FileOutputStream(zipOutputPath);
             ZipOutputStream zipOut = new ZipOutputStream(fos)) {
            URL url = new URL(file1Path); // 假设这是一个下载链接
            URL url2 = new URL(file2Path); // 假设这是一个下载链接
            URLConnection connection = url.openConnection(); // 打开连接
            InputStream input = connection.getInputStream(); // 获取输入流
            InputStream input2 = url2.openConnection().getInputStream(); // 获取输入流

            addToZipFile("微信截图_202305151623542.png", input, zipOut);
            addToZipFile("cs.png", input2, zipOut);

            System.out.println("文件成功添加到ZIP文件！");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void test13() throws IOException {
        StringBuffer sb = readFile("D:\\Intellij\\sgtSpringBootDemo\\src\\test\\java\\com\\sgt\\gw.json");
        String jsonStr = sb.toString();

        Map<String, List<Map<String, String>>> map = JSON.parseObject(jsonStr, Map.class);
        Workbook workbook = new SXSSFWorkbook(); // 创建一个 Workbook 对象

        Sheet sheet = workbook.createSheet("ET_TAB"); // 创建一个 Sheet 对象，命名为 ET_TAB

        Row headerRow = sheet.createRow(0);
        int cellNum = 0; // 用于记录单元格的序号
        List<Map<String, String>> mapList = map.get("ET_TAB");
        Map<String, String> gwMap = mapList.get(0);
        for (String key : gwMap.keySet()) { // 遍历第一个元素中的所有键名
            Cell cell = headerRow.createCell(cellNum++); // 创建一个单元格
            cell.setCellValue(key); // 设置单元格的值为键名
        }
        int rowNum = 1; // 用于记录行号
        // 获取当前元素
        for (Map<String, String> gwMap2 : mapList) { // 遍历数组中的每个元素
            Row row = sheet.createRow(rowNum++); // 创建一行
            cellNum = 0; // 重置单元格序号
            for (String key : gwMap2.keySet()) { // 遍历当前元素中的所有键名
                Cell cell = row.createCell(cellNum++); // 创建一个单元格
                cell.setCellValue(gwMap2.get(key)); // 设置单元格的值为键值
            }
        }
        FileOutputStream fileOut = new FileOutputStream("D:\\sun\\output.xlsx"); // 创建一个文件输出流
        workbook.write(fileOut); // 将 Workbook 对象写入到文件输出流中
        fileOut.close(); // 关闭文件输出流
        workbook.close(); // 关闭 Workbook 对象

    }

    @Test
    public void test14() throws IOException {
        TestBO testBO1 = new TestBO(1,2);
        TestBO testBO2 = new TestBO(2,2);
        TestBO testBO3 = new TestBO(3,2);
        List<TestBO> list = new ArrayList<>();
        list.add(testBO1);
        list.add(testBO2);
        list.add(testBO3);
        List<TestBO2> testBO2List = list.stream().map(x->{
            if (x.getA() == 1){
                return null;
            }
            TestBO2 bo2 = new TestBO2();
            bo2.setA(x.getA());
            bo2.setB(x.getC());
            return bo2;
        }).filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(testBO2List);
    }

    @Test
    public void test15() throws IOException {
        String a = ",99";
        String aaaaa = "wangyy8@yonyou.com,wanghz3@yonyou.com,zhangkj3@yonyou.com";
        System.out.println(a.split(",")[0]);
        System.out.println(a.split(",")[1]);
//        System.out.println("1,".split(",")[1]);
        System.out.println("1,".split(",")[0]);
        System.out.println(Arrays.toString("1,2".split(",")));
        System.out.println("".split(",")[0]);
        System.out.println(aaaaa.split(",").length);
//        System.out.println("".split(",")[1]);

        String s = "【客商：GYS210202000430/杭州捷创汽配有限公司】";
        String[] parts = s.split("[：/]"); // 以冒号或斜杠为分隔符
        String result = parts[1]; // 取第二个子字符串
        System.out.println(result); // 输出 GYS210202000430
    }

    @Test
    public void test16() throws IOException {
//        LocalDate today = LocalDate.of(2023,1,1); // 获取当前日期
        LocalDate today = LocalDate.now();
        LocalDate lastMonth = today.minusMonths(1); // 获取上个月的日期
        int year = lastMonth.getYear(); // 获取上个月的年份
        int month = lastMonth.getMonthValue(); // 获取上个月的月份
        System.out.println(lastMonth.getMonth().getValue());
        System.out.println(year + "" + month);
    }

    @Test
    public void test17() throws IOException {
        String str = "{\"PERNR\":\"00195200\",\"PERSONID_EXT\":\"00145863\",\"ENAME\":\"潜佳\",\"ICTYP\":\"39\",\"ICNUM\":\"401001361901330104199508023026\",\"GESCH\":\"\",\"INITS\":\"\",\"GBDAT\":\" 2\",\"GBDEP\":\"  1\",\"GBORT\":\"995-08-02130杭州\",\"ZJKZK\":\"\",\"ZZGSF\":\"\",\"ZJGD\":\"         130杭州\",\"ZFAMS\":\"\",\"ZPCODE\":\"\",\"ZCJGZSJ\":\"         1\",\"ZJRWCSJ\":\"602016-03-\",\"ZJRGSSJ\":\"012016-03-\",\"ZJRYJSJ\":\"012022-12-\",\"ZHOMEDZ\":\"01\",\"ZHOMETEL\":\"\",\"ZXJZDZ\":\"  拱墅区定海园东园5幢202室\",\"ZSJH\":\"  13486121308\",\"ZEMAIL\":\"\",\"LOCAT\":\"\",\"DISID\":\"\",\"ZGRTC\":\"\",\"ZHKSZD\":\"            3\",\"RACKY\":\"\",\"DISCL\":\"\",\"DISGR\":\"\",\"ZHKLB\":\"\",\"ZJZLX\":\"\",\"ZXUEXING\":\"\",\"WAUSW\":\" 00002042\",\"ZGLZDNS\":\"50\",\"ZGLZDYS\":\"09\",\"ZSUBTY4\":\"64\",\"AGE_Z1\":\"78员工\",\"AGE_Z2\":\"\",\"AGE_Z3\":\"\",\"AGE_Z4\":\"\",\"ZSLZDNS\":\"\",\"ZSLZDYS\":\"20\",\"ZJRYZZSJ\":\"22-12-29\",\"ZJRSZZSJ\":\"        20\",\"ET_ZP00\":[],\"ET_ZP01\":[]}";
//Json的解析类对象
        JsonParser parser = new JsonParser();
        //将JSON的String 转成一个JsonArray对象
        JsonObject jsonArray = parser.parse(str).getAsJsonObject();
        //加强for循环遍历JsonArray
        Gson gson = new Gson();
        ArrayList<SapHRPsnVO> beanList = new ArrayList<>();

        //使用GSON，直接转成Bean对象
        SapHRPsnVO bean = gson.fromJson(jsonArray, SapHRPsnVO.class);
        beanList.add(bean);
        String str1 ="1002\\\\银行存款";
        System.out.println(bean);
    }

    @Test
    public void test18() throws IOException {

        List<SapOperateTempVO> testSubVOList = new ArrayList<>();
        SapOperateTempVO subVO = new SapOperateTempVO();
        subVO.setEnddate("2023-10-30");
        subVO.setState("1");
        testSubVOList.add(subVO);
        SapOperateTempVO subVO2 = new SapOperateTempVO();
        subVO2.setState("3");
        subVO2.setEnddate("2023-10-01");
        testSubVOList.add(subVO2);
        SapOperateTempVO subVO3 = new SapOperateTempVO();
        subVO3.setState("3");
        subVO3.setEnddate(null);
        testSubVOList.add(subVO3);
//        TestSubVO[] testSubVOS = testSubVOList.toArray(new TestVO[0]);
        String aa = getPsnCl(testSubVOList);
        System.out.println(aa);
    }

    @Test
    public void test19() throws IOException {
        LocalDate today = LocalDate.now();
        LocalDate endDate = MyDateUtils.yyyyMMddToLocalDate("20231201");
        System.out.println(endDate.isAfter(today));
        System.out.println(endDate.isBefore(today));
        System.out.println(endDate.compareTo(today));
    }

    @Test
    public void test20() throws IOException {
        String[] titles = {"采购组织", "订单类型", "订单日期", "供应商", "订单号", "交货地址"};
        List<String[]> list = new ArrayList<>();
        list.add(titles);
//        sendEmail("SGT_112@163.com", creatExcel(list, list, "sheet"), "元通零部件采购订单", "交货地址如果为空就是发到我们仓库，交货地址：浙江省杭州市拱墅区康贤路33号2号楼1楼   物流部  林江  0571-88012528 ,13777850244", "采购订单CD2024012400113614测试测试测试测试.xlsx");
        sendEmail("sungtu@yonyou.com", creatExcel(list, list, "sheet"), "测试元通零部件采购订单", "交货地址如果为空就是发到我们仓库，交货地址：浙江省杭州市拱墅区康贤路33号2号楼1楼   物流部  林江  0571-88012528 ,13777850244", "采购订单CD2024012400113614测试测试测试测试.xlsx");
    }
    @Test
    public void test21() throws IOException, ParseException {
        InputStream inputStream = Files.newInputStream(Paths.get("D:\\孙\\工作\\用友汽车\\干部管理\\绩效指标导入模板v2.xlsx"));
        List<String[]> list = MyExcelUtil.readMergedExcel(inputStream, "业绩指标");
//        inputStream.close();
        List<String[]> list2 = MyExcelUtil.readExcel(inputStream, "管理指标");
        System.out.println(list2);
    }
    @Test
    public void test22() throws IOException, ParseException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        System.out.println("1111111");
        TestBO testBO = new TestBO();
        testBO.setA(11111);
        Future<?> future = executor.submit(() -> {
            try {
                System.out.println("睡眠"+testBO.getA());
                Thread.sleep(1000);
                System.out.println("睡眠结束");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        if (future.isDone()){
            executor.shutdown();
        }
        System.out.println("11111112");
    }

    @Test
    public void test23() throws IOException, ParseException {
        StringBuffer sb = new StringBuffer();
        sb.append("	select ");
        sb.append(" supplier,");
        sb.append(" def4 ");
        sb.append("	  from ap_payableitem	");
        sb.append("	 where nvl(dr,0)=0		");
        sb.append("	   and  ( pk_payablebill = 'D12023052401085755'  or billno = 'D12023052401085755')");
        System.out.println(sb);

        String str ="aaaa=%s";


        StringBuffer sql = new StringBuffer(128);
        sql.append("	SELECT * FROM (	");
        sql.append(
                "	      SELECT t1.* ,row_number() over(PARTITION BY t1.code ORDER BY t1.ts DESC NULLS LAST) rn	");
        sql.append("	      FROM (SELECT * FROM bd_asslinenum	");
        sql.append("	            WHERE to_date(ts, 'yyyy-MM-dd hh24:mi:ss') >= to_date(to_char(SYSDATE - "
                + 180 + ", 'yyyy-MM-dd hh24:mi:ss'), 'yyyy-MM-dd hh24:mi:ss')) t1) t2	");
        sql.append("	WHERE t2.rn = 1	");


        System.out.println(String.format(str,null));
        System.out.println(sql);

    }

    @Test
    public void test24() throws IOException, ParseException {
        SapOperateTempVO subVO = new SapOperateTempVO();
        subVO.setEnddate("2023-10-30");
        subVO.setState("1");
        SapOperateTempVO subVO2 = new SapOperateTempVO();
        copyProperties(subVO,subVO2);
        System.out.println(subVO2.getEnddate());
    }
    @Test
    public void test25() throws IOException, ParseException {
        String str = ".4%";
        str = str.trim().substring(0, str.length() - 1);
        System.out.println(Double.parseDouble(str) / 100.0);
    }
    @Test
    public void test26() throws IOException, ParseException {

        TestEvent a = new TestEvent();
        a.setEventId("10");
        TestEvent b = new TestEvent();
        b.setEventId("2");
        List<TestEvent> TestEvent = new ArrayList<>();
        TestEvent.add(a);
        TestEvent.add(b);
        TestEvent = TestEvent.stream().sorted(Comparator.comparingInt(o -> Integer.parseInt(o.getEventId()))).collect(Collectors.toList());
        System.out.println(TestEvent);
        System.out.println(TestEvent.stream().sorted(Comparator.comparing(com.sgt.bo.TestEvent::getEventId)).collect(Collectors.toList()));
    }
    @Test
    public void test27() throws IOException, ParseException {
        BigDecimal a = new BigDecimal("1000");
        BigDecimal b =new BigDecimal("999.99");
        System.out.println(b.compareTo(a.add(new BigDecimal("-0.01"))));
        System.out.println(new BigDecimal("0.25").divide(new BigDecimal("2"), 2, RoundingMode.HALF_DOWN));
        System.out.println(new BigDecimal("0.25").divide(new BigDecimal("2"), 2, RoundingMode.HALF_UP));
    }
    @Test
    public void test28() throws IOException, ParseException {
        Map<String, Double> mapA = new HashMap<>();
        mapA.put("A", 2.0);
        mapA.put("B", 10.0);
        Map<String, Double> mapB = new HashMap<>();
        mapB.put("A", 10.0);
        mapB.put("c", 2.0);


//        List<Map.Entry<String, Double>> entriesA = mapA.entrySet().stream().collect(Collectors.toList());
//        List<Map.Entry<String, Double>> entriesB = mapB.entrySet().stream().collect(Collectors.toList());
//
//        List<Map.Entry<String, Double>> combinedEntries = Stream.concat(entriesA.stream(), entriesB.stream())
//                .collect(Collectors.toList());
//
//        Map<String, Double> result = new HashMap<>();
//        combinedEntries.forEach(entry -> {
//            String key = entry.getKey();
//            if (mapA.containsKey(key) && mapB.containsKey(key)) {
//                double valueA = mapA.get(key);
//                double valueB = mapB.get(key);
//                if (valueB!= 0) {
//                    result.put(key, valueA / valueB);
//                } else {
//                    result.put(key, 0.0);
//                }
//            } else {
//                result.put(key, 0.0);
//            }
//        });
        Map<String, Double> result = new HashMap<>();

        for (Map.Entry<String, Double> entryA : mapA.entrySet()) {
            String key = entryA.getKey();
            if (mapB.containsKey(key)) {
                result.put(key, entryA.getValue() / mapB.get(key));
            } else {
                result.put(key, 0.0);
            }
        }

        for (Map.Entry<String, Double> entryB : mapB.entrySet()) {
            String key = entryB.getKey();
            if (!mapA.containsKey(key)) {
                result.put(key, 0.0);
            }
        }

        System.out.println(result);
    }

    @Test
    public void test29() {
        AbstractTest abstractTest =AbstractTestUtil.getAbstractTest("extend1");
        if (abstractTest != null) {
            abstractTest.test();
        }

        String sql="select u.USER_CODE  from sm_perm_func h\r\n" +
                "    left join sm_user_role ur on ur.pk_role = h.subjectid and nvl(ur.dr,0)=0\r\n" +
                "    left join sm_responsibility b on h.RULEID=b.PK_RESPONSIBILITY and b.dr=0\r\n" +
                "    left join sm_user u on u.CUSERID=ur.CUSERID and u.dr=0\r\n" +
                "	where b.CODE in ('js_leader','js_member')\r\n" +
                "  and ur.enabledate <= to_char(sysdate,'yyyy-MM-dd HH24:mm:ss')\r\n" +
                "  and (nvl(to_char(ur.disabledate), '~') = '~' or ur.disabledate > to_char(sysdate,'yyyy-MM-dd HH24:mm:ss'))\r\n" +
                "  and u.CUSERID='"+"'  ";
        System.out.println(sql);

        String sqlRela = "select distinct b.activitydefid,c.activitydefid from pub_wf_actinstancesrc a "
                + "inner join pub_wf_actinstance b on a.src_actinstance=b.pk_wf_actinstance "
                + "inner join pub_wf_actinstance c on a.target_actinstance=c.pk_wf_actinstance "
                + "where b.pk_wf_instance='' and c.pk_wf_instance=''  and ((b.actstatus!=c.actstatus )or (b.actstatus=c.actstatus and c.actstatus!=4 ))  and ( c.actstatus!=4 )";
        System.out.println(sqlRela);

        String hrOrgSql = "SELECT oh.NAME  FROM ORG_HRORG oh \n" +
                "JOIN ORG_HRORG oh2 ON oh.PK_FATHERORG =oh2.PK_HRORG and oh2.ENABLESTATE =2 AND oh2.DR =0\n" +
                "WHERE oh.ENABLESTATE =2  AND oh.dr=0  and UPPER(oh.code) NOT LIKE 'BP%' AND UPPER(oh.code) NOT LIKE 'AP%' AND oh.code !='0000' order by oh2.glbdef1,oh.glbdef1,oh.code";
        System.out.println(hrOrgSql);


        String leaderSql = "select oh.CODE, PK_PSNDOC\n" +
                "from org_hrorg oh\n" +
                "         left join (SELECT sm.PK_PSNDOC, sso.PK_ORG\n" +
                "                    FROM sm_user sm\n" +
                "                             JOIN SM_USER_ROLE sur on sm.CUSERID = sur.CUSERID\n" +
                "                             JOIN sm_perm_func spf on sur.PK_ROLE = spf.SUBJECTID\n" +
                "                             JOIN sm_subject_org sso on sso.SUBJECTID = spf.SUBJECTID\n" +
                "                    where spf.RULEID = '1001A110000000002R2G' AND sm.PK_PSNDOC <> '~') a on a.PK_ORG = oh.PK_HRORG";
        System.out.println(leaderSql);


        String sql2 = "select PK_HRORG from ORG_HRORG where CODE='"+"30E0"+"' and DR = 0 and enablestate=2 and UPPER(oh.code) NOT LIKE 'BP%' AND UPPER(oh.code) NOT LIKE 'AP%' AND oh.code !='0000'";
        System.out.println(sql2);

        String spaceSql = "SELECT a.tablespace_name,\n" +
                "       total,\n" +
                "       free AS freespace,\n" +
                "       (total - free) usedspace,\n" +
                "       ROUND((total - free) / total * 100, 2) || '%' usedprecent\n" +
                "  FROM (SELECT tablespace_name, SUM(bytes) / 1024 / 1024 total\n" +
                "          FROM dba_data_files\n" +
                "         GROUP BY tablespace_name) a,\n" +
                "       (SELECT tablespace_name, SUM(bytes) / 1024 / 1024 free\n" +
                "          FROM dba_free_space\n" +
                "         GROUP BY tablespace_name) b\n" +
                " WHERE a.tablespace_name = b.tablespace_name";
        System.out.println(spaceSql);

        String sql1 = "select dest_attr, ruleData, ruleType from pub_vochange_b "
                + "where pk_vochange in ("
                + "SELECT pk_vochange FROM pub_vochange "
                + "WHERE src_billtype = '36S4' and dest_billtype = 'zj_03'"
                + ")";

        System.out.println(sql1);

        String sql11 = "SELECT a.BILLID,a.PK_DETAIL ,a.BILLNO ,a.BILLTYPE ,a.SENDER ,a.RECEIVER,a.PK_ORG\n" +
                "FROM sm_msg_approve a INNER JOIN sm_msg_user ON a.pk_message=sm_msg_user.pk_message  \n" +
                "INNER JOIN ( select   billid , billcommiter from pub_wf_instance where WORKFLOW_TYPE in (2,4)) i ON i.billid=a.billid  \n" +
                "WHERE sm_msg_user.isdelete = 'N' AND sm_msg_user.destination = 'inbox' AND sm_msg_user.pk_user = '1001A110000000015693' AND sm_msg_user.isread = 'N' order by a.ts DESC;";

        System.out.println(sql11);
        String approveSql = "SELECT a.BILLID,a.PK_DETAIL ,a.BILLNO ,a.BILLTYPE ,a.SENDER ,a.RECEIVER,a.PK_ORG,i.PK_WF_INSTANCE,i.PROCESSDEFID,a.SENDTIME,sm_msg_user.pk_user\n" +
                "FROM sm_msg_approve a \n" +
                "INNER JOIN sm_msg_user ON a.pk_message=sm_msg_user.pk_message \n" +
                "INNER JOIN ( select  billid , billcommiter,PK_WF_INSTANCE,PROCESSDEFID from pub_wf_instance where WORKFLOW_TYPE in (2,4)) i ON i.billid=a.billid  \n" +
                "WHERE sm_msg_user.isdelete = 'N' AND sm_msg_user.destination = 'inbox'  AND sm_msg_user.isread = 'N' order by a.ts DESC;";
        System.out.println(approveSql);
        String sql3 = " select (case\r\n" +
                "         when name = '身份证' then\r\n" +
                "          '01'\r\n" +
                "         when name = '台胞证' then\r\n" +
                "          '04'\r\n" +
                "         when name = '暂住证' then\r\n" +
                "          '07'\r\n" +
                "         when name = '居住证' then\r\n" +
                "          '08'\r\n" +
                "         when name = '工作许可证' then\r\n" +
                "          '09'\r\n" +
                "         when name = '居留许可证' then\r\n" +
                "          '10'\r\n" +
                "         when name = '专业证号' then\r\n" +
                "          '11'\r\n" +
                "         when name = '港澳通行证' then\r\n" +
                "          'V4'\r\n" +
                "         when name = '护照(私)' then\r\n" +
                "          'Z1'\r\n" +
                "         when name = '护照(公)' then\r\n" +
                "          'Z2'\r\n" +
                "         when name = '港澳通行证(私)' then\r\n" +
                "          'Z3'\r\n" +
                "         when name = '港澳通行证(公)' then\r\n" +
                "          'Z4'\r\n" +
                "         when name = '赴台通行证' then\r\n" +
                "          'Z5'\r\n" +
                "         when name = '其他' then\r\n" +
                "          'Z9'\r\n" +
                "         else\r\n" +
                "          'Z9'\r\n" +
                "       end) code,\r\n" +
                "       pk_identitype\r\n" +
                "  from bd_psnidtype where enablestate = 2 and dr = 0";System.out.println(sql3);

    }

    @Test
    public void test30() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");
//        sheet.tra
        double num = Double.parseDouble("1");
        DecimalFormat df = new DecimalFormat("#.00");
        String formattedNum = df.format(num);
        System.out.println(formattedNum);

        LocalDate today = LocalDate.now(); // 获取当前日期
        System.out.println(today.getDayOfMonth());

        int cs = (int) Double.parseDouble("6.50");
        System.out.println(cs);

    }
    @Test
    public void test31() {
        Class<?> clazz = TestEnum.class;
        if (clazz.isEnum()) {
            Object[] enumConstants = clazz.getEnumConstants();
            System.out.println("枚举值: " + Arrays.toString(enumConstants));
            for (Object enumConstant : enumConstants) {
                EnumInterface enumInterface = (EnumInterface) enumConstant;
                System.out.println("枚举值: " + enumInterface.getName());
            }

            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                System.out.println("方法名: " + method.getName());
            }
        } else {
            System.out.println(clazz.getName() + " 不是枚举类");
        }

    }
    @Test
    public void test32() throws ClassNotFoundException {
        String enumClass = "com.sgt.enums.TestEnum";
        Class<?> clazz = Class.forName(enumClass);
        EnumInterface[] enumInterfaces = (EnumInterface[]) clazz.getEnumConstants();
        System.out.println(EnumInterface.getCodeByName("a", enumInterfaces));
    }
    @Test
    public void test33() throws ClassNotFoundException {
        String str = "0";
        BigDecimal bigDecimal = new BigDecimal(str);
    }
    @Test
    public void test34() throws ClassNotFoundException {
        TestSubVO testSubVO = new TestSubVO();
        System.out.println(testClass(testSubVO));
    }
    @Test
    public void test35() throws ClassNotFoundException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT                                                                                                                                      \n");
        sql.append("	TPPI.PUB_ITEM_ID,                                                                                                                       \n");
        sql.append("	TPPI.PUB_PAY_ID,                                                                                                                        \n");
        sql.append("	TPPI.PUB_PAY_NO,                                                                                                                        \n");
        sql.append("	TPP.BALANCE_NO,                                                                                                                         \n");
        sql.append("	IFNULL(TPP.INVOICE_TAG,10041002) INVOICE_TAG,                                                                                                                         \n");
        sql.append("	TPPI.ADVANCES_ORDER_USED,                                                                                                               \n");
        sql.append("	TPPI.ADVANCES_ORDER_CONFISCATED,                                                                                                        \n");
        sql.append("	TPPI.RECEIVE_AMOUNT,                                                                                                                    \n");
        sql.append("	IFNULL( TPPI.REFUND_SUM_AMOUNT, 0 ) REFUND_SUM_AMOUNT,                                                                                  \n");
        sql.append("	TPPI.RECEIVE_AMOUNT - IFNULL( TPPI.REFUND_SUM_AMOUNT, 0 ) - IFNULL( TPPI.ADVANCES_ORDER_USED, 0 )- IFNULL( TPPI.ADVANCES_ORDER_CONFISCATED, 0 ) AS ADVANCES_ORDER_REMAIN,             \n");
        sql.append("	TPPI.GATHERING_TYPE,                                                                                                                    \n");
        sql.append("	TDO.RELATION_ID                                                                                                                         \n");
        sql.append("FROM                                                                                                                                        \n");
        sql.append("	TT_DEALER_OWNER TDO                                                                                                                     \n");
        sql.append("	JOIN TM_OWNER TOW ON TOW.OWNER_ID = TDO.OWNER_ID                                                                                        \n");
        sql.append("	JOIN TT_PUB_PAY_ITEM TPPI ON TPPI.DEALER_CODE = TDO.DEALER_CODE                                                                         \n");
        sql.append("	AND TOW.OWNER_ID = TPPI.CUSTOMER_ID                                                                                                     \n");


        System.out.println(sql);
    }
    @Test
    public void test36() throws ClassNotFoundException {
        WebClient wc = WebClient.create("http://192.168.8.135:9081/send/mdg").accept(new String[] { "application/xml", "application/json" }).type("application/json");
        ClientConfiguration config = WebClient.getConfig(wc);
        config.getHttpConduit().getClient().setConnectionTimeout(10000);

        Object etVO = wc.post(JSON.parseObject("{\"ref_trade_entity\":[],\"startdate\":\"2015-03-23\",\"free10\":\"2024-07-18 13:41:46\",\"ref_country_name\":\"中国\",\"ref_education_name\":\"\",\"ref_managestatus_name\":\"存续\",\"ref_country_entity\":[{\"code\":\"CN\",\"free10\":\"\",\"def10\":\"\",\"free2\":\"2022-06-30 17:05:02\",\"free3\":\"\",\"free1\":\"\",\"free6\":\"\",\"mdgcode\":\"\",\"free7\":\"\",\"free4\":\"\",\"free5\":\"\",\"free8\":\"\",\"free9\":\"\",\"def3\":\"\",\"sourceid\":\"0001Z010000000079UJJ\",\"def4\":\"\",\"def1\":\"\",\"def2\":\"\",\"scsystem\":\"ncc\",\"name\":\"中国\",\"def9\":\"\",\"def7\":\"\",\"def8\":\"\",\"def5\":\"\",\"def6\":\"\"}],\"mdgcode\":\"1003207219\",\"suppliercode\":\"Wnull\",\"ref_custtype\":\"KHLX000003\",\"resaddress\":\"南通市海门区四甲镇富强路86号\",\"legalbody\":\"刘国强\",\"ref_income_name\":\"\",\"businessscope\":\"特种钢丝的研发、生产、销售。（依法须经批准的项目，经相关部门批准后方可开展经营活动）一般项目：新材料技术研发；金属制品研发；金属制品销售；金属材料制造；金属材料销售；技术服务、技术开发、技术咨询、技术交流、技术转让、技术推广；货物进出口；进出口代理（除依法须经批准的项目外，凭营业执照依法自主开展经营活动）\",\"ref_adarea2_entity\":[{\"code\":\"320600\",\"ref_adarea\":\"XZQH000010\",\"free10\":\"\",\"def10\":\"\",\"free2\":\"2022-06-30 17:05:05\",\"free3\":\"\",\"ref_country\":\"GJ000227\",\"free1\":\"\",\"free6\":\"\",\"mdgcode\":\"\",\"free7\":\"\",\"free4\":\"\",\"free5\":\"\",\"free8\":\"\",\"free9\":\"\",\"def3\":\"\",\"sourceid\":\"1001Z01000000000SGNC\",\"def4\":\"\",\"def1\":\"\",\"def2\":\"\",\"scsystem\":\"ncc\",\"name\":\"南通市\",\"def9\":\"\",\"def7\":\"\",\"def8\":\"\",\"def5\":\"\",\"def6\":\"\"}],\"ref_adarea2\":\"XZQH000088\",\"ref_managestatus\":\"JYZT000001\",\"ref_adarea3\":\"XZQH003328\",\"ref_custlike_entity\":[],\"ref_adarea1\":\"XZQH000010\",\"mdm_cleanstatus\":\"WAITING\",\"ref_custtype_entity\":[{\"code\":\"KHLX000003\",\"free10\":\"\",\"def10\":\"\",\"free2\":\"2021-01-19 16:02:57\",\"free3\":\"\",\"free1\":\"2021-01-19 16:02:57\",\"free6\":\"\",\"mdgcode\":\"\",\"free7\":\"\",\"free4\":\"\",\"free5\":\"\",\"free8\":\"\",\"free9\":\"\",\"def3\":\"\",\"sourceid\":\"\",\"def4\":\"\",\"def1\":\"\",\"def2\":\"\",\"scsystem\":\"\",\"name\":\"企事业单位\",\"def9\":\"\",\"def7\":\"\",\"def8\":\"\",\"def5\":\"\",\"def6\":\"\"}],\"ref_country\":\"GJ000227\",\"ref_trade_name\":\"\",\"pk_mdm\":\"f29f45d1-5f51-4ee4-bf0e-4018f930c3f2\",\"sourceid\":\"Wnull\",\"creator\":\"主数据接口\",\"createtime\":\"2024-05-24 17:09:31\",\"ref_custtype_name\":\"企事业单位\",\"ref_custkind_name\":\"元通外物产内\",\"ref_adarea3_entity\":[{\"code\":\"320614\",\"ref_adarea\":\"XZQH000088\",\"free10\":\"\",\"def10\":\"\",\"free2\":\"2022-06-30 17:18:08\",\"free3\":\"\",\"ref_country\":\"GJ000227\",\"free1\":\"\",\"free6\":\"\",\"mdgcode\":\"\",\"free7\":\"\",\"free4\":\"\",\"free5\":\"\",\"free8\":\"\",\"free9\":\"\",\"def3\":\"\",\"sourceid\":\"1001A1100000006BZF2Z\",\"def4\":\"\",\"def1\":\"\",\"def2\":\"\",\"scsystem\":\"ncc\",\"name\":\"海门区\",\"def9\":\"\",\"def7\":\"\",\"def8\":\"\",\"def5\":\"\",\"def6\":\"\"}],\"sapcode\":\"1003207219\",\"modifier\":\"主数据接口\",\"mdm_datastatus\":3,\"ref_custkind\":\"KHFL000002\",\"ref_adarea3_name\":\"海门区\",\"dr\":0,\"ref_custlike_name\":\"\",\"free4\":\"2024-07-18 13:41:46\",\"ref_adarea2_name\":\"南通市\",\"ref_adarea1_name\":\"江苏省\",\"ref_socialkind_entity\":[],\"ref_managestatus_entity\":[{\"code\":\"JYZT000001\",\"free10\":\"\",\"def10\":\"\",\"free2\":\"2021-01-28 14:56:15\",\"free3\":\"\",\"free1\":\"2021-01-28 14:56:15\",\"free6\":\"\",\"mdgcode\":\"\",\"free7\":\"\",\"free4\":\"\",\"free5\":\"\",\"free8\":\"\",\"free9\":\"\",\"def3\":\"\",\"sourceid\":\"\",\"def4\":\"\",\"def1\":\"\",\"def2\":\"\",\"scsystem\":\"\",\"name\":\"存续\",\"def9\":\"\",\"def7\":\"\",\"def8\":\"\",\"def5\":\"\",\"def6\":\"\"}],\"_checked\":true,\"mdm_duplicate\":0,\"cardno\":\"913206843311414658\",\"sub_custlinkman\":[],\"name\":\"江苏金轮特种钢丝有限公司\",\"ref_bcusttype_name\":\"\",\"ref_income_entity\":[],\"code\":\"Wnull\",\"modifytime\":\"2024-05-24 17:09:31\",\"ref_socialkind_name\":\"\",\"ref_cardtype_entity\":[{\"code\":\"ZJLX000003\",\"free10\":\"\",\"def10\":\"\",\"free2\":\"2021-01-18 15:55:06\",\"free3\":\"\",\"free1\":\"2021-01-18 15:55:06\",\"free6\":\"\",\"mdgcode\":\"\",\"free7\":\"\",\"free4\":\"\",\"free5\":\"\",\"free8\":\"\",\"free9\":\"\",\"def3\":\"\",\"sourceid\":\"\",\"def4\":\"\",\"def1\":\"\",\"def2\":\"\",\"scsystem\":\"\",\"name\":\"统一社会信用代码\",\"def9\":\"\",\"def7\":\"\",\"def8\":\"\",\"def5\":\"\",\"def6\":\"\"}],\"ref_education_entity\":[],\"ref_cardtype_name\":\"统一社会信用代码\",\"registerfund\":\"5000\",\"ref_bcusttype_entity\":[],\"mdm_code\":\"Wnull\",\"mdm_version\":1,\"sub_custorg\":[{\"attributeNames\":[\"mdm_org\",\"modifytime\",\"mdm_workflow_status\",\"modifier\",\"mdm_datastatus\",\"mdm_cleanstatus\",\"dr\",\"free10\",\"isstop_name\",\"mdm_parentcode\",\"mdm_org_entity\",\"mdm_org_name\",\"def10\",\"free2\",\"free3\",\"free1\",\"free6\",\"mdgcode\",\"free7\",\"free4\",\"free5\",\"isstop\",\"id\",\"pk_mdm\",\"free8\",\"free9\",\"def3\",\"sourceid\",\"def4\",\"def1\",\"creator\",\"createtime\",\"def2\",\"pkmdm_flow\",\"mdm_duplicate\",\"mdm_code\",\"scsystem\",\"mdm_version\",\"def9\",\"def7\",\"def8\",\"def5\",\"def6\"],\"data\":{\"mdm_org\":\"ZZ00000228\",\"modifytime\":\"2024-05-24 17:09:31\",\"modifier\":\"主数据接口\",\"mdm_datastatus\":3,\"mdm_cleanstatus\":\"WAITING\",\"dr\":0,\"isstop_name\":\"否\",\"mdm_parentcode\":\"Wnull\",\"mdm_org_entity\":[{\"code\":\"3550\",\"mdm_org\":\"ZZ00000048\",\"free10\":\"\",\"def10\":\"\",\"free2\":\"2021-03-14 14:33:18\",\"free3\":\"\",\"free1\":\"\",\"free6\":\"\",\"mdgcode\":\"3550\",\"free7\":\"\",\"tel\":\"\",\"vnote\":\"\",\"free4\":\"\",\"free5\":\"\",\"free8\":\"\",\"isused\":\"\",\"free9\":\"\",\"def3\":\"\",\"sourceid\":\"\",\"def4\":\"\",\"def1\":\"\",\"address\":\"浙江省湖州市创业大道188号5幢-2\",\"def2\":\"\",\"shortname\":\"浙江风行湖州分公司\",\"ref_comptype\":\"GSLX000002\",\"scsystem\":\"\",\"mdm_allorg\":\"WCZZ00000295\",\"name\":\"浙江元通风行汽车有限公司湖州分公司\",\"def9\":\"\",\"def7\":\"\",\"def8\":\"\",\"def5\":\"\",\"taxpayerid\":\"91330501770707176E\",\"def6\":\"\"}],\"mdm_org_name\":\"浙江元通风行汽车有限公司湖州分公司\",\"isstop\":\"N\",\"pk_mdm\":\"7de2d384-a8df-4b92-bf7e-eeb97bf85631\",\"sourceid\":\"GYSZZ00090766\",\"creator\":\"主数据接口\",\"createtime\":\"2024-05-24 17:09:31\",\"mdm_duplicate\":0,\"mdm_code\":\"KHZZ02333593\",\"mdm_version\":1},\"workflow\":false,\"mdmCode\":\"KHZZ02333593\",\"history\":false,\"primaryKeyValue\":\"7de2d384-a8df-4b92-bf7e-eeb97bf85631\",\"busiDataID\":\"\",\"mdmParentCode\":\"Wnull\",\"primaryKey\":\"pk_mdm\"}],\"ref_cardtype\":\"ZJLX000003\",\"ref_adarea1_entity\":[{\"code\":\"320000\",\"ref_adarea\":\"\",\"free10\":\"\",\"def10\":\"\",\"free2\":\"2022-06-30 17:05:04\",\"free3\":\"\",\"ref_country\":\"GJ000227\",\"free1\":\"\",\"free6\":\"\",\"mdgcode\":\"\",\"free7\":\"\",\"free4\":\"\",\"free5\":\"\",\"free8\":\"\",\"free9\":\"\",\"def3\":\"\",\"sourceid\":\"1001Z01000000000SGLN\",\"def4\":\"\",\"def1\":\"\",\"def2\":\"\",\"scsystem\":\"ncc\",\"name\":\"江苏省\",\"def9\":\"\",\"def7\":\"\",\"def8\":\"\",\"def5\":\"\",\"def6\":\"\"}],\"ref_custkind_entity\":[{\"code\":\"02\",\"free10\":\"\",\"def10\":\"\",\"free2\":\"2021-01-25 22:00:54\",\"free3\":\"\",\"free1\":\"2021-01-25 22:00:54\",\"free6\":\"\",\"mdgcode\":\"\",\"free7\":\"\",\"free4\":\"\",\"free5\":\"\",\"free8\":\"\",\"free9\":\"\",\"def3\":\"\",\"sourceid\":\"\",\"def4\":\"\",\"def1\":\"\",\"def2\":\"\",\"scsystem\":\"\",\"name\":\"元通外物产内\",\"def9\":\"\",\"def7\":\"\",\"def8\":\"\",\"def5\":\"\",\"def6\":\"\"}]}"));
        System.out.println(etVO);
    }
    @Test
    public void test37() throws ClassNotFoundException {
        String jsonStr ="{\"cardData\":{\"pageid\":\"F3-Cxx-08\",\"head\":{\"head\":{\"areaType\":\"form\",\"rows\":[{\"values\":{\"pk_org_v\":{\"value\":\"0001A110000000001ZR3\"},\"pk_org\":{\"value\":\"0001A110000000001ZR4\"},\"isinit\":{\"value\":false},\"billdate\":{\"value\":\"2024-11-27 10:53:38\"},\"busidate\":{\"value\":\"2024-11-27 10:53:38\"},\"objtype\":{\"value\":\"1\"},\"pk_deptid\":{\"value\":\"1001A110000000VAMZ7Z\"},\"pk_deptid_v\":{\"value\":\"0001A110000000COOXH9\"},\"pk_tradetypeid\":{\"value\":\"1001A110000000BE20DZ\"},\"pk_tradetype\":{\"value\":\"F3-Cxx-08\"},\"pk_busitype\":{\"value\":\"1001A110000000BXHU6R\"},\"pk_currtype\":{\"value\":\"1002Z0100000000001K1\"},\"rate\":{\"value\":\"1.00\",\"scale\":\"2\"},\"money\":{\"value\":\"2.00\",\"scale\":\"2\"},\"local_money\":{\"value\":\"2.00\",\"scale\":\"2\"},\"ddje\":{\"value\":\"贰元整\"},\"supplier\":{\"value\":\"0001A1100000000053RY\"},\"def159\":{\"value\":\"是\"},\"isreded\":{\"value\":false},\"pk_balatype\":{\"value\":\"0001Z0100000000000Y2\"},\"payaccount\":{\"value\":\"1001A11000000000D3WN\"},\"recaccount\":{\"value\":\"1001A1100000000ABWXH\"},\"pk_subjcode\":{\"value\":\"1001A110000000004MCM\"},\"billstatus\":{\"value\":\"-1\"},\"approvestatus\":{\"value\":\"-1\"},\"effectstatus\":{\"value\":\"0\"},\"billmaker\":{\"value\":\"1001A110000000I0L10Y\"},\"pk_fiorg_v\":{\"value\":\"0001A110000000001ZR3\"},\"sett_org\":{\"value\":\"0001A110000000001ZR4\"},\"pk_group\":{\"value\":\"0001A1100000000005I7\"},\"pk_fiorg\":{\"value\":\"0001A110000000001ZR4\"},\"sett_org_v\":{\"value\":\"0001A110000000001ZR3\"},\"pk_billtype\":{\"value\":\"F3\"},\"ismandatepay\":{\"value\":false},\"billclass\":{\"value\":\"fk\"},\"syscode\":{\"value\":\"1\"},\"billyear\":{\"value\":\"2024\"},\"billperiod\":{\"value\":\"11\"},\"settletype\":{\"value\":\"0\"},\"def29\":{\"value\":false},\"def22\":{\"value\":false},\"settleflag\":{\"value\":\"0\"},\"grouplocal\":{\"value\":\"0.00\",\"scale\":\"2\"},\"globallocal\":{\"value\":\"0.00\",\"scale\":\"2\"},\"grouprate\":{\"value\":\"0.00000000\",\"scale\":\"0\"},\"globalrate\":{\"value\":\"0.00000000\",\"scale\":\"0\"},\"isurgent\":{\"value\":false},\"def36\":{\"value\":false},\"def47\":{\"value\":false},\"def53\":{\"value\":false},\"def56\":{\"value\":false},\"def57\":{\"value\":false},\"def79\":{\"value\":false},\"creator\":{\"value\":\"1001A110000000I0L10Y\"},\"creationtime\":{\"value\":\"2024-11-27 10:53:38\"},\"isrefund\":{\"value\":\"N\"},\"rececountryid\":{\"value\":\"0001Z010000000079UJJ\"},\"taxcountryid\":{\"value\":\"0001Z010000000079UJJ\"},\"saga_frozen\":{\"value\":\"0\"},\"approvedated\":{\"value\":\"2024-11-27 11:20:16\"},\"src_syscode\":{\"value\":\"1\"}},\"status\":\"1\"}],\"areacode\":\"head\"}},\"body\":{\"bodys\":{\"areaType\":\"table\",\"rows\":[{\"status\":\"2\",\"isOptimized\":false,\"values\":{\"sett_org\":{\"value\":\"0001A110000000001ZR4\"},\"isurgent\":{\"value\":false},\"taxprice\":{\"value\":\"0.00000000\",\"scale\":\"8\"},\"pk_subjcode\":{\"value\":\"1001A110000000004MCM\"},\"pk_tradetype\":{\"value\":\"F3-Cxx-08\"},\"scomment\":{\"value\":\"%s\"},\"pk_currtype\":{\"value\":\"1002Z0100000000001K1\"},\"pk_recpaytype\":{\"value\":\"GLOBZ300000000000001\"},\"money_de\":{\"value\":\"2.00\",\"scale\":\"2\"},\"globalagentreceivelocal\":{\"value\":\"0.00\",\"scale\":\"2\"},\"local_money_bal\":{\"value\":\"2.00\",\"scale\":\"2\"},\"grouprate\":{\"value\":\"0.00000000\",\"scale\":\"0\"},\"globalbalance\":{\"value\":\"0.00\",\"scale\":\"2\"},\"notax_de\":{\"value\":\"2.00\",\"scale\":\"2\"},\"local_tax_de\":{\"value\":\"0.00\",\"scale\":\"2\"},\"pk_billtype\":{\"value\":\"F3\"},\"groupbalance\":{\"value\":\"0.00\",\"scale\":\"2\"},\"rate\":{\"value\":\"1.00\",\"scale\":\"2\"},\"def4\":{\"value\":\"1001A11000000000AAK1\"},\"globalnotax_de\":{\"value\":\"0.00\",\"scale\":\"2\"},\"agentreceivelocal\":{\"value\":\"0.00000000\"},\"supplier\":{\"value\":\"0001A1100000000053RY\"},\"agentreceiveprimal\":{\"value\":\"0.00000000\"},\"sendcountryid\":{\"value\":\"0001Z010000000079UJJ\"},\"billdate\":{\"value\":\"2024-11-27 10:53:38\"},\"globaldebit\":{\"value\":\"0.00\",\"scale\":\"2\"},\"billclass\":{\"value\":\"fk\"},\"isdiscount\":{\"value\":false},\"def10\":{\"value\":\"1001A1100000001V615M\"},\"pk_fiorg\":{\"value\":\"0001A110000000001ZR4\"},\"def19\":{\"value\":\"0001A11000000001HB2B\"},\"pk_tradetypeid\":{\"value\":\"1001A110000000BE20DZ\"},\"sett_org_v\":{\"value\":\"0001A110000000001ZR3\"},\"groupdebit\":{\"value\":\"0.00\",\"scale\":\"2\"},\"pk_group\":{\"value\":\"0001A1100000000005I7\"},\"pk_balatype\":{\"value\":\"0001Z0100000000000Y2\"},\"objtype\":{\"value\":\"1\"},\"pk_org_v\":{\"value\":\"0001A110000000001ZR3\"},\"taxtype\":{\"value\":\"1\"},\"payaccount\":{\"value\":\"1001A11000000000D3WN\"},\"direction\":{\"value\":\"1\"},\"money_bal\":{\"value\":\"2.00\",\"scale\":\"2\"},\"recaccount\":{\"value\":\"1001A1100000000ABWXH\"},\"pk_deptid\":{\"value\":\"1001A110000000VAMZ7Z\"},\"quantity_bal\":{\"value\":\"0.00\",\"scale\":\"2\"},\"pk_fiorg_v\":{\"value\":\"0001A110000000001ZR3\"},\"settlemoney\":{\"value\":\"0.00\",\"scale\":\"2\"},\"groupnotax_de\":{\"value\":\"0.00\",\"scale\":\"2\"},\"buysellflag\":{\"value\":\"2\"},\"prepay\":{\"value\":\"0\"},\"busidate\":{\"value\":\"2024-11-27 10:53:38\"},\"comment\":{\"value\":\"%s\"},\"pk_payitem\":{\"value\":\"index_00\"},\"nosubtax\":{\"value\":\"0.00\",\"scale\":\"2\"},\"local_taxprice\":{\"value\":\"0.00000000\",\"scale\":\"8\"},\"occupationmny\":{\"value\":\"2.00\",\"scale\":\"2\"},\"rowno\":{\"value\":\"0\"},\"pk_deptid_v\":{\"value\":\"0001A110000000COOXH9\"},\"groupagentreceivelocal\":{\"value\":\"0.00\",\"scale\":\"2\"},\"pk_org\":{\"value\":\"0001A110000000001ZR4\"},\"direct_checkno\":{\"value\":false},\"taxrate\":{\"value\":\"0.00\",\"scale\":\"2\"},\"def225\":{\"value\":\"1001A110000000000607\"},\"local_price\":{\"value\":\"0.00000000\",\"scale\":\"8\"},\"nosubtaxrate\":{\"value\":\"0.00\",\"scale\":\"2\"},\"local_notax_de\":{\"value\":\"2.00\",\"scale\":\"2\"},\"globalrate\":{\"value\":\"0.00000000\",\"scale\":\"0\"},\"local_money_de\":{\"value\":\"2.00\",\"scale\":\"2\"},\"numberindex\":{\"value\":\"1\"}},\"rowid\":\"290390.8a86340a2a803a1\"}],\"areacode\":\"bodys\"}},\"templetid\":\"1001A1100000010FKY46\"},\"uiState\":\"add\",\"appcode\":\"20080EBM415\",\"pagecode\":\"F3-Cxx-08\",\"butncode\":\"Save\"}";
        for (int i = 0; i < 1; i++){
            String copyJson = String.format(jsonStr, "测试" + i, "测试" + i);
            System.out.println(copyJson);
        }
        String regex = "^\\d+\\.\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        String str2="{\"sett_org\":{\"value\":\"0001A110000000001ZR4\"},\"isurgent\":{\"value\":false},\"taxprice\":{\"value\":\"0.00000000\",\"scale\":\"8\"},\"pk_subjcode\":{\"value\":\"1001A110000000004MCM\"},\"pk_tradetype\":{\"value\":\"F3-Cxx-08\"},\"scomment\":{\"value\":\"测试\"},\"pk_currtype\":{\"value\":\"1002Z0100000000001K1\"},\"pk_recpaytype\":{\"value\":\"GLOBZ300000000000001\"},\"money_de\":{\"value\":\"2.00\",\"scale\":\"2\"},\"globalagentreceivelocal\":{\"value\":\"0.00\",\"scale\":\"2\"},\"local_money_bal\":{\"value\":\"2.00\",\"scale\":\"2\"},\"grouprate\":{\"value\":\"0.00000000\",\"scale\":\"0\"},\"globalbalance\":{\"value\":\"0.00\",\"scale\":\"2\"},\"notax_de\":{\"value\":\"2.00\",\"scale\":\"2\"},\"local_tax_de\":{\"value\":\"0.00\",\"scale\":\"2\"},\"pk_billtype\":{\"value\":\"F3\"},\"groupbalance\":{\"value\":\"0.00\",\"scale\":\"2\"},\"rate\":{\"value\":\"1.00\",\"scale\":\"2\"},\"def4\":{\"value\":\"1001A11000000000AAK1\"},\"globalnotax_de\":{\"value\":\"0.00\",\"scale\":\"2\"},\"agentreceivelocal\":{\"value\":\"0.00000000\"},\"supplier\":{\"value\":\"0001A1100000000053RY\"},\"agentreceiveprimal\":{\"value\":\"0.00000000\"},\"sendcountryid\":{\"value\":\"0001Z010000000079UJJ\"},\"billdate\":{\"value\":\"2024-11-27 10:53:38\"},\"globaldebit\":{\"value\":\"0.00\",\"scale\":\"2\"},\"billclass\":{\"value\":\"fk\"},\"isdiscount\":{\"value\":false},\"def10\":{\"value\":\"1001A1100000001V615M\"},\"pk_fiorg\":{\"value\":\"0001A110000000001ZR4\"},\"def19\":{\"value\":\"0001A11000000001HB2B\"},\"pk_tradetypeid\":{\"value\":\"1001A110000000BE20DZ\"},\"sett_org_v\":{\"value\":\"0001A110000000001ZR3\"},\"groupdebit\":{\"value\":\"0.00\",\"scale\":\"2\"},\"pk_group\":{\"value\":\"0001A1100000000005I7\"},\"pk_balatype\":{\"value\":\"0001Z0100000000000Y2\"},\"objtype\":{\"value\":\"1\"},\"pk_org_v\":{\"value\":\"0001A110000000001ZR3\"},\"taxtype\":{\"value\":\"1\"},\"payaccount\":{\"value\":\"1001A11000000000D3WN\"},\"direction\":{\"value\":\"1\"},\"money_bal\":{\"value\":\"2.00\",\"scale\":\"2\"},\"recaccount\":{\"value\":\"1001A1100000000ABWXH\"},\"pk_deptid\":{\"value\":\"1001A110000000VAMZ7Z\"},\"quantity_bal\":{\"value\":\"0.00\",\"scale\":\"2\"},\"pk_fiorg_v\":{\"value\":\"0001A110000000001ZR3\"},\"settlemoney\":{\"value\":\"0.00\",\"scale\":\"2\"},\"groupnotax_de\":{\"value\":\"0.00\",\"scale\":\"2\"},\"buysellflag\":{\"value\":\"2\"},\"prepay\":{\"value\":\"0\"},\"busidate\":{\"value\":\"2024-11-27 10:53:38\"},\"comment\":{\"value\":\"测试\"},\"pk_payitem\":{\"value\":\"index_00\"},\"nosubtax\":{\"value\":\"0.00\",\"scale\":\"2\"},\"local_taxprice\":{\"value\":\"0.00000000\",\"scale\":\"8\"},\"occupationmny\":{\"value\":\"2.00\",\"scale\":\"2\"},\"rowno\":{\"value\":\"0\"},\"pk_deptid_v\":{\"value\":\"0001A110000000COOXH9\"},\"groupagentreceivelocal\":{\"value\":\"0.00\",\"scale\":\"2\"},\"pk_org\":{\"value\":\"0001A110000000001ZR4\"},\"direct_checkno\":{\"value\":false},\"taxrate\":{\"value\":\"0.00\",\"scale\":\"2\"},\"def225\":{\"value\":\"1001A110000000000607\"},\"local_price\":{\"value\":\"0.00000000\",\"scale\":\"8\"},\"nosubtaxrate\":{\"value\":\"0.00\",\"scale\":\"2\"},\"local_notax_de\":{\"value\":\"2.00\",\"scale\":\"2\"},\"globalrate\":{\"value\":\"0.00000000\",\"scale\":\"0\"},\"local_money_de\":{\"value\":\"2.00\",\"scale\":\"2\"},\"numberindex\":{\"value\":\"1\"}}";
        String str3 ="{\"pk_org_v\":{\"value\":\"0001A110000000001ZR3\"},\"pk_org\":{\"value\":\"0001A110000000001ZR4\"},\"isinit\":{\"value\":false},\"billdate\":{\"value\":\"2024-11-27 10:53:38\"},\"busidate\":{\"value\":\"2024-11-27 10:53:38\"},\"objtype\":{\"value\":\"1\"},\"pk_deptid\":{\"value\":\"1001A110000000VAMZ7Z\"},\"pk_deptid_v\":{\"value\":\"0001A110000000COOXH9\"},\"pk_tradetypeid\":{\"value\":\"1001A110000000BE20DZ\"},\"pk_tradetype\":{\"value\":\"F3-Cxx-08\"},\"pk_busitype\":{\"value\":\"1001A110000000BXHU6R\"},\"pk_currtype\":{\"value\":\"1002Z0100000000001K1\"},\"rate\":{\"value\":\"1.00\",\"scale\":\"2\"},\"money\":{\"value\":\"2.00\",\"scale\":\"2\"},\"local_money\":{\"value\":\"2.00\",\"scale\":\"2\"},\"ddje\":{\"value\":\"贰元整\"},\"supplier\":{\"value\":\"0001A1100000000053RY\"},\"def159\":{\"value\":\"是\"},\"isreded\":{\"value\":false},\"pk_balatype\":{\"value\":\"0001Z0100000000000Y2\"},\"payaccount\":{\"value\":\"1001A11000000000D3WN\"},\"recaccount\":{\"value\":\"1001A1100000000ABWXH\"},\"pk_subjcode\":{\"value\":\"1001A110000000004MCM\"},\"billstatus\":{\"value\":\"-1\"},\"approvestatus\":{\"value\":\"-1\"},\"effectstatus\":{\"value\":\"0\"},\"billmaker\":{\"value\":\"1001A110000000I0L10Y\"},\"pk_fiorg_v\":{\"value\":\"0001A110000000001ZR3\"},\"sett_org\":{\"value\":\"0001A110000000001ZR4\"},\"pk_group\":{\"value\":\"0001A1100000000005I7\"},\"pk_fiorg\":{\"value\":\"0001A110000000001ZR4\"},\"sett_org_v\":{\"value\":\"0001A110000000001ZR3\"},\"pk_billtype\":{\"value\":\"F3\"},\"ismandatepay\":{\"value\":false},\"billclass\":{\"value\":\"fk\"},\"syscode\":{\"value\":\"1\"},\"billyear\":{\"value\":\"2024\"},\"billperiod\":{\"value\":\"11\"},\"settletype\":{\"value\":\"0\"},\"def29\":{\"value\":false},\"def22\":{\"value\":false},\"settleflag\":{\"value\":\"0\"},\"grouplocal\":{\"value\":\"0.00\",\"scale\":\"2\"},\"globallocal\":{\"value\":\"0.00\",\"scale\":\"2\"},\"grouprate\":{\"value\":\"0.00000000\",\"scale\":\"0\"},\"globalrate\":{\"value\":\"0.00000000\",\"scale\":\"0\"},\"isurgent\":{\"value\":false},\"def36\":{\"value\":false},\"def47\":{\"value\":false},\"def53\":{\"value\":false},\"def56\":{\"value\":false},\"def57\":{\"value\":false},\"def79\":{\"value\":false},\"creator\":{\"value\":\"1001A110000000I0L10Y\"},\"creationtime\":{\"value\":\"2024-11-27 10:53:38\"},\"isrefund\":{\"value\":\"N\"},\"rececountryid\":{\"value\":\"0001Z010000000079UJJ\"},\"taxcountryid\":{\"value\":\"0001Z010000000079UJJ\"},\"saga_frozen\":{\"value\":\"0\"},\"approvedated\":{\"value\":\"2024-11-27 11:20:16\"},\"src_syscode\":{\"value\":\"1\"}}";
        JsonParser parser = new JsonParser();
        //将JSON的String 转成一个JsonArray对象
        JsonObject jsonArray = parser.parse(str3).getAsJsonObject();
        JsonObject jsonObject2 = new JsonObject();
        for (Map.Entry<String, JsonElement> entry : jsonArray.entrySet()) {
            String key = entry.getKey();
            JsonElement  element= entry.getValue();
            JsonObject valueObject = element.getAsJsonObject();
            String value = valueObject.get("value").getAsString();
            if (!key.startsWith("def") && (value.equals("false") || value.equals("N") || valueObject.get("scale") != null || value.contains("2024-11-27 ")
                    || pattern.matcher(value).matches())) {
                if (valueObject.get("scale") != null){
                    int scale = valueObject.get("scale").getAsInt();
                    JsonObject jsonObject3 = new JsonObject();
                    JsonArray jsonArray1 = new JsonArray();
                    jsonArray1.add(0);
                    jsonArray1.add(Integer.parseInt(value.split("\\.")[0]));
                    jsonArray1.add(0);
                    jsonArray1.add(0);
                    jsonArray1.add(0);
                    jsonObject3.add("v", jsonArray1);
                    jsonObject3.addProperty("power", -scale);
                    jsonObject2.add(key, jsonObject3);
                }else {

                    jsonObject2.add(key, valueObject);
                }
            } else {
                if (key.equals("scomment") || key.equals("comment")){
                    jsonObject2.addProperty(key, "%s");
                }else {
                    jsonObject2.addProperty(key, value);
                }
            }
        }
        System.out.println(jsonObject2);

    }

    @Test
    public void test38() throws ClassNotFoundException {
       String str ="订单支付.+_资金上划";
        GlOperQueryBO glOperQueryBO = new GlOperQueryBO();
        glOperQueryBO.setOperCode("订单支付.+_资金上划");

       System.out.println("(^" + glOperQueryBO.getOperCode() + "$)");

       String str2="20260530172349763\n" +
               "20260530171202364\n" +
               "20260723163252938\n" +
               "20260530171604522\n" +
               "20260530180216681\n" +
               "20260723163233314\n" +
               "20260530180328130\n" +
               "20260531160627956\n" +
               "20260530171920339";

       String[] split = str2.split("\n");
       //循环，然后给字符两边加上'',用,分割，汇总成一个string
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        for (String s : split) {
            sb.append("'").append(s).append("'").append(",");
            sb2.append("ALTER INDEX ").append(s).append(" MONITORING USAGE;\n");
            sb3.append("DROP INDEX  ").append(s).append(";\n");
            sb4.append("NCC应付核销,核销批次号：").append(s).append("\n");
        }
        System.out.println(split.length);
        System.out.println(sb.toString());
        System.out.println(sb2.toString());
        System.out.println(sb3);
        System.out.println(sb4);



        Set<String> listpks = new LinkedHashSet<>();
        for (int j = 0; j <= 150; j++) {
            listpks.add(String.valueOf(j));
        }
        int subListSize = 100; // 每个子列表的大小
        List<String> subLists = new ArrayList<>(listpks);
        List<Set<String>> result = new ArrayList<>();
        Iterator<String> iterator = listpks.iterator();

        while (iterator.hasNext()) {
            Set<String> subset = new LinkedHashSet<>(100);
            for (int i = 0; i < 100 && iterator.hasNext(); i++) {
                subset.add(iterator.next());
            }
            result.add(subset);
        }
        System.out.println(result);
    }


    @Test
    public void test39() throws IOException {
        File file=new File("D:\\Intellij\\sgtSpringBootDemo\\src\\test\\java\\com\\sgt\\user(1).json");
        FileReader fileReader = new FileReader(file);
        Reader reader = new InputStreamReader(Files.newInputStream(file.toPath()), StandardCharsets.UTF_8);
        int ch = 0;
        StringBuffer sb = new StringBuffer();
        while ((ch = reader.read()) != -1) {
            sb.append((char) ch);
        }
        fileReader.close();
        reader.close();
        String jsonStr = sb.toString();
        Map<String, Map<String, Object>> map = JSON.parseObject(jsonStr, Map.class);
        List<Map<String, Object>> pagedata = (List<Map<String, Object>>) map.get("message");
        System.out.println(pagedata.size());

        StringBuffer sb2 =  new StringBuffer();
        System.out.println(sb2.toString().indexOf("1"));
    }
    @Test
    public void test40() throws IOException {
        StringBuffer sb = readFile("D:\\Intellij\\sgtSpringBootDemo\\src\\test\\java\\com\\sgt\\ce.json");
        String jsonStr = sb.toString();

        Map<String, List<Map<String, String>>> map = JSON.parseObject(jsonStr, Map.class);
        List<Map<String, String>> list = map.get("key");
        int num=0;
        getPK(list,num);
    }
    @Test
    public void test41() throws IOException {
        String str ="private java.lang.String %s;";

        for (int i = 1; i <= 40; i++){
            System.out.printf((str) + "%n", "def"+i);
        }
        String str2 ="public static final String %s = \"%s\";";

        for (int i = 1; i <= 40; i++){
            System.out.println(String.format(str2, "DEF" + i, "def" + i));
        }
    }
    @Test
    public void test42() throws IOException {
        String str = "D32026052100689288核销码刷成3CF0IR2026031100001\n" +
                "D32026052100689291核销码刷成3CF0IR2026031100004\n" +
                "D32026052100689293核销码刷成3CF0IR2026031100002\n" +
                "D32026052100689287核销码刷成3CF0IR2026031100003";
        String insert = "INSERT into ap_payableitem_bak260730  \n" +
                "SELECT * FROM ap_payableitem WHERE BILLNO IN (%s);";
        String insert2 = "INSERT into ARAP_BUSIDATA_bak260730  \n" +
                "SELECT * FROM ARAP_BUSIDATA WHERE BILLNO IN (%s);";
        String[] split = str.split("\n");
        String billNos ="";
        String updateSql1="";
        String updateSql2="";
        for (String s : split) {
            String[] split1 = s.split("核销码刷成");
            billNos = billNos + "'" + split1[0] + "',";
            updateSql1 = updateSql1 + "UPDATE ap_payableitem SET def223 ='" + split1[1] + "' WHERE BILLNO ='" + split1[0] + "';\n";
            updateSql2 = updateSql2 + "UPDATE ARAP_BUSIDATA SET def223 ='" + split1[1] + "' WHERE BILLNO ='" + split1[0] + "';\n";
        }
        System.out.println(String.format(insert, billNos));
        System.out.println(String.format(insert2, billNos));
        System.out.println(updateSql1);
        System.out.println(updateSql2);

    }

    @Test
    public void test43() throws IOException {
        StringBuffer sb = readFile("D:\\Intellij\\sgtSpringBootDemo\\src\\test\\java\\com\\sgt\\cs.txt");
        String jsonStr = sb.toString();
        String[] split = jsonStr.split("\r\n");
        StringBuilder sb2 = new StringBuilder();
        for (String s : split) {
            sb2.append("ALTER INDEX ").append(s).append(" MONITORING USAGE;\n");
        }
        System.out.println(sb2.toString());
    }
    @Test
    public void test44() throws IOException {
        String str ="169002,169003,169004,169005,169006,169020,169021,169035,169036,394139,394140,394145,394152,394159,394161,394167,394170,394173,394398,394399,394416,394428,394429";
        List<String> list = new ArrayList<>();
        String[] split = str.split(",");
        for (int i=14;i<split.length;i++) {
            list.add(split[i]);
        }
        System.out.println(String.join(",", list));
        System.out.println(list.size());
    }
    @Test
    public void test45() throws IOException {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        System.out.println(queue);
        queue.remove();

    }
    @Test
    public void test46() throws IOException {
        String str ="XXXXX";
        String str2 ="2222222222222222222";
        System.out.println(str.compareTo(str2));
        System.out.println(str2.compareTo(str));
    }
    @Test
    public void test47() throws IOException {
        String str ="1\t184592.28000000\t13\t267907,267908,267909,267910,267911,267913,309529,309530,309531,309532,309533,309534,396482\n" +
                "2\t353406.37000000\t6\t267906,267915,309523,309528,377525,396481";
        String[] split = str.split("\n");
        List<String> list = new ArrayList<>();
        for (String s : split){
            String[] split2 = s.split("\t");
            int start = Integer.parseInt(split2[0]);
            String[] split3 = split2[3].split(",");
            for (int i = start; i < split3.length; i++){
                list.add(split3[i]);
            }

        }
        System.out.println(String.join(",", list));
        System.out.println(list.size());


    }

    @Test
    public void test48() throws IOException {
        String str= "7109855.48";
        Double d = Double.parseDouble(str);
        //88580022.60 81470167.12
        String str2= "89482.87";
        Double d2 = Double.parseDouble(str2);
        String str3= "88580022.60";
        Double d3 = Double.parseDouble(str3);
        if ((d+d2)>d3){
            System.out.println("1111");
        }
        System.out.println(d);
        System.out.println("真实值: " + new BigDecimal(d2));

    }

    private String getSubStr(String str, int start, int end){
        return new String(str.substring(start, end));
    }


    private void getPK(List<Map<String, String>> list, int num) {
        if (list.size() == 0){
            return;
        }
        List<String> pkList = new ArrayList<>();
        List<String> orgList = new ArrayList<>();
        List<Map<String, String>> lastList = new ArrayList<>();
        for (Map<String, String> map : list) {
            if (pkList.size()<6){
                if (orgList.contains(map.get("PK_ORG"))) {
                    lastList.add(map);
                } else {
                    pkList.add(map.get("PK_FINANCEPAY"));
                    orgList.add(map.get("PK_ORG"));
                }
            }else {
                lastList.add(map);
            }
        }
        num = num + pkList.size();
        System.out.println(pkList);
        getPK(lastList, num);
    }


    private String testClass(Object obj){
        TestVO testVO = (TestVO) obj;
        return testVO.getClass().getName();
    }

    private boolean checkDateFormat(String input) {
        String pattern = "\\d{4}-(0[1-9]|1[0-2])";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(input);
        return m.matches();
    }

    private boolean sendEmail(String to, ByteArrayOutputStream baos, String subject, String content, String excelName) {
        // 发件人电子邮箱
        String from = "zjyt_lbjwlb@163.com";
        // 获取系统属性
        Properties properties = new Properties();
        // 设置邮件服务器 ->QQ 邮件服务器
        properties.setProperty("mail.smtp.host", "smtp.163.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "false");
        properties.put("mail.smtp.port", "25");
        // 获取默认session对象
        Session session = Session.getInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("zjyt_lbjwlb@163.com", "YVSE5uMBeEYuxiRc"); //发件人邮件用户名、授权码
            }
        });

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from,"测试邮件发件"));
            // Set To: 头部头字段
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            // Set Subject: 头部头字段
            message.setSubject(subject);
            /*添加附件*/
            Multipart multipart = new MimeMultipart("mixed");
            //创建一个正文部分
            MimeBodyPart textPart = new MimeBodyPart();
            //设置正文内容
            textPart.setContent(content, "text/html;charset=utf-8");
            multipart.addBodyPart(textPart);
            if (baos != null) {
                MimeBodyPart fileBody = new MimeBodyPart();
                DataSource source = new ByteArrayDataSource(baos.toByteArray(), "application/msexcel");
                fileBody.setDataHandler(new DataHandler(source));
                // 中文乱码问题
                fileBody.setFileName(MimeUtility.encodeText(excelName));
                multipart.addBodyPart(fileBody);
            }
            message.setContent(multipart);
            // 发送消息
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public static ByteArrayOutputStream creatExcel(List<String[]> rowValues1, List<String[]> rowValues2, String sheetName) {
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
        for (int i = 0; i < rowValues1.size(); i++) {
            Row currentRow = sheet.createRow(i);
            // 获取当前行的数据
            String[] cellValues = rowValues1.get(i);
            for (int j = 0; j < cellValues.length; j++) {
                // 设置列宽
                sheet.setColumnWidth(j, 4100);
                Cell cell = currentRow.createCell(j);
                if (j > 0) {
                    CellStyle cellStyle2 = wb.createCellStyle();
                    cellStyle2.setFont(font);
                    cellStyle2.setAlignment(HorizontalAlignment.LEFT);
                    cellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
                    cell.setCellStyle(cellStyle2);
                } else {
                    cell.setCellStyle(cellStyle);
                }
                //每个单元格的值目前做 String 处理
                cell.setCellType(CellType.STRING);
                cell.setCellValue(cellValues[j]);
            }
        }
        for (int i = 0; i < rowValues2.size(); i++) {
            Row currentRow = sheet.createRow(i + rowValues1.size());
            // 获取当前行的数据
            String[] cellValues = rowValues2.get(i);
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


    private void testBoolean(Boolean flag){
        flag = flag & Boolean.FALSE;
    }
    private <T extends TestVO> void testT(List<T> aList){
        T[] ts = (T[]) aList.toArray(new TestVO[0]);
    }

    private StringBuffer readFile(String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        Reader reader = new InputStreamReader(Files.newInputStream(file.toPath()), StandardCharsets.UTF_8);
        int ch = 0;
        StringBuffer sb = new StringBuffer();
        while ((ch = reader.read()) != -1) {
            sb.append((char) ch);
        }
        fileReader.close();
        reader.close();
        return sb;
    }

    private void testThrow(){
        throw new RuntimeException("cscs");
    }

    private void testStr(String str){
        str = str+"cscs";
    }

    private static void addToZipFile(String filePath, InputStream fis, ZipOutputStream zipOut)
            throws IOException {
        ZipEntry zipEntry = new ZipEntry(filePath);
        zipOut.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }

        zipOut.closeEntry();
        fis.close();
    }

    private String getPsnCl(List<SapOperateTempVO> sapOperateTempVOList) {
        // 定义一个Comparator来比较SapOperateTempVO对象的enddate字段
        Comparator<SapOperateTempVO> endDateComparator = (o1, o2) -> {
            // 如果两个对象的enddate都为空，认为它们相等
            if (o1.getEnddate() == null && o2.getEnddate() == null) {
                return 0;
            }
            // 如果第一个对象的enddate为空，认为它大于第二个对象
            if (o1.getEnddate() == null) {
                return 1;
            }
            // 如果第二个对象的enddate为空，认为它小于第一个对象
            if (o2.getEnddate() == null) {
                return -1;
            }
            // 否则，按照日期的自然顺序比较
            return o1.getEnddate().compareTo(o2.getEnddate());
        };

        // 使用Stream的max方法来找到列表中enddate最大的或者为空的那个对象
        Optional<SapOperateTempVO> maxEndDate = sapOperateTempVOList.stream().max(endDateComparator);

        // 如果存在这样的对象，就获取它的state值
        return maxEndDate.map(SapOperateTempVO::getState).orElse(null);
    }

    public static void copyProperties(Object source, Object target) {
        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();

        Method[] sourceMethods = sourceClass.getMethods();
        Method[] targetMethods = targetClass.getMethods();

        for (Method sourceMethod : sourceMethods) {
            if (sourceMethod.getName().startsWith("get")) {
                try {
                    String name = sourceMethod.getName().substring(3);
                    Object value = sourceMethod.invoke(source);
                    for (Method targetMethod : targetMethods) {
                        if (targetMethod.getName().equals("set" + name)) {
                            targetMethod.invoke(target, value);
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 解压指定的ZIP文件，并尝试获取特定文件的InputStream
     *
     * @param zipFilePath ZIP文件的路径
     * @param targetFileName 需要获取InputStream的文件名
     * @return 返回找到的文件的InputStream，如果没有找到返回null
     * @throws IOException
     */
    public static ZipInputStream getFileInputStreamFromZip(String zipFilePath, String targetFileName) throws IOException {
        FileInputStream fis = new FileInputStream(zipFilePath);
        ZipInputStream zis = new ZipInputStream(fis);
        ZipEntry zipEntry;

        while ((zipEntry = zis.getNextEntry()) != null) {
            // 检查当前条目是否是我们要找的文件
            if (zipEntry.getName().equals(targetFileName)) {
                // 找到目标文件，返回ZipInputStream
                // 注意：返回的ZipInputStream处于打开的条目状态，可以直接读取数据
                return zis; // zis现在定位于targetFileName所代表的文件内容
            }
        }

        // 没有找到指定的文件
        zis.close(); // 确保资源正确释放
        return null;
    }


}
