package com.algorithms.leetcode.onehundred;


public class leetcode_48_RotateMatrix {

    private static void rotate(int[][] matrix) {
        if (matrix.length <= 1) {
            return;
        }
        int n = matrix.length;
        int startLevel = 0;
        int endLevel = n - 1;
        int[] top = new int[n];
        int[] down = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        while (startLevel < endLevel) {
            //赋值右边侧
            for (int i = startLevel; i <= endLevel; i++) {
                top[i] = matrix[startLevel][i];
                down[i] = matrix[endLevel][i];
                left[i] = matrix[i][startLevel];
                right[i] = matrix[i][endLevel];
            }
            //赋值
            for (int i = startLevel, j = endLevel; i <= endLevel && j >= startLevel; i++, j--) {
                //right
                matrix[i][endLevel] = top[i];
                //down
                matrix[endLevel][j] = right[i];
                //left
                matrix[i][startLevel] = down[i];
                //top
                matrix[startLevel][j] = left[i];
            }
            print(matrix);
            startLevel++;
            endLevel--;
        }
    }

    private static void print(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%s\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};
        rotate(matrix);
    }
}
