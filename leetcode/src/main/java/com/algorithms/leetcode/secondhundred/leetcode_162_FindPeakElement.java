package com.algorithms.leetcode.secondhundred;

public class leetcode_162_FindPeakElement {

    public static int findPeakElement(int[] nums) {
        if (nums == null) {
            return 0;
        }
        long pre = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 == nums.length) {
                if (nums[i] > pre) {
                    return i;
                }
            }
            if (nums[i] > pre && nums[i] > nums[i + 1]) {
                return i;
            } else {
                pre = nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2147483648, -2147483647};

        System.out.println(findPeakElement(nums));
    }


}
