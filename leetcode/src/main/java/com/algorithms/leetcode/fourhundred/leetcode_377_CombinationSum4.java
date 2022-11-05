package com.algorithms.leetcode.fourhundred;


public class leetcode_377_CombinationSum4 {

    private static  int count = 0;

    public static  int combinationSum4(int[] nums, int target) {
         if(nums == null || nums.length == 0){
             return 0;
         }
         dfs(nums,0,target);
         return count;
    }

    private static void dfs(int[] nums,int sum,int target) {
        if(sum == target){
            count++;
        }
        if(sum > target){
            return;
        }
        for(int num : nums) {
            sum += num;
            dfs(nums, sum, target);
            sum -= num;
        }
    }

    /**
     *  动态规划
     */
    public static  int combinationSum41(int[] nums, int target) {
        int[] dp = new int[target + 1];
        //初始化
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
       int[] nums = new int[]{4,2,1};
       int target = 32;
        System.out.println(combinationSum4(nums,target));
    }
}
