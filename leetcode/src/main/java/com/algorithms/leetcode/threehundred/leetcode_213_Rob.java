package com.algorithms.leetcode.threehundred;

public class leetcode_213_Rob {

    public static int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], (i - 2 >= 0 ? dp[i - 2] : 0) + nums[i]);
        }
        int[] dp1 = new int[nums.length];
        dp1[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], (i - 2 >= 0 ? dp1[i - 2] : 0) + nums[i]);
        }
        return Math.max(dp[nums.length - 1], dp1[nums.length - 2]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(rob(nums));
    }
}
