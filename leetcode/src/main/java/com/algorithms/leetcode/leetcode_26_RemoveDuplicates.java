package com.algorithms.leetcode;

public class leetcode_26_RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        if (nums.length == 1) return 0;

        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i + 1;
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;


        int i = 0;
        int j = 0;

        while (j < nums.length) {

            if (nums[j] != val) {
                nums[i++] = nums[j++];
            } else {
                j++;
            }
        }
        return i;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{2};

        int res = removeElement(arr, 3);

        System.out.println(res);

        for (int i = 0; i < res; i++) {
            System.out.println(arr[i]);
        }
    }


}
