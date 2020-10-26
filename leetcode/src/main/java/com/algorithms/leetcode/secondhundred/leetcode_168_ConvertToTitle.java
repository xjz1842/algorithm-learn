package com.algorithms.leetcode.secondhundred;

public class leetcode_168_ConvertToTitle {


    //
    public static String convertToTitle(int n) {

        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n -= 1;
            result.append((char) ('A' + (n % 26)));
            n /= 26;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        int n = 703;
        System.out.println(convertToTitle(n));
    }

}
