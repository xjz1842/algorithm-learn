package com.algorithms.leetcode.secondhundred;

public class leetcode_171_TitleToNumber {

    public static int titleToNumber(String s) {
        int result = 0;
        int carry = 1;
        if (s.length() >= 2) {
            for (int i = s.length() - 2; i >= 0; i--) {
                carry = carry * 26;
                result += carry * (s.charAt(i) - 'A' + 1);
            }
        }
        int offset = s.charAt(s.length() - 1) - 'A' + 1;
        result += offset;
        return result;
    }

    public static void main(String[] args) {
        String s = "ABA";
        System.out.println(titleToNumber(s));
    }

}
