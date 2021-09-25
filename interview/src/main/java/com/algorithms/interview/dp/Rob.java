package com.algorithms.interview.dp;


/**
 * 例 1：打劫
 * 【题目】你是一个专业的小偷，计划去沿街的住户家里偷盗。每间房内都藏有一定的现金，影响你偷盗的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。给定一个代表每个房屋存放金额的非负整数数组，要求你计算不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 输入：nums = [1,2,3,1]
 *
 * 输出：4
 * 解释：偷窃 nums[0] 号房屋 （金额 = 1），然后偷窃 nums[2]号房屋（金额 = 3）。偷窃到的最高金额 = 1 + 3 = 4
 */
public class Rob {

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

        for(int i = 1; i < len; i++){
            //地推关系
            // 分情况 1） 偷 i 那么就可以偷 i-2
            //       2) 不偷i 那么取 i-1
            // 两者取大，谁大偷谁
            dp[i] = Math.max((i-2 < 0 ? 0 : dp[i-2])+nums[i],dp[i-1]);
        }
        return dp[len-1];
    }

    public static void main(String[] args) {
       int[] nums = new int[]{1,2,3,1};
        System.out.println(rob(nums));
    }
}
