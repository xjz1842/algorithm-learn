package com.algorithms.leetcode.fourhundred;

public class leetcode_393_IsSubsequence {

    /**
     *  DFS 深度优先遍历
     */
    public static boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() > t.length()) {
            return false;
        }
        return dfs(s.toCharArray(), 0, t.toCharArray(), 0, 0);
    }

    /**
     * @param s     s 数组
     * @param i     从 i开始遍历
     * @param t     t数组
     * @param k     从k开始偏离
     * @param count 已经匹配的字符个数
     * @return 是否子子序列
     */
    private static boolean dfs(char[] s, int i, char[] t, int k, int count) {
        if (count == s.length) {
            return true;
        }

        for (int start = k; start < t.length; start++) {
            if (s[i] == t[start]) {
                if (dfs(s, i + 1, t, start + 1, count + 1)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String s = "axcbb";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}
