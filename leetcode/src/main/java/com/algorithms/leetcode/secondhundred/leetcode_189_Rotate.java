package com.algorithms.leetcode.secondhundred;

public class leetcode_189_Rotate {

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] result = new int[nums.length];
        int i = nums.length - k;

        int index = 0;
        for (; i < nums.length; i++) {
            result[index++] = nums[i];
        }
        for (int m = 0; m < nums.length - k; m++) {
            result[index++] = nums[m];
        }
        for (i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    //O(N)
    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2};

        rotate(arr, 2);
        for (int a : arr) {
            System.out.println(a);
        }
    }

}
