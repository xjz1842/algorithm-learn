package com.algorithms.leetcode.secondhundred;

public class leetcode_167_TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null) {
            return new int[]{};
        }
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start + 1, end + 1};
            } else if (numbers[start] + numbers[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        for (int s : twoSum(nums, target)) {
            System.out.println(s);
        }
    }
}
