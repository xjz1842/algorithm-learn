package com.algorithms.leetcode.fourhundred;

public class Leetcode_338_CountBits {

    public static int[] countBits(int n) {
        int[] ans = new int[n+1];

        for (int i = 0; i <= n; i++) {
            int count = 0;
            int t = i;
            while (t > 0) {
                int leftOne = t & (-t);
                t = t - leftOne;
                count += 1;
            }
            ans[i] = count;
        }
        return ans;
    }

    //动态规划
    public static int[] countBits1(int n) {
        int[] dp = new int[n + 1];
        //初始化
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i >> 1] + ((i & 1) == 1 ? 1 : 0);
        }
        return dp;
    }

    public static void main(String[] args) {
        int n = 5;
        for (int i : countBits(n)) {
            System.out.println(i);
        }
    }
}
