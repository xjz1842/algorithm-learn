package com.algorithms.leetcode.threehundred;

public class leetcode_238_ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            return new int[]{};
        }
        int[] answer = new int[nums.length];
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int R = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            answer[j] = answer[j] * R;
            R = R * nums[j];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        for (int i : productExceptSelf(nums)) {
            System.out.println(i);
        }
    }

}
