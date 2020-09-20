package com.algorithms.leetcode.onehundred;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class leetcode_01_TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numToIndex.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer index = numToIndex.get(target - nums[i]);
            if (index != null && index != i) {
                return new int[]{i, index};
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4};

        for (int i : twoSum(arr, 6)) {
            System.out.println(i);
        }
        File file = new File("/Users/zxj/github/algorithms/leetcode/src/main/java/com/algorithms/leetcode/onehundred");

        System.out.println(file.listFiles().length);
    }

}
