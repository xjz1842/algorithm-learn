package com.algorithms.leetcode.fourhundred;

public class leetcode_376_WiggleMaxLength {

    public static int wiggleMaxLength(int[] nums) {
        int up = 1;
        int down = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            //波缝
            if (nums[i] < nums[i+1]){
                 up = down + 1;
            }
            //波缝
            if (nums[i] > nums[i+1]){
                 down = up + 1;
            }
        }
        return Math.max(up,down);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength(nums));
    }
}
