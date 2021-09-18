package com.algorithms.leetcode.fourhundred;

public class leetcode_318_MaxProduct {

    /**
     * 使用二进制处理
     */
    public static int maxProduct(String[] words) {
        if (words == null || words.length == 1) {
            return 0;
        }
        //预处理
        int[] bits = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            int num = 0;
            for (int j = 0; j < words[i].length(); j++) {
                num |= 1 << (words[i].charAt(j) - 'a');
            }
            bits[i] = num;
        }

        int max = 0;
        for (int i = 0; i < bits.length; i++) {
            for (int j = i + 1; j < bits.length; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String[] words = new String[]{
                "a","aa","aaa","aaaa"
        };
        System.out.println(maxProduct(words));
    }
}
