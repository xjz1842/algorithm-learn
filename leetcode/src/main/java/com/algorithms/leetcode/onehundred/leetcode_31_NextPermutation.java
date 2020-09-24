package com.algorithms.leetcode.onehundred;

public class leetcode_31_NextPermutation {

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        //找到第一个顺序对
        int i = 0;
        for (i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                break;
            }
        }

        if (i != 0) {
            for (int j = nums.length - 1; j >= i; j--) {
                if (nums[j] > nums[i - 1]) {
                    swap(nums, i - 1, j);
                    break;
                }
            }
        }
        //逆序交换i-1后
        for (int j = i, n = nums.length - 1; j < n; j++, n--) {
            swap(nums, j, n);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 7, 5, 3, 2};
        nextPermutation(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
