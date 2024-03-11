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
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sgt.bo.GlOperQueryBO;
import com.sgt.bo.TestBO;
import com.sgt.bo.TestBO2;
import com.sgt.bo.TestEvent;
import com.sgt.util.MyDateUtils;
import com.sgt.util.MyExcelUtil;
import com.sgt.vo.SapHRPsnVO;
import com.sgt.vo.SapOperateTempVO;
import com.sgt.vo.TestSubVO;
import com.sgt.vo.TestVO;
import org.apache.commons.lang3.StringUtils;
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
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
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
        System.out.println(a.split(",")[0]);
        System.out.println(a.split(",")[1]);
//        System.out.println("1,".split(",")[1]);
        System.out.println("1,".split(",")[0]);
        System.out.println(Arrays.toString("1,2".split(",")));
        System.out.println("".split(",")[0]);
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
        sendEmail("SGT_112@163.com", creatExcel(list, list, "sheet"), "元通零部件采购订单", "交货地址如果为空就是发到我们仓库，交货地址：浙江省杭州市拱墅区康贤路33号2号楼1楼   物流部  林江  0571-88012528 ,13777850244", "采购订单CD2024012400113614测试测试测试测试.xlsx");
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
    }

    private boolean sendEmail(String to, ByteArrayOutputStream baos, String subject, String content, String excelName) {
        // 发件人电子邮箱
        String from = "wangzixiong9139347@qq.com";
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器 ->QQ 邮件服务器
        properties.setProperty("mail.smtp.host", "smtp.qq.com");
        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("wangzixiong9139347@qq.com", "oislbylexbhbbfgb"); //发件人邮件用户名、授权码
            }
        });

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from,"王子轩qq发件"));
            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to,"王子轩youyon收件"));
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
}
