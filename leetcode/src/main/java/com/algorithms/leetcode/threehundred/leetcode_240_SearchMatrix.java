package com.algorithms.leetcode.threehundred;


public class leetcode_240_SearchMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int i = 0;
        int len = matrix.length;
        for (i = 0; i < len; i++) {
            if (matrix[i][0] > target) {
                return false;
            } else {
                int l = 0;
                int r = matrix[i].length - 1;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (matrix[i][mid] == target) {
                        return true;
                    } else if (matrix[i][mid] > target) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 20;
        System.out.println(searchMatrix(matrix, target));
    }

}
