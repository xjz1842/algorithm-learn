package com.algorithms.leetcode.fourhundred;

import java.util.Arrays;

public class leetcode_334_IncreasingTriplet {

    public static boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        //动态规划
        int[] dp = new int[len];
        //初始哈
        Arrays.fill(dp, 1);
        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            if(dp[i] >= 3){
                return true;
            }
        }
        return false;
    }

    /**
     * 贪心
     */
    public static boolean increasingTriplet1(int[] nums) {
        if(nums.length < 3) {
            return false;
        }

        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for(int i : nums){
            if(i > mid){
                return true;
            }
            if(i <= min){
                min = i;
            }else {
                mid = i;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,5,0,4,6};
        System.out.println(increasingTriplet(nums));
    }
}
