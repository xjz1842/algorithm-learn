package com.algorithms.leetcode.fourhundred;

public class leetcode_304_NumMatrix {

    private static int[][] matrixSum;

    public leetcode_304_NumMatrix(int[][] matrix) {
        matrixSum = new int[matrix.length+1][matrix[0].length+1];
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            matrixSum = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrixSum[i + 1][j + 1] = matrixSum[i][j + 1] + matrixSum[i + 1][j] - matrixSum[i][j] + matrix[i][j];
                }
            }
        }
    }

    public  int sumRegion(int row1, int col1, int row2, int col2) {
        return matrixSum[row2+1][col2+1] - matrixSum[row1][col2+1] - matrixSum[row2+1][col1] + matrixSum[row1][col1];
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{
//                {3, 0, 1, 4, 2},
//                {5, 6, 3, 2, 1},
//                {1, 2, 0, 1, 5},
//                {4, 1, 0, 1, 7},
//                {1, 0, 3, 0, 5}};
        int[][] matrix = new int[][]{
                {-4,-5}};
        leetcode_304_NumMatrix mat = new leetcode_304_NumMatrix(matrix);
        System.out.println(mat.sumRegion(0,0,0,1));
//        System.out.println(mat.sumRegion(2, 1, 4, 3));
//        System.out.println(sumRegion(1, 1, 2, 2));
//        System.out.println(sumRegion(1, 2, 2, 4));
    }
}
