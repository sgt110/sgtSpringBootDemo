/*
 * Project: hcare-supervise-local-web
 *
 * File Created at 2022-07-14
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
package com.sgt.util;

import java.security.MessageDigest;

/**
 * 摘要工具栏类
 *
 * @author sungt
 * @version V1.0
 * @since 2022-07-14 10:43
 */
public class DigestUtil {
    /**
     * MD5 加密长度：32字节数量
     */
    private final static String MD5 = "MD5";
    /**
     * SHA1 加密长度：40字节数量
     */
    private final static String SHA1 = "SHA-1";
    /**
     * SHA256 加密长度：64字节数量
     */
    public final static String SHA256 = "SHA-256";
    /**
     * SHA512 加密长度：128字节数量
     */
    private final static String SHA512 = "SHA-512";


    public static void main(String[] args) {
        String input = "test";

        // 消息摘要算法
//        System.out.println("MD5加密:" + encryptDigest(input, MD5));
//        System.out.println("SHA1加密:" + encryptDigest(input, SHA1));
        System.out.println("SHA256加密:" + encryptDigest(input, SHA256));
//        System.out.println("SHA512加密:" + encryptDigest(input, SHA512));
    }

    /***
     * 消息摘要算法，是单向、不可逆的
     *
     * @param input 消息类型
     * @param algorithm 算法类型：MD5、SHA-1、SHA-256、SHA-512
     * @return
     */
    public static String encryptDigest(String input, String algorithm) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            // 消息数字摘要
            byte[] digest = messageDigest.digest(input.getBytes());

            return toHex(digest);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("加密失败！");
        }
    }

    private static String toHex(byte[] digest) {
        // 创建对象用来拼接
        StringBuilder sb = new StringBuilder();

        for (byte b : digest) {
            // 转成 16进制
            String s = Integer.toHexString(b & 0xff);
            if (s.length() == 1) {
                // 如果生成的字符只有一个，前面补0
                s = "0" + s;
            }
            sb.append(s);
        }
        return sb.toString();
    }
}
