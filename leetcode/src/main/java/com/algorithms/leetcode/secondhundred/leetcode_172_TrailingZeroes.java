package com.algorithms.leetcode.secondhundred;


public class leetcode_172_TrailingZeroes {

    // 阶乘后的零
    public static int trailingZeroes(int n) {
        int fiveNum = 0;

        while (n > 0) {
            fiveNum += n / 5;
            n = n / 5;
        }
        return fiveNum;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(30));
    }

}
