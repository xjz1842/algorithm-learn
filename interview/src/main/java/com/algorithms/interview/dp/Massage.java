package com.algorithms.interview.dp;

/**
 * https://leetcode.cn/problems/the-masseuse-lcci/description/
 */
public class Massage {

    public static int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i] + (i >= 2 ? dp[i - 2] : 0), dp[i - 1]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(massage(nums));
    }

}
