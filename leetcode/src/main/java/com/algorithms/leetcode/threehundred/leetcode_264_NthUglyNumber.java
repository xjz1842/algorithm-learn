package com.algorithms.leetcode.threehundred;

public class leetcode_264_NthUglyNumber {

    public static int nthUglyNumber(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        //dp[i] 代表有i个丑数下，值是[1,value]区间有i个丑数
        int[] dp = new int[n + 1];
        //初始化
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            //取最小值
            dp[i] = Math.min(Math.min(num2, num3), num5);

            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        int n = 1352;
        System.out.println(nthUglyNumber(n));
    }
}
