package com.algorithms.interview.dp;

/**
 * 【题目】给定不同面额的硬币 coins 和一个总金额 amount，需要你编写一个函数计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，则返回 -1。你可以认为每种硬币的数量是无限的。
 * <p>
 * 输入：coins = [1, 2, 5]，amount = 11
 * <p>
 * 输出：3
 * <p>
 * 解释：11 元可以拆分为 5 + 5 + 1，这是最少的硬币数目。
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        // 没有解的时候，设置一个较大的值
        final int INF = Integer.MAX_VALUE / 4;
        //线性dp
        int[] dp = new int[amount + 1];
        for(int i = 0; i < dp.length; i++){
            dp[i] = INF;
        }
        //初始化，代表0好需要0个硬币组成
        dp[0] = 0;
        //填二维表格 复杂度 O(amout * N)
        for (int i = 0; i < amount; i++) {
            for (int y : coins) {
                if(y <= amount && i+y < amount && i+y >= 0) {
                    dp[i + y] = Math.min(dp[i + y], dp[i] + 1);
                }
            }
        }
        return dp[amount] >= INF ? -1 : dp[amount];
    }


}
