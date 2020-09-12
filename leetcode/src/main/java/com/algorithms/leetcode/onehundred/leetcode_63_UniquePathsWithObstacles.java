package com.algorithms.leetcode.onehundred;

public class leetcode_63_UniquePathsWithObstacles {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int x = obstacleGrid.length;
        int y = obstacleGrid[0].length;
        if (y == 0) {
            return 0;
        }
        int[][] dp = new int[x + 1][y + 1];
        if (obstacleGrid[0][0] == 1) {
            dp[0][0] = 0;
        } else {
            dp[0][0] = 1;
        }
        for (int i = 1; i < x; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int j = 1; j < y; j++) {
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[x - 1][y - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{
                {0, 1}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
