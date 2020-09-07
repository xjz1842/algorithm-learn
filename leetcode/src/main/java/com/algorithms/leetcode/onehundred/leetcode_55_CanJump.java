package com.algorithms.leetcode.onehundred;

public class leetcode_55_CanJump {
    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个位置。
     */
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int len = nums.length;
        boolean[] dp = new boolean[len];

        if (nums[0] >= 0) {
            dp[0] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {

                if (j < i && ((j + nums[j]) >= i)) {
                    if (dp[j])
                        dp[i] = true;
                    break;
                }
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0};

        System.out.println(canJump(arr));
    }

}
