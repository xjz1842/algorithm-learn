package com.algorithms.leetcode.secondhundred;

import java.util.HashSet;
import java.util.Set;

public class leetcode_128_LongestConsecutive {

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int maxLen = Integer.MIN_VALUE;
        for (int i : nums) {
            if (!set.contains(i - 1)) {
                int len = 1;
                while (set.contains(i)) {
                    i = i + 1;
                    len++;
                }
                maxLen = Math.max(len, maxLen);
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 100};
        System.out.println(longestConsecutive(nums));
    }
}
