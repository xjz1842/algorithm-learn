package com.algorithms.leetcode.sevenhundred;

public class leetcode_714_MaxProfit {

    public static int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len][2];
        // [0...i][j][0] 代表 0到i天，j次交易 在第i天卖出
        // [0...i][j][1] 代表0到i天，j次交易  在第i天持有
        //i-1天，交易0次，并且持有，就是-price
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);

            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[len - 1][0];
    }


    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};

        System.out.println(maxProfit(prices, 2));
    }


}
