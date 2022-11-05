package com.algorithms.leetcode.onehundred;

public class leetcode_74_SearchMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }

        int x = matrix.length;
        int y = matrix[0].length;
        if (y == 0){
            return false;
        } 

        int targetRow = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][y - 1] >= target) {
                targetRow = i;
                break;
            }
        }

        if (targetRow != -1) {
            int start = 0;
            int end = matrix[start].length - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (matrix[targetRow][mid] == target) {
                    return true;
                }
                if (matrix[targetRow][mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1}
        };
        System.out.println(searchMatrix(matrix, 1));
    }

}
