package com.algorithms.leetcode;

public class leetcode_70_ClimbStairs {

    public static int climbStairs(int n) {
        if (n == 0) return 0;

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[1] = 1;
            } else if (i == 2) {
                dp[2] = 2;
            } else dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
