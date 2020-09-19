package com.algorithms.leetcode.onehundred;

import java.util.HashMap;
import java.util.Map;

public class leetcode_03_LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        char[] charArr = s.toCharArray();

        int max = 1;
        while (start <= end && end < charArr.length) {
            if (!map.containsKey(charArr[end])) {
                map.put(charArr[end], 1);
                end++;
            } else {
                max = max < (end - start) ? (end - start) : max;
                map.remove(charArr[start]);
                start++;
            }
        }
        if (end == charArr.length) {
            max = max < (end - start) ? (end - start) : max;
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "au";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
