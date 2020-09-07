package com.algorithms.leetcode.onehundred;

public class leetcode_84_LargestRectangleArea {


    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int len = heights.length;

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            //从两边扩到都小于heights[i
            int j = i;
            for (; j >= 0; j--) {
                if (heights[j] < heights[i]) {
                    break;
                }
            }
            int k = i;
            for (; k < len; k++) {
                if (heights[k] < heights[i]) {
                    break;
                }
            }
            //搜集答案
            int area = (k - j - 1) * heights[i];

            result = Math.max(area, result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }


}

