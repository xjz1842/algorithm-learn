package com.algorithms.interview.dp;

/**
 * 练习题 1：你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方的所有房屋都围成一
 * 圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下 ，
 * 能够偷窃到的最高金额。
 *
 * 输入：nums = [2,3,2]
 *
 * 输出：3
 *
 * 解释：你不能先偷窃 nums[0] 号房屋（金额 = 2），然后偷窃 nums[2] 号房屋（金额 = 2）, 因为他们是相邻的。最大收益是偷取nums[1]=3。
 */
public class Rob1 {

    public static int rob(int[] nums){
        //边界
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        //线性DP
        int[] dp = new int[len];

        //初始化条件 防止负数 初始偷偷一个
        dp[0] = Math.max(nums[0],0);
        //末尾不偷
        for(int i = 1; i < len-1; i++){
            //地推关系
            // 分情况 1） 偷 i 那么就可以偷 i-2
            //       2) 不偷i 那么取 i-1
            // 两者取大，谁大偷谁
            dp[i] = Math.max((i-2 < 0 ? 0 : dp[i-2])+nums[i],dp[i-1]);
        }
        int result1 = dp[len-2];
        //清除上一次的值
        for(int i = 0; i < len; i++){
            dp[i] = 0;
        }
        //初始化条件 防止负数 初始偷偷一个
        dp[1] = Math.max(0,nums[1]);
        //末尾不偷
        for(int i = 2; i < len; i++){
            //地推关系
            // 分情况 1） 偷 i 那么就可以偷 i-2
            //       2) 不偷i 那么取 i-1
            // 两者取大，谁大偷谁
            dp[i] = Math.max((i-2 < 0 ? 0 : dp[i-2])+nums[i],dp[i-1]);
        }
        return Math.max(result1,dp[len-1]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,2};
        System.out.println(rob(nums));
    }
}
