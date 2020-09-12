package com.algorithms.leetcode.onehundred;

public class leetcode_97_IsInterleave {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null)
            return false;
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        char[] s3Arr = s3.toCharArray();

        if (s3 == null) {
            return true;
        }
        if ((s1.length() + s2.length()) != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i - 1][0] && s1Arr[i - 1] == s3Arr[i - 1];
        }

        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = dp[0][j - 1] && s2Arr[j - 1] == s3Arr[j - 1];
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = (dp[i - 1][j] && (s1Arr[i - 1] == s3Arr[i + j - 1]))
                        || (dp[i][j - 1] && (s2Arr[j - 1] == s3Arr[i + j - 1]));
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "";
        String s3 = "a";
        System.out.println(isInterleave(s1, s2, s3));
    }
}
