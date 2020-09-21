package com.algorithms.leetcode.onehundred;

public class leetcode_29_Divide {


    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        int sign = -1;
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }

        if (dividend > 0 && divisor > 0) {
            sign = 1;
        } else if (dividend < 0 && divisor < 0) {
            sign = 1;
        } else {
            sign = -1;
        }
        long dividend1 = dividend > 0 ? dividend : -(long) dividend;
        long divisor1 = divisor > 0 ? divisor : -(long) divisor;
        //两个处理是正数
        int result = process(dividend1, divisor1, 1);
        if (sign == -1) {
            return -result;
        }
        return result;
    }

    public static int process(long dividend, long divisor, int result) {
        if (dividend < divisor) {
            return 0;
        }
        long tmp = divisor;
        long low = divisor;
        int res = result;
        while (tmp < dividend) {
            low = tmp;
            tmp = tmp + tmp;
            res = result;
            result = result + result;
        }
        return res + process(dividend - low, divisor, 1);
    }

    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = 2;

        System.out.println(divide(dividend, divisor));
    }
}


