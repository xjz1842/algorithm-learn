package com.algorithms.leetcode.fourhundred;

public class leetcode_303_NumArray {

    private static long[] preproessArr;

    public leetcode_303_NumArray(int[] nums) {
        preproessArr = new long[nums.length];
        preproessArr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preproessArr[i] = preproessArr[i - 1] + nums[i];
        }
    }

    public  int sumRange(int left, int right) {
        if (left == 0) {
            return (int) preproessArr[right];
        }
        return (int) (preproessArr[right] - preproessArr[left - 1]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        leetcode_303_NumArray numArray = new leetcode_303_NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
    }
}
