package com.algorithms.leetcode.onehundred;

import java.util.ArrayList;
import java.util.List;

public class leetcode_54_SpiralOrder {

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        int x = matrix.length;
        int y = matrix[0].length;

        int startRow = 0;
        int startCol = 0;
        int endRow = x - 1;
        int endCol = y - 1;
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (startRow < endRow && startCol < endCol) {
            //上边
            i = startCol;
            for (; i < endCol; i++) {
                result.add(matrix[startRow][i]);
            }

            //右侧边
            i = startRow;
            for (; i < endRow; i++) {
                result.add(matrix[i][endCol]);
            }
            //底边
            i = endCol;
            for (; i > startCol; i--) {
                result.add(matrix[endRow][i]);
            }
            //左侧边
            i = endRow;
            for (; i > startRow; i--) {
                result.add(matrix[i][startCol]);
            }
            startCol++;
            startRow++;
            endRow--;
            endCol--;
        }

        if (startRow == endRow) {
            for (i = startCol; i <= endCol; i++) {
                result.add(matrix[startRow][i]);
            }
        } else if (startCol == endCol) {
            for (i = startRow; i <= endRow; i++) {
                result.add(matrix[i][startCol]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(spiralOrder(arr));
    }
}
