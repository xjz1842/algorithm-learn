package com.algorithms.leetcode.threehundred;

import java.util.Arrays;

public class leetcode_279_NumSquares {

    /**
     * 动态规划
     */
    public static int numSquares(int n) {
         if(n == 1){
             return 1;
         }
         //[i]表示i最少完全平方数的个数
         int[] dp = new int[n+1];
         Arrays.fill(dp,Integer.MAX_VALUE/2);
         //初始化
         dp[0] = 0;
         dp[1] = 1;
         for(int i = 1; i <= n; i++){
            int k = 1;
            int s =  k * k;
            while(s <= i){
                dp[i] = Math.min(dp[i-s]+1, dp[i]);
                k++;
                s = k * k;
            }
         }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(numSquares(n));
    }
}
