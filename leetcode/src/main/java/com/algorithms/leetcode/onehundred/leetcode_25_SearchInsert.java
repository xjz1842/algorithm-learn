package com.algorithms.leetcode.onehundred;

public class leetcode_25_SearchInsert {

    public static int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};

        System.out.println(searchInsert(nums, 2));
    }
}
