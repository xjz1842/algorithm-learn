package com.algorithms.leetcode.fourhundred;


public class leetcode_300_LengthOfLIS {

    //动态规划
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //dp[i]  代表 [0..i-1]范围内的最大递增序列的长度
        int[] dp = new int[nums.length];

        // 初始化 1个元素，表示递增序列为1
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums));
    }
}
