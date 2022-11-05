package com.algorithms.leetcode.fourhundred;

public class leetcode_343_IntegerBreak {

    /**
     * 动态规划
     */
    public static int integerBreak(int n) {
        // dp[i] 代表整数拆分最大值
        int[] dp = new int[n + 1];
        //初始化 0 1是不可拆分，为0
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // [0,i] 区间拆分成 s1 s2两个区间
                int s1 = (i - j);
                int max = Math.max(Math.max(Math.max(dp[s1] * dp[j], s1 * dp[j]), dp[s1] * j), s1 * j);
                dp[i] = Math.max(dp[i],max);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(integerBreak(n));
    }
}
