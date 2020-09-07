package com.algorithms.leetcode.onehundred;


public class leetcode_44_IsMatch {

    public static boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;

        int y = s.length();
        int x = p.length();

        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();

        boolean[][] dp = new boolean[x + 1][y + 1];
        //[i][j] 表示 p到0...i匹配 匹配到前0...i，

        dp[0][0] = true;

        //处理以多个*出现
        for (int i = 1; i <= x; i++) {
            if (p.charAt(i - 1) != '*') {
                break;
            }
            dp[i][0] = true;
        }

        //转移方程
        // // s[i-1] == p[j-1] ||   p[j-1] == '?'
        // dp[i][j] = dp[i][j - 1] |  dp[i-1][j];
        for (int i = 1; i <= x; i++) {

            for (int j = 1; j <= y; j++) {

                if (ss[j - 1] == pp[i - 1] || pp[i - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (pp[i - 1] == '*') {
                    dp[i][j] = dp[i][j - 1] | dp[i - 1][j];
                }
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";

        System.out.println(isMatch(s, p));
    }
}
