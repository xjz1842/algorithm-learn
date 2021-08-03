package com.algorithms.interview.sort;


/**
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 */
public class MergeArray {

    //不用申请数据的情况下
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail = n + m - 1;

        int i = m - 1;
        int j = n - 1;

        while ( i >= 0 || j >= 0){
            if (j < 0 || (i >= 0 && nums1[i] >= nums2[j])){
                nums1[tail--] = nums1[i--];
            }else{
                nums1[tail--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {

    }

}
