package com.algorithms.leetcode.secondhundred;

public class leetcode_133_MinCut {

    public static int minCut(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = i;
        }
        //dp[i]表示0..i上最短分割几次
        for (int i = 0; i < arr.length; i++) {
            //以i为中心点往左右两边扩
            for (int j = 0; j <= i && i + j < arr.length; j++) {
                //奇数
                if (arr[i - j] == arr[i + j]) {
                    if (i == j) {
                        dp[i + j] = 0;
                    } else {
                        dp[i + j] = Math.min(dp[i - j - 1] + 1, dp[i + j]);
                    }
                } else {
                    break;
                }
            }
            for (int j = 1; j <= i + 1 && i + j < arr.length; j++) {
                //偶数
                if ((i - j + 1) >= 0 && arr[i - j + 1] == arr[i + j]) {
                    if ((i - j + 1) == 0) {
                        dp[i + j] = 0;
                    } else {
                        dp[i + j] = Math.min(dp[i - j + 1 - 1] + 1, dp[i + j]);
                    }
                } else {
                    break;
                }
            }
        }
        return dp[arr.length - 1];
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(minCut(s));
    }
}
