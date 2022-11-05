package com.algorithms.leetcode.fourhundred;

import java.util.*;

public class leetcode_350_Intersect {

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[]{};
        }
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            cache.merge(nums1[i], 1, (oldValue, value) -> oldValue + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            Integer newValue = cache.merge(nums2[i], -1, (oldValue, value) -> oldValue - 1);
            if (newValue < 0) {
                continue;
            }
            ans.add(nums2[i]);
        }
        int size = ans.size();
        ;
        int[] res = new int[size];
        if (size == 0) {
            return res;
        }
        int index = 0;
        for (Integer i : ans) {
            res[index++] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{9, 4, 9, 8, 4};
        int[] nums2 = new int[]{4, 9, 5};

        for (int i : intersect(nums1, nums2)) {
            System.out.println(i);
        }
    }
}
