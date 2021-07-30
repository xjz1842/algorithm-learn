package com.algorithms.interview.strMatch;

/*
 * @lc app=leetcode.cn id=214 lang=java
 *
 * [214] 最短回文串
 *
 * https://leetcode-cn.com/problems/shortest-palindrome/description/
 *
 * algorithms
 * Hard (36.75%)
 * Likes:    336
 * Dislikes: 0
 * Total Accepted:    27.3K
 * Total Submissions: 74.4K
 * Testcase Example:  '"aacecaaa"'
 *
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 *
 * 示例 1：
 *
 * 输入：s = "aacecaaa"
 * 输出："aaacecaaa"
 *
 * 示例 2：
 *
 * 输入：s = "abcd"
 * 输出："dcbabcd"
 *
 * 提示：
 *
 * 0
 * s 仅由小写英文字母组成
 *
 */
public class ShortestPalindrome {

    public static String shortestPalindrome(String s) {
        if (s == null)
            return null;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s).append("#").append(new StringBuilder(s).reverse().toString());
        //构造KMPD的next数据
        int[] next = buildNext(stringBuilder.toString());

        int longestSuffix = next[next.length - 1];

        return new StringBuilder(s.substring(longestSuffix)).reverse().append(s).toString();
    }

    //最长公共前后缀
    static int[] buildNext(String sub) {
        final int N = sub == null ? 0 : sub.length();
        int[] next = new int[N + 1];

        int i = 0;
        //最长公共前缀的索引
        int lastPos = -1;
        //初始化
        next[0] = -1;
        while (i < N) {
            if (lastPos == -1 || sub.charAt(i) == sub.charAt(lastPos)) {
                i++;
                lastPos++;
                next[i] = lastPos;
            } else {
                lastPos = next[lastPos];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String s = "aacecaaa";
        System.out.println(shortestPalindrome(s));
    }
}
