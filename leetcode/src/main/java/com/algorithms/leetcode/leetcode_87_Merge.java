package com.algorithms.leetcode;


import java.util.List;

public class leetcode_87_Merge {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length == 0) {
            return;
        }
        if (nums2 == null || nums2.length == 0) {
            return;
        }
        int[] newArr = new int[m + n];

        int index1 = 0;
        int index2 = 0;
        int newIndex = 0;
        while (index1 < m && index2 < n) {
            if (nums1[index1] < nums2[index2]) {
                newArr[newIndex] = nums1[index1];
                index1++;
            } else {
                newArr[newIndex] = nums2[index2];
                index2++;
            }
            newIndex++;
        }
        while (index1 < m) {
            newArr[newIndex++] = nums1[index1];
            index1++;
        }
        while (index2 < n) {
            newArr[newIndex++] = nums2[index2];
            index2++;
        }

        for (int i = 0; i < newArr.length; i++) {
            nums1[i] = newArr[i];
        }

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 0};
        int[] nums2 = new int[]{1};
        merge(nums1, 1, nums2, 1);

        for (Integer i : nums1) {
            System.out.println(i);
        }
    }
}
