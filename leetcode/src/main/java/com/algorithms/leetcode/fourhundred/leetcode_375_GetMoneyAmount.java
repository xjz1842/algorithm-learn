package com.algorithms.leetcode.fourhundred;

public class leetcode_375_GetMoneyAmount {

    /**
     *  动态规划
     */
    public static int getMoneyAmount(int n) {
        if (n == 1){
            return 0;
        }
        //dp[i][j] 以i到j最坏情况下最小代价值
        int[][] dp = new int[n+1][n+1];
        //初始化
        dp[1][1] = 0;

        for(int len = 2; len <= n; len++){
            for(int i = 1; i <= (n - len + 1); i++){
                int minres = Integer.MAX_VALUE;
                //i + len-1 一共有 len个元素
                for(int pivot = i; pivot < (i + len-1); pivot++){
                    int res = pivot + Math.max(dp[i][pivot - 1], dp[pivot + 1][i + len - 1]);
                    minres = Math.min(res, minres);
                }
                dp[i][i + len - 1] = minres;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        System.out.println(getMoneyAmount(10));
    }
}
