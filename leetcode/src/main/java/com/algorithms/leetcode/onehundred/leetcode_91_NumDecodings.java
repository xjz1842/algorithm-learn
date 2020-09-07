package com.algorithms.leetcode.onehundred;

public class leetcode_91_NumDecodings {

    public static int numDecodings(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        char[] sArr = s.toCharArray();
        int[] dp = new int[sArr.length];

        //初始值
        if (sArr[0] == '0') {
            dp[0] = 0;
            return 0;
        } else {
            dp[0] = 1;
        }
        for (int i = 1; i < sArr.length; i++) {
            if (sArr[i] == '0') {
                if (sArr[i - 1] == '1' || sArr[i - 1] == '2') {
                    dp[i] = i >= 2 ? dp[i - 2] : 1;
                } else {
                    dp[i] = 0;
                }
            } else if (sArr[i - 1] == '1') {
                dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
            } else if (sArr[i - 1] == '2') {
                if (sArr[i] >= '1' && sArr[i] <= '6') {
                    dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                } else {
                    dp[i] = dp[i - 1];
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[sArr.length - 1];
    }

    public static void main(String[] args) {
        String s = "27";

        System.out.println(numDecodings(s));
    }

}
