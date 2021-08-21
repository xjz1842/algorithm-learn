package com.algorithms.leetcode.threehundred;

public class leetcode_258_AddDigits {

    public static int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        int sum = 0;
        while (num > 0) {
            int a = num % 10;
            sum = sum + a;
            num = num / 10;
            if (num == 0) {
                if (sum < 10) {
                    return sum;
                }
                num = sum;
                sum = 0;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int num = 38;
        System.out.println(addDigits(num));
    }
}
