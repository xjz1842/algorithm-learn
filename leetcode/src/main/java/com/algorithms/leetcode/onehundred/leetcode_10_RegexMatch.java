package com.algorithms.leetcode.onehundred;


public class leetcode_10_RegexMatch {

    //动态规划
    public static boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen == 0 && pLen == 0) {   // 边界特判
            return true;
        }
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();

        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        //dp[i][j]表示s的0到i-1和p的0到j-1是否匹配

        if (pp[0] == '*') return false;  // 星号前面没有其他字符是非法的状态

        dp[0][0] = true;

        for (int j = 1; j < pLen + 1; j++) {
            if (pp[j - 1] == '*')
                dp[0][j] = dp[0][j - 2];
        }

        //初始化s=0
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (ss[i - 1] == pp[j - 1] || pp[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pp[j - 1] == '*') {
                    if (pp[j - 2] == ss[i - 1] || pp[j - 2] == '.') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[sLen][pLen];
    }

    //匹配. *
    public static void main(String[] args) {
        String s = "aaaaaab";
        String p = "a*b";

        System.out.println(isMatch(s, p));
    }
}
