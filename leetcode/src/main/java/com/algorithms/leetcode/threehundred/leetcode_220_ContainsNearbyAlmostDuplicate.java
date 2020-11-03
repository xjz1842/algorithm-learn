package com.algorithms.leetcode.threehundred;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class leetcode_220_ContainsNearbyAlmostDuplicate {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            int start = i - k >= 0 ? i - k : 0;
            int end = i + k >= nums.length ? nums.length : i + k;
            for (int j = start; j < end; j++) {
                if (i != j && Math.abs((long) nums[i] - (long) nums[j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > k) {
                set.remove((long) nums[i - k - 1]);
            }
            Long low = set.ceiling((long) nums[i] - t);
            //是否找到了符合条件的数
            if (low != null && low <= (long) nums[i] + t) {
                return true;
            }
            set.add((long) nums[i]);
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-2147483648, 2147483647};
        int k = 1;
        int t = 1;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }
}
