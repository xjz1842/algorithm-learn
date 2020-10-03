package com.algorithms.leetcode.secondhundred;

public class leetcode_122_MaxProfit {

    //DP尽可能完成多的交易
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len][2];
        // [0...i][0] 代表 0到i天，在第i天卖出
        // [0...i][1] 代表0到i天，在第i天持有
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], (dp[i - 1][1] + prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

    //一次遍历
    private int maxProfit2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1};

        System.out.println(maxProfit(arr));
    }

}
