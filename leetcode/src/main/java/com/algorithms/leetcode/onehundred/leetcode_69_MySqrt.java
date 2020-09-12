package com.algorithms.leetcode.onehundred;

public class leetcode_69_MySqrt {

    public static int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        long ans = 0;

        long L = 0;
        long R = x;

        while (L <= R) {
            long mid = L + (R - L) / 2;
            if (mid * mid <= x) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
