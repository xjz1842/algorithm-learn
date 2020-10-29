package com.algorithms.leetcode.threehundred;


public class leetcode_209_MinSubArrayLen {

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;

        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i <= nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (preSum[i] - preSum[j] >= s) {
                    minLen = Math.min(i - j, minLen);
                    break;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static int minSubArrayLen2(int s, int[] nums) {
        int left = 0;
        int right = 0;

        int result = 0;

        int minLen = Integer.MAX_VALUE;
        while (left <= right && right < nums.length) {
            result += nums[right];
            right++;
            while (result >= s) {
                minLen = Math.min(right - left, minLen);
                result = result - nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int s = 15;
        System.out.println(minSubArrayLen(s, nums));
        System.out.println(minSubArrayLen2(s, nums));
    }
}
