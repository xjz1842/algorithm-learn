package com.algorithms.interview.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 *
 * https://leetcode-cn.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (42.96%)
 * Likes:    1160
 * Dislikes: 0
 * Total Accepted:    201.9K
 * Total Submissions: 469.8K
 * Testcase Example:  '[1,2,5]\n11'
 *
 * 给定不同面额的硬币 coins 和一个总金额
 * amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 *
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 * 示例 4：
 *
 * 输入：coins = [1], amount = 1
 * 输出：1
 *
 * 示例 5：
 *
 * 输入：coins = [1], amount = 2
 * 输出：2
 *
 *
 */

public class CoinChange {

    private static int INF = Integer.MAX_VALUE >> 2;

    private static Map<Integer, Integer> countMap = new HashMap<>();

    private static void build(int[] A) {
        for (int x : A) {
            countMap.put(x, 1);
        }
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount < 0){
            return -1;
        }
        if (amount == 0){
            return 0;
        }
        build(coins);

        int ans = dfs(coins, amount);

        return ans >= INF ? -1 : ans;
    }

    private static int dfs(int[] a, int t) {
        if (t < 0) {
            return INF;
        }
        if (countMap.containsKey(t)) {
            return countMap.get(t);
        }
        int ans = INF;

        for (int x : a) {
            ans = Math.min(ans, dfs(a, t - x)+1);
        }
        countMap.put(t, ans);

        return ans;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }
}
