package com.algorithms.leetcode;

public class MaxSubArray {

    public static int maxLength(int[] arr, int k) {
        int[] h = new int[arr.length + 1];
        int sum = 0;
        h[0] = sum;
        for (int i = 0; i != arr.length; i++) {
            sum += arr[i];
            h[i + 1] = Math.max(sum, h[i]);
        }
        sum = 0;
        int len = 0;
        int index = 0;
        int res = 0;
        for (int i : h) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            index = getLessIndex(h, sum - k);
            len = index == -1 ? 0 : i - index + 1;
            res = Math.max(res, len);
        }
        return res;
    }

    /**
     * 二分查找
     */
    public static int getLessIndex(int[] arr, int num) {
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        int res = -1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (arr[mid] >= num) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {3, -2, -4, 0, 6};
        System.out.println("result: " + maxLength(a, -2));
    }

}
