package com.sgt.service.test;

/**
 * 每个节点等于前两个节点的相加
 * (5,4) = (4,4)+(5,3)
 * (4,4) = (4,3)+(3,4)
 * ()
 * (1,1) = (1,0)+(0,1)
 * (0,1) = 1
 * (1,0) = 1
 */
public class DPQuestion {

    public static void main(String[] args) {
        DPQuestion dpQuestion = new DPQuestion();
        int bLeft = 5;
        int bRight = 4;
        //黑点
        int nonLeft = 3;
        int nonRight = 2;
        System.out.println(dpQuestion.chajie(bLeft, bRight, nonLeft, nonRight));
    }

    private int chajie(int left, int right, int nonLeft, int nonRight) {
        if (left < 0 || right < 0) {
            return 0;
        }
        if (left == nonLeft && right == nonRight) {
            return 0;
        }
        if (left == 1 && right == 0) {
            return 1;
        }
        if (left == 0 && right == 1) {
            return 1;
        }
        return chajie(left - 1, right, nonLeft, nonRight) + chajie(left, right - 1, nonLeft, nonRight);
    }

}
