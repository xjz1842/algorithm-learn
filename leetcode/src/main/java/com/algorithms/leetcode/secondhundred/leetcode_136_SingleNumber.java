package com.algorithms.leetcode.secondhundred;

public class leetcode_136_SingleNumber {

    public static int singleNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }


}
