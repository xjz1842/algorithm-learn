package com.algorithms.leetcode.secondhundred;

public class leetcode_121_MaxProfit {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int l = 0; l < prices.length; l++) {
            for (int j = l; j < prices.length; j++) {
                if (prices[l] > prices[j]) {
                    continue;
                }
                int profit = (prices[j] - prices[l]);

                if (ans < profit) {
                    ans = profit;
                }
            }
        }
        return ans;
    }

    //动态规划 DP
    public static int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit0 = 0;
        int profit1 = -prices[0];
        for (int l = 1; l < prices.length; l++) {
            profit0 = Math.max(profit0, profit1 + prices[l]);
            profit1 = Math.max(profit1, -prices[l]);
        }
        return profit0;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit1(arr));

    }

}
