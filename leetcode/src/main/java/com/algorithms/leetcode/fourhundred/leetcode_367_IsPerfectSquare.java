package com.algorithms.leetcode.fourhundred;

public class leetcode_367_IsPerfectSquare {

    public static boolean isPerfectSquare(int num) {
        int n = (int)Math.sqrt((double) num);
        return n * n == num;
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPerfectSquare(n));
    }
}
