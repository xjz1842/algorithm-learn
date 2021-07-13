package com.algorithms.interview.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 不重叠区间
 * 【题目】给定一系列区间，请你选一个子集，使得这个子集里面区间都不相互重叠，并且这个子集里面元素个数最多。不重叠的定义：区间 [3,4] 和 [4,5] 就是不重叠。
 * 输入：A = [[1,2],[2, 3], [3,4], [1,3]
 *
 * 输出：3
 *
 * 解释：最多只能选出 3 个区间相互不重叠[1,2], [2,3], [3,4]。
 */
public class EraseOverlapIntervals {


    public static int nonOverlapIntervals(int[][] A) {

        final int N = A == null ? 0 : A.length;
        // 将区间进行排序
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] == b[1] ? 0 : (a[1] < b[1] ? -1 : 1);
            }
        });

        int ans = 0;
        int maxEnd = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            //开始大于maxEnd,则不重叠的区间+1
            //并更新maxEnd
            if (A[i][0] >= maxEnd) {
                ans++;
                maxEnd = A[i][1];
                continue;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
             };
        System.out.println(nonOverlapIntervals(a));
    }
}
