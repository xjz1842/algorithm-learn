package com.algorithms.leetcode.onehundred;

public class leetcode_73_SetZeroes {

    public static void setZeroes(int[][] matrix) {
        boolean rowFlag = false;
        boolean colFlag = false;
        int lenX = matrix.length;
        int lenY = matrix[0].length;

        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                if (i == 0) {
                    if (matrix[i][j] == 0) {
                        rowFlag = true;
                    }
                }
                if (j == 0) {
                    if (matrix[i][j] == 0) {
                        colFlag = true;
                    }
                }
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int j = 1; j < lenY; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < lenX; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < lenX; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < lenY; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowFlag == true) {
            for (int j = 0; j < lenY; j++) {
                matrix[0][j] = 0;
            }
        }
        if (colFlag == true) {
            for (int i = 0; i < lenX; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void print(int[][] matrix) {
        int lenX = matrix.length;
        int lenY = matrix[0].length;
        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                System.out.printf("%d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        setZeroes(nums);
        print(nums);
    }

}
