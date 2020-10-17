package com.algorithms.leetcode.secondhundred;

import java.util.ArrayList;
import java.util.List;

public class leetcode_131_Partition {

    private static int min = 0;

    public static List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        char[] arr = s.toCharArray();
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        process(arr, 0, list, result);
        return result;
    }

    public static void process(char[] s, int index, List<String> temp, List<List<String>> result) {
        if (index == s.length) {
            result.add(new ArrayList<>(temp));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = index; i < s.length; i++) {
            stringBuilder.append(s[i]);
            if (isValid(stringBuilder.toString())) {
                temp.add(stringBuilder.toString());
                process(s, index + stringBuilder.length(), temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static boolean isValid(String s) {
        int l = 0;
        int r = s.length() - 1;

        char[] chars = s.toCharArray();
        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        for (List<String> list : partition(s)) {
            System.out.println(list);
        }
    }
}
