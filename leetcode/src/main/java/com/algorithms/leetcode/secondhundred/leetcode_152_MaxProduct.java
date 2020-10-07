package com.algorithms.leetcode.secondhundred;

public class leetcode_152_MaxProduct {

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int min = 0;
        if (nums[0] > 0) {
            max = nums[0];
            min = nums[0];
        } else {
            max = nums[0];
            min = nums[0];
        }
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                max = Math.max(nums[i], max * nums[i]);
                min = Math.min(nums[i], min * nums[i]);
            } else {
                int maxT = Math.max(nums[i], min * nums[i]);
                int minT = Math.min(nums[i], max * nums[i]);
                max = maxT;
                min = minT;
            }
            ans = Math.max(max, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, -2, -9, -6};
        System.out.println(maxProduct(nums));
    }
}
