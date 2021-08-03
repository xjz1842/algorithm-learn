package com.algorithms.interview.sort;

public class ReversePairs {

    private int cnt = 0;

    private void msort(int[] a, int b, int e, int[] t) {
        if (b >= e || b + 1 >= e) {
            return;
        }
        final int m = b + ((e - b) >> 1);
        msort(a, b, m, t);
        msort(a, m, e, t);
        int i = b;
        int j = m;
        int to = b;
        while (i < m || j < e) {
            if (j >= e || i < m && a[i] <= a[j]) {
                t[to++] = a[i++];
                //i 和 (j-m) 中任意一个组成逆序对
                cnt += j - m;
            } else {
                t[to++] = a[j++];
            }
        }
        for (i = b; i < e; i++) {
            a[i] = t[i];
        }
    }

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int[] t = new int[nums.length];
        cnt = 0;
        msort(nums, 0, nums.length, t);
        return cnt;
    }

}
