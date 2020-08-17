package com.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_57_InsertArr {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null) {
            return new int[][]{};
        }
        if (intervals.length == 0 && newInterval != null) {
            return new int[][]{newInterval};
        }

        int[][] copy = new int[intervals.length + 1][2];

        int i = 0;
        for (; i < intervals.length; i++) {
            copy[i] = intervals[i];
        }
        copy[i] = newInterval;

        Arrays.sort(copy, (v1, v2) ->
                v1[0] - v2[0]);

        List<int[]> result = new ArrayList<>();

        int x1 = copy[0][0];
        int y1 = copy[0][copy[0].length - 1];

        int index = 0;
        for (i = 1; i < copy.length; i++) {
            int x2 = copy[i][0];
            int y2 = copy[i][copy[0].length - 1];

            //有交集，更新区间
            if (y1 < x2) {
                //搜集答案
                int[] res = new int[copy[0].length];
                res[0] = x1;
                res[1] = y1;
                result.add(res);
                x1 = x2;
                y1 = y2;
            } else {
                y1 = Math.max(y1, y2);
            }
        }
        int[] finalRange = new int[copy[0].length];
        finalRange[0] = x1;
        finalRange[1] = y1;
        result.add(finalRange);
        int size = result.size();

        int[][] res = new int[size][2];

        for (i = 0; i < size; i++) {
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
        };
        int[] newInterval = new int[]{5, 7};

        print(insert(arr, newInterval));
    }

}
