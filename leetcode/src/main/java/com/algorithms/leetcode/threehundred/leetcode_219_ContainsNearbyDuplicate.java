package com.algorithms.leetcode.threehundred;

import java.util.HashMap;
import java.util.Map;

public class leetcode_219_ContainsNearbyDuplicate {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> cache = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer key = cache.get(nums[i]);
            if (key != null && i - key <= k) {
                return true;
            } else {
                cache.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1, 2, 3};

        System.out.println(containsNearbyDuplicate(arr, 2));
    }

}
