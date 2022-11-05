package com.algorithms.leetcode.fourhundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_368_LargestDivisibleSubset {

    /**
     * 动态规划
     */
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        //dp[i] 代表 0.。i范围最大最大整除个数
        int[] dp = new int[len];
        //排序
        Arrays.sort(nums);
        // 初始化
        Arrays.fill(dp,1);
        //记录最大整除集合的最大值
        int maxValue = nums[0];
        //最大个数
        int maxSize = 1;
        for(int i = 1; i < len; i++) {
            for(int j = 0; j < i; j++){
                //整除
                if(nums[i] % nums[j]  == 0){
                    dp[i] = Math.max(dp[i],dp[j] +1);
                }
            }
            if(dp[i] > maxSize){
                maxValue = nums[i];
                maxSize = dp[i];
            }
        }
        //遍历原数组找到答案
        List<Integer> ans = new ArrayList<>();
        if(maxSize == 1){
            ans.add(nums[0]);
            return ans;
        }
        //逆序求解 是因为dp[i] = 1位置是不唯一的
        for(int i = len-1;maxSize > 0 && i >= 0; i--){
            if(dp[i] == maxSize && maxValue % nums[i] == 0){
                  ans.add(nums[i]);
                  maxValue = nums[i];
                  maxSize--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,8,10,240};
        System.out.println(largestDivisibleSubset(nums));
    }
}
