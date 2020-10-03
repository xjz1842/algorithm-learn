package com.algorithms.leetcode.secondhundred;

public class leetcode_123_MaxProfit {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[][][] dp = new int[len][3][2];
        // [0...i][j][0] 代表 0到i天，j次交易 在第i天卖出
        // [0...i][j][1] 代表0到i天，j次交易  在第i天持有
        //i-1天，交易0次，并且持有，就是-price
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            for (int j = 2; j >= 1; j--) {
                dp[i][j][0] = Math.max(dp[i - 1][j][1] + prices[i], dp[i - 1][j][0]);

                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][2][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices));
    }
}
