package com.sgt;

import java.util.Scanner;

/**
 * @author �����
 * @description TODO
 * @date 2023/10/18 21:47
 */
public class Cal {

    public static void main(String[] args) {
        System.out.println("请输入4位会员卡号:");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] strings = s.split("");
        int num = 0;
        for (String s1 : strings) {
            num = num + Integer.parseInt(s1);
        }
        System.out.println("会员卡号3569各位之和: " + num);
        System.out.println("是幸运客户吗? " + (num > 20));
    }
}
