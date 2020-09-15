package com.algorithms.leetcode.onehundred;

public class leetcode_16_ThreeSumClosest {


    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            return 0;

        int l = 0;
        int r = nums.length - 1;
        int closet = Integer.MAX_VALUE;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {

                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < closet) {
                        closet = Math.abs(nums[i] + nums[j] + nums[k] - target);
                        ans = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-55, -24, -18, -11, -7, -3, 4, 5, 6, 9, 11, 23, 33};
        System.out.println(threeSumClosest(arr, 0));
    }
}
