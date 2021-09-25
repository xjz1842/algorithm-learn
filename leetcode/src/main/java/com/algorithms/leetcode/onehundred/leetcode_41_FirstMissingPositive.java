package com.algorithms.leetcode.onehundred;

public class leetcode_41_FirstMissingPositive {


    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0){
            return 1;
        }

        int len = nums.length;

        int[] newArr = new int[len + 1];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= len && nums[i] > 0) {
                newArr[nums[i]] = nums[i];
            }
        }

        int i = 1;
        for (; i < newArr.length; i++) {
            if (newArr[i] != i) {
                return i;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1};

        System.out.println(firstMissingPositive(arr));
    }
}
