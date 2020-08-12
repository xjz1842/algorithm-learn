package com.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 */
public class leetcode_56_MergeArr {

    public static int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }

        Arrays.sort(intervals, (v1, v2) ->
                v1[0] - v2[0]);

        List<int[]> result = new ArrayList<>();

        int x1 = intervals[0][0];
        int y1 = intervals[0][intervals[0].length - 1];

        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            int x2 = intervals[i][0];
            int y2 = intervals[i][intervals[0].length - 1];

            //有交集，更新区间
            if (y1 < x2) {
                //搜集答案
                int[] res = new int[intervals[0].length];
                res[0] = x1;
                res[1] = y1;
                result.add(res);
                x1 = x2;
                y1 = y2;
            } else {
                y1 = Math.max(y1, y2);
            }
        }
        int[] finalRange = new int[intervals[0].length];
        finalRange[0] = x1;
        finalRange[1] = y1;
        result.add(finalRange);
        int size = result.size();

        int[][] res = new int[size][2];

        for (int i = 0; i < size; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public static void print(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%d \t", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 4}, {4, 5}
        };
        print(merge(arr));
    }
}
