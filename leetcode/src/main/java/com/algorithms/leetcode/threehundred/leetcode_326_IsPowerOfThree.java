package com.algorithms.leetcode.threehundred;

public class leetcode_326_IsPowerOfThree {

    public static boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        long i = 3;
        long result = 3;
        while (result < n) {
            i = result;
            result = i * i;
        }
        while (i < n) {
            i = 3 * i;
        }
        if (i == n)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int n = 129140163;

        System.out.println(isPowerOfThree(n));
    }
}
