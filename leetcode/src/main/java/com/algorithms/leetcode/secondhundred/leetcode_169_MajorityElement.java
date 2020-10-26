package com.algorithms.leetcode.secondhundred;

public class leetcode_169_MajorityElement {

    public static int majorityElement(int[] nums) {

        int target = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (target == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                target = nums[i];
                count = 0;
            }
        }
        return target;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 9, 9, 10};
        System.out.println(majorityElement(arr));
    }
}
