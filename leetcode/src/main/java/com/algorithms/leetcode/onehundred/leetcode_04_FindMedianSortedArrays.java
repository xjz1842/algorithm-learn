package com.algorithms.leetcode.onehundred;

public class leetcode_04_FindMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //首先找到第一个和第二个中位数
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] temp = null;
        //让len1短
        if (len1 > len2) {
            temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            len1 = nums1.length;
            len2 = nums2.length;
        }
        int l = 0;
        int r = nums1.length;
        int j = 0;

        while (l <= r) {
            int i = (l + r) / 2;
            j = (len1 + len2 + 1) / 2 - i;

            if (i > 0 && j < len2 && nums1[i - 1] > nums2[j]) {
                r = i - 1;
            } else if (j > 0 && i < len1 && nums1[i] < nums2[j - 1]) {
                l = i + 1;
            } else {
                int maxleft = 0;
                if (i == 0) {
                    maxleft = nums2[j - 1];
                } else if (j == 0) {
                    maxleft = nums1[i - 1];
                } else {
                    maxleft = Math.max(nums2[j - 1], nums1[i - 1]);
                }
                if (((len1 + len2) & 1) == 1) {
                    return maxleft;
                }
                int minRight = 0;
                if (j == len2) {
                    minRight = nums1[i];
                } else if (i == len1) {
                    minRight = nums2[j];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (double) (maxleft + minRight) / 2.0;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3};
        int[] arr2 = new int[]{2, 7};

        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}
