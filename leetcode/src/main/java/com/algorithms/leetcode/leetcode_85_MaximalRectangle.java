package com.algorithms.leetcode;

public class leetcode_85_MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        ;
        int HLen = matrix.length;
        int WLen = matrix[0].length;
        int[][] dp = new int[HLen][WLen];

        int maxArea = 0;

        for (int i = 0; i < HLen; i++) {
            for (int j = 0; j < WLen; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = (j == 0 ? 1 : (dp[i][j - 1] + 1));

                    int width = dp[i][j];
                    for (int k = i; k >= 0; k--) {
                        width = Math.min(dp[k][j], width);
                        maxArea = Math.max(maxArea, width * (i - k + 1));
                        if (maxArea == 10) {
                            System.out.println(maxArea);
                        }
                    }
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '1', '1'},
                {'0', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '1'},
                {'1', '1', '0', '1', '1'},
                {'0', '1', '1', '1', '1'}
        };
        System.out.println(maximalRectangle(matrix));
    }
}
