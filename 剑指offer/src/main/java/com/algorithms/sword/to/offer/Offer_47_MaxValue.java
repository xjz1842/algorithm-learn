package com.algorithms.sword.to.offer;

/**
 * @Author: zxj
 * @Date: 2022/11/14 9:05 AM
 */
public class Offer_47_MaxValue {


    public static int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == 0 && c == 0) {
                    dp[r][c] = grid[r][c];
                } else if (r == 0) {
                    dp[r][c] = dp[r][c - 1] + grid[r][c];
                } else if (c == 0) {
                    dp[r][c] = dp[r - 1][c] + grid[r][c];
                } else {
                    dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]) + grid[r][c];
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(maxValue(grid));
    }
}
