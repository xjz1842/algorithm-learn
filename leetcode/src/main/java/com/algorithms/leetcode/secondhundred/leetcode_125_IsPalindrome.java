package com.algorithms.leetcode.secondhundred;

public class leetcode_125_IsPalindrome {

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        char[] arr = s.toCharArray();
        while (l < r) {
            if (!isValid(arr[l])) {
                l++;
            } else if (!isValid(arr[r])) {
                r--;
            } else if (String.valueOf(arr[l]).equalsIgnoreCase(String.valueOf(arr[r]))) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";

    }
}
