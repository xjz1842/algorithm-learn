package com.algorithms.leetcode.fourhundred;

public class leetcode_322_CoinChange {


    public static  int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0){
            return 0;
        }
        if (amount == 0) {
            return 0;
        }

        int inf = Integer.MAX_VALUE / 2;
        //动态规划 dp[i] 表示[0,i-1]已经有硬币组成好。
        int[] dp = new int[amount+1];
        for(int i = 1; i < dp.length; i++){
            dp[i] = inf;
        }
        //init
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                dp[i] = Math.min((i - coin) < 0 ? Integer.MAX_VALUE/2 : dp[i-coin]+1,dp[i]);
            }
        }
        return dp[amount] == inf ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{2};
        int amount = 3;
        System.out.println(coinChange(coins,amount));
    }
}
