package com.algorithms.leetcode.onehundred;

public class leetcode_08_MyAtoi {

    public static int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        if (str.startsWith("+-") || str.startsWith("+-")) {
            return 0;
        }
        while (str.startsWith(" ")) {
            str = str.substring(1);
        }
        if (str.startsWith("+")) {
            str = str.substring(1);
        }
        int sign = 1;
        if (str.startsWith("-")) {
            sign = -1;
            str = str.substring(1);
        }
        while (str.startsWith("0")) {
            str = str.substring(1);
        }
        if (str.isEmpty()) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int i = 0;
        if (!((chars[i] == '-' || (chars[i] >= '0' && chars[i] <= '9')))) {
            return 0;
        }
        StringBuilder result = new StringBuilder();
        while (i < chars.length) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                result.append(chars[i++]);
            } else {
                break;
            }
        }
        String ans = "";
        if (result.toString().startsWith("-")) {
            ans = result.substring(1);
        } else {
            ans = result.toString();
        }
        if (ans.isEmpty() || ans.contains(" ")) {
            return 0;
        }
        if (ans.length() > 10) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if (sign == -1) {
            return Long.parseLong(ans) > Integer.MAX_VALUE ? Integer.MIN_VALUE : sign * Integer.parseInt(ans);
        } else {
            return Long.parseLong(ans) > Integer.MAX_VALUE ? Integer.MAX_VALUE : sign * Integer.parseInt(ans);
        }
    }

    public static void main(String[] args) {
        String s = "-42";
        System.out.println(myAtoi(s));
    }
}
