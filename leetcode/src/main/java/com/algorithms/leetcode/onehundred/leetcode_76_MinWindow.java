package com.algorithms.leetcode.onehundred;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
 */
public class leetcode_76_MinWindow {

    public static String minWindow(String s, String t) {
        if (s == null || t == null) {
            return null;
        }
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        int sLen = s.length();
        int tLen = t.length();

        if (tLen > sLen) {
            return "";
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Map<Character, Integer> tMap = new HashMap<>();
        int count = 0;
        for (int i = 0; i < tArr.length; i++) {
            if (tMap.containsKey(tArr[i])) {
                tMap.put(tArr[i], tMap.get(tArr[i]) + 1);
            } else {
                tMap.put(tArr[i], 1);
            }
            count++;
        }

        int endIndex = 0;
        int startIndex = 0;
        int minLen = Integer.MAX_VALUE;
        int resultStartIndex = -1;
        int resultEndIndex = -1;
        while (startIndex <= endIndex && endIndex < sArr.length) {
            if (tMap.containsKey(sArr[endIndex])) {
                Integer cnt = tMap.get(sArr[endIndex]) - 1;
                tMap.put(sArr[endIndex], cnt);
                if (cnt >= 0) {
                    count--;
                }
            }
            //代表第一次包含所有的字符串.左边窗口往右边走
            if (count == 0) {
                while (count == 0) {
                    if (!tMap.containsKey(sArr[startIndex])) {
                        startIndex++;
                    } else {
                        Integer cnt = tMap.get(sArr[startIndex]);
                        if ((cnt + 1) <= 0) {
                            tMap.put(sArr[startIndex], cnt + 1);
                            startIndex++;
                        } else {
                            break;
                        }
                    }
                }
                if (minLen > (endIndex - startIndex + 1)) {
                    resultStartIndex = startIndex;
                    resultEndIndex = endIndex;
                    minLen = endIndex - startIndex + 1;
                }
                //左边窗口往右移动
                tMap.put(sArr[startIndex], tMap.get(sArr[startIndex]) + 1);
                count++;
                startIndex++;
            }
            endIndex++;
        }
        if (resultStartIndex == -1) {
            return "";
        }
        return new String(Arrays.copyOfRange(sArr, resultStartIndex, resultEndIndex + 1));
    }

    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        System.out.println(minWindow(s, t));
    }

}
