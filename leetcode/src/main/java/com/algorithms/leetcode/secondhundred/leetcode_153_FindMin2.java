package com.algorithms.leetcode.secondhundred;

public class leetcode_153_FindMin2 {

    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                r = r - 1;
            }
        }
        return nums[l];
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 2, 2, 2, 0, 1, 1};

        System.out.println(findMin(arr));
    }
}
