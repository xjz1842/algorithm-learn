package com.algorithms.leetcode;

public class leetcode_50_Pow {

    public static double myPow(double x, int n) {
        if (n == 0) return 1;

        if (x == 0) {
            return x;
        }
        if (x == 1) {
            return 1;
        }
        if (n < 0) {
            n = Math.abs(n);
            x = 1 / x;
        }
        if (n < 0) {
            n = Integer.MAX_VALUE - 1;
        }
        double result = 1.0;

        while (n > 0) {
            //n为奇数
            if ((n & 1) == 1) {
                result = result * x;
            }
            x = x * x;

            n >>= 1; //二进制位右一位
        }
        return result;
    }

    public static void main(String[] args) {

        double x = myPow(-1.00000, -2147483648);

        System.out.println(Math.abs(-2147483648));

        System.out.println(x);

        System.out.println(Integer.MIN_VALUE);
    }
}
