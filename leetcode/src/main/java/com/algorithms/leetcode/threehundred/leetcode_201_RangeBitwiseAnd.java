package com.algorithms.leetcode.threehundred;

public class leetcode_201_RangeBitwiseAnd {

    public static int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            // 抹去最右边的 1
            n = n & (n - 1);
        }
        return n;
    }

    public static void main(String[] args) {
        int m = 0;
        int n = 1;
        System.out.println(rangeBitwiseAnd(m, n));
    }
}
