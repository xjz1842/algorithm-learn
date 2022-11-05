package com.algorithms.leetcode.fourhundred;

public class leetcode_357_CountNumbersWithUniqueDigits {

    public static int countNumbersWithUniqueDigits(int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 10;
        }
        // dp[i]代表能 0到10的n次方内，有多少个不同数字的个数
       int[] dp = new int[n+1];
       //初始化 0 就 0这个元素
       dp[0] = 1;
       dp[1] = 10;
       for (int i = 2; i <= n; i++){
           // dp[i-1] 最高位没有
           // dp[i-1] - dp[i-2] 代表 i-1位组成的不同
          dp[i] = dp[i-1] + (dp[i-1] - dp[i-2]) * Math.max(0,10 - (i-1));
       }
       return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(countNumbersWithUniqueDigits(n));
    }
}


