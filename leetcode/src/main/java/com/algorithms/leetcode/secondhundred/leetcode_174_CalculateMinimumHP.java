package com.algorithms.leetcode.secondhundred;

public class leetcode_174_CalculateMinimumHP {

    public static int calculateMinimumHP(int[][] dungeon) {
        int X = dungeon.length;
        int Y = dungeon[0].length;

        int[][] dp = new int[X][Y];
        // i,j 到终点所需要的血量
        //首先以终点为目标, 终点--> 所需要的最小血量
        dp[X - 1][Y - 1] = Math.max(-dungeon[X - 1][Y - 1], 0);
        for (int i = X - 2; i >= 0; i--) {
            //最后一列
            dp[i][Y - 1] = Math.max(dp[i + 1][Y - 1] - dungeon[i][Y - 1], 0);
        }
        for (int j = Y - 2; j >= 0; j--) {
            //最后一行
            dp[X - 1][j] = Math.max(dp[X - 1][j + 1] - dungeon[X - 1][j], 0);
        }
        for (int i = X - 2; i >= 0; i--) {
            for (int j = Y - 2; j >= 0; j--) {
                dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 0);
            }
        }
        return dp[0][0] + 1;
    }

    public static void main(String[] args) {
        int[][] dungeon = new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}};
        System.out.println(calculateMinimumHP(dungeon));
    }

}
