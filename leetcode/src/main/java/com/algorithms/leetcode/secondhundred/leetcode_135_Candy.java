package com.algorithms.leetcode.secondhundred;

public class leetcode_135_Candy {

    public static int candy(int[] ratings) {
        int[] dp = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        for (int i = dp.length - 1; i >= 1; i--) {
            if (ratings[i] < ratings[i - 1]) {
                if (dp[i] >= dp[i - 1]) {
                    dp[i - 1] = dp[i] + 1;
                }
            }
        }

        int sum = 0;
        for (int i : dp) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {

    }


}
