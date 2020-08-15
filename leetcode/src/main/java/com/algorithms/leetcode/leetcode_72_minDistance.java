package com.algorithms.leetcode;


/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class leetcode_72_minDistance {

    public static int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        }
        if (word1 == null || word1.isEmpty()) {
            return word2.length();
        }
        if (word2 == null || word2.isEmpty()) {
            return word1.length();
        }
        char[] xArr = (" " + word1).toCharArray();
        char[] yArr = (" " + word2).toCharArray();

        int[][] dp = new int[xArr.length + 1][yArr.length + 1];
        // [0...i,0...j]代表 0到i上的字符串跟0到j上的字符串
        //通过插入，删除、替换最小次数
        // dp[i][j] = dp[i-1][j] + 1 删除
        //            dp[i][j-1] + 1 增加
        //            dp[i-1][j-1] + 1 替换

        dp[0][0] = 0;

        for (int i = 0; i < xArr.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < yArr.length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < xArr.length; i++) {
            for (int j = 1; j < yArr.length; j++) {
                if (xArr[i] == yArr[j]) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                dp[i][j] = Math.min(Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1), dp[i - 1][j - 1] + 1);
            }
        }
        return dp[xArr.length - 1][yArr.length - 1];
    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";

        System.out.println(minDistance(word1, word2));
    }


}
