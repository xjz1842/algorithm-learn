package com.algorithms.leetcode.secondhundred;

public class leetcode_188_MaxProfit {

    public static int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        //当k非常大时转为无限次交易
        if (k >= len / 2) {
            int dp0 = 0, dp1 = -prices[0];
            for (int i = 1; i < len; ++i) {
                dp0 = Math.max(dp0, dp1 + prices[i]);
                dp1 = Math.max(dp1, dp0 - prices[i]);
            }
            return Math.max(dp0, dp1);
        }
        int[][] dp = new int[k + 1][2];
        // [0...i][j][0] 代表 0到i天，最多j次交易 在第i天卖出
        // [0...i][j][1] 代表0到i天，最多j次交易  在第i天持有
        //i-1天，交易0次，并且持有，就是-price
        for (int i = 0; i <= k; i++) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = k; j >= 1; j--) {
                //处理第k次买入
                dp[j - 1][1] = Math.max(dp[j - 1][0] - prices[i], dp[j - 1][1]);
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] + prices[i]);
            }
        }
        return dp[k][0];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 6, 5, 0, 3};

        System.out.println(maxProfit(2, arr));
    }
}
