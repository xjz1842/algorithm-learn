package com.algorithms.leetcode.onehundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_17_LetterCombinations {

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> ans = new ArrayList<>();

        procees(map, digits, 0, new StringBuilder(), ans);
        return ans;
    }

    public static void procees(Map<Character, String> map, String digit, int index, StringBuilder tmp, List<String> ans) {
        if (index == digit.length()) {
            ans.add(tmp.toString());
            return;
        }
        String s = map.get(digit.charAt(index));
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            tmp.append(arr[i]);
            procees(map, digit, index + 1, tmp, ans);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }


    public static void main(String[] args) {
        String s = "235";
        List<String> list = letterCombinations(s);

        for (String str : list) {
            System.out.println(str);
        }
    }
}
