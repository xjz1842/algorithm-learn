package com.algorithms.leetcode.onehundred;

public class leetcode_07_Reverse {

    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        long n = x;
        int sign = 1;
        if (x < 0) {
            sign = -1;
            n = -n;
        }
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            long remain = n % 10;
            if (remain == 0) {
                if (result.length() > 0) {
                    result.append(remain);
                }
            } else {
                result.append(remain);
            }
            n = n / 10;
        }
        return Long.parseLong(result.toString()) > Integer.MAX_VALUE ? 0 :
                sign * Integer.parseInt(result.toString());
    }

    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(reverse(x));
    }
}
