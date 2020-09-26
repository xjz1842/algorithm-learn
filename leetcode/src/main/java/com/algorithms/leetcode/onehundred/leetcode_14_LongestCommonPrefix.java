package com.algorithms.leetcode.onehundred;

public class leetcode_14_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int len = strs.length;
        StringBuilder prefixBuilder = new StringBuilder();
        String prefix = "";
        char[] chars = strs[0].toCharArray();

        for (int i = 0; i < chars.length; i++) {
            prefix = prefixBuilder.append(chars[i]).toString();
            for (int j = 1; j < len; j++) {
                if (!strs[j].startsWith(prefix)) {
                    return prefix.substring(0, prefix.length() - 1);
                }
            }
        }
        return prefix;
    }

}
