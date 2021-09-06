package com.algorithms.leetcode.threehundred;

import java.util.Arrays;

public class leetcode_287_FindDuplicate {


    public static int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int target = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == target){
                return nums[i];
            }else{
                target = nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }
}
