package com.algorithms.leetcode.onehundred;


public class leetcode_32_LongestValidParentheses {

    //动态规划
    private static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0){
            return 0;
        } 
        char[] ss = s.toCharArray();

        int len = ss.length;
        //dp 转移方程
        //dp[i] 表示0到i上最大有效括号数
        // 1）ss[i] = ')' 则等于 ss[i-dp[i-1]-1] = '('
        //   dp[i] = dp[i-1] + 2;  (())
        //   ss[i] = ')
        // 2) i-dp[i-1]-1 : dp[i] = 0
        int[] dp = new int[len + 1];

        dp[0] = 0;

        int result = 0;
        for (int i = 1; i < len; i++) {
            if (ss[i] == '(') {
                dp[i] = 0;
            }
            if (ss[i] == ')') {
                if (ss[i - 1] == '(') {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                } else if ((i - dp[i - 1] - 1) >= 0) {
                    if (ss[i - dp[i - 1] - 1] == '(') {
                        dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 2)
                                >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                    } else {
                        dp[i] = 0;
                    }
                }
            }
            if (result < dp[i]) {
                result = dp[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "(()))())(";
        System.out.println(longestValidParentheses(str));
    }
}
