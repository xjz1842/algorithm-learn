package com.algorithms.leetcode.secondhundred;


import java.util.ArrayList;
import java.util.List;

public class leetcode_151_ReverseWords {

    public static String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        char[] chars = (s + " ").toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        List<String> str = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ' || i == chars.length - 1) {
                if (!stringBuilder.toString().isEmpty()) {
                    str.add(stringBuilder.toString());
                    stringBuilder.delete(0, stringBuilder.length());
                }
                continue;
            } else {
                stringBuilder.append(chars[i]);
            }
        }
        int left = 0;
        int right = str.size() - 1;
        while (left < right) {
            String temp = str.get(left);
            str.set(left, str.get(right));
            str.set(right, temp);
            left++;
            right--;
        }
        StringBuilder ans = new StringBuilder();
        for (String i : str) {
            ans.append(i.trim()).append(" ");
        }
        return ans.substring(0, ans.length() - 1);
    }

    public static void main(String[] args) {
        String str = "a good   example";
        System.out.println(reverseWords(str));
    }
}
