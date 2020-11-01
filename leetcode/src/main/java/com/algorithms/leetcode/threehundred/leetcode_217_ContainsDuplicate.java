package com.algorithms.leetcode.threehundred;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class leetcode_217_ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Boolean> cache = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (cache.containsKey(nums[i])) {
                return true;
            } else {
                cache.put(nums[i], Boolean.TRUE);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }
}


