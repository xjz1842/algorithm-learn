package com.algorithms.leetcode;

public class leetcode_59_GenerateMatrix {

    public static int[][] generateMatrix(int n) {
        if (n == 0) return new int[][]{};
        int[][] result = new int[n][n];

        int startLevel = 0;
        int endLevel = n - 1;

        int count = 1;
        while (startLevel < endLevel) {
            //上边
            for (int i = startLevel; i <= endLevel; i++) {
                result[startLevel][i] = count++;
            }
            //右侧边
            for (int i = startLevel + 1; i <= endLevel; i++) {
                result[i][endLevel] = count++;
            }
            //底边
            for (int i = endLevel - 1; i >= startLevel; i--) {
                result[endLevel][i] = count++;
            }
            //左边
            for (int i = endLevel - 1; i > startLevel; i--) {
                result[i][startLevel] = count++;
            }
            startLevel++;
            endLevel--;
        }

        if (startLevel == endLevel) {
            result[startLevel][endLevel] = count;
        }
        return result;
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
        print(generateMatrix(5));
    }


}
