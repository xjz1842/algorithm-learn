package com.algorithms.leetcode.fourhundred;

public class leetcode_312_MaxCoins {

    public static int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length + 2];

        newNums[0] = 1;
        newNums[nums.length + 1] = 1;

        for (int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }
        int n = newNums.length;
        //dp  (i,j) 区间的金币数
        int[][] dp = new int[n][n];

        for (int len = 3; len <= n; len++) {
            // i from o .. (n-len)
            for (int i = 0; i <= (n - len); i++) {
                int res = 0;
                //   //循环 k in (i,i+len-1) 开区间
                for (int k = i + 1; k < (i + len-1); k++) {
                    int left = dp[i][k];
                    int right = dp[k][i + len - 1];
                    res = Math.max(res, left + newNums[i] * newNums[k] * newNums[i + len - 1] + right);
                    dp[i][i + len - 1] = res;
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 5, 8};
        System.out.println(maxCoins(nums));
    }
}
