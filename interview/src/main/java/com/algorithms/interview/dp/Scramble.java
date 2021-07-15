package com.algorithms.interview.dp;

/**
 * 【题目】使用下面描述的算法可以扰乱字符串 s 得到字符串 t 。
 * <p>
 * Step 1. 如果字符串的长度为 1 ，算法停止。
 * <p>
 * Step 2. 如果字符串的长度 > 1 ，执行下述步骤：
 * <p>
 * 在一个随机下标处将字符串分割成两个非空的子字符串。即如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 * <p>
 * 随机决定是“交换两个子字符串”还是“保持这两个子字符串的顺序不变”。即在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 * <p>
 * Step 3. 在 x 和 y 这两个子字符串上继续从 Step 1 开始递归执行此算法。
 * <p>
 * 有两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 输入：s1 = "great", s2 = "rgeat"
 * <p>
 * 输出：true
 * <p>
 * 解释：经过如下操作即可从 s1 得到 s2：
 */
public class Scramble {

    //区间DP
   static boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;
        // N表示后面字符串的长度
        int N = s1.length();
        //[]
        boolean[][][] dp = new boolean[N + 1][N + 1][N + 1];
        // 初始条件是长度为1的情况
        for (int s1start = 0; s1start < N; s1start++) {
            for (int s2start = 0; s2start < N; s2start++) {
                dp[s1start][s2start][1] = s1.charAt(s1start) == s2.charAt(s2start);
            }
        }

        // 那么再通过递推公式计算其他长度的情况
        // 子串的截取，这里我们采用开闭原则[start, end)
        // 也就是说，end是可以取到N的。
        for (int len = 2; len <= N; len++) {
            for (int s1start = 0; s1start + len <= len; s1start++) {
                for (int s2start = 0; s2start + len <= len; s2start++) {
                    // 现在我们需要计算两个子串
                    // X = s1[s1start, s1start+len)
                    // Y = s2[s2start, s2start+len)
                    // 这两个子串是否是扰动字符串
                    // 那么根据递推公式，我们需要找切分点
                    // 切分子串的时候
                    // X 切分为 X = a + b, 分为左右两半
                    // Y 切分为 Y = c + d，同样分为左右两半
                    // 左边的长度为leftLen, 右边的长度就是len - leftLen
                    for (int leftLen = 1; leftLen < len && !dp[s1start][s2start][len];
                         leftLen++) {
                        // 第一种切分，case 1
                        // X = a + b, Y = c + d
                        // [s1start, s1start + leftLen) <- a
                        // [s2start, s2start + leftLen) <- c
                        // [s1start + leftLen, s1start + len) <- b
                        // [s2start + leftLen, s2start + len) <- d
                        boolean c1 =
                                // <a, c>
                                dp[s1start][s2start][leftLen] &&
                                        // <b, d>
                                        dp[s1start + leftLen][s2start + leftLen][len - leftLen];
                        // 第2种切分
                        // X = a + b, Y = c + d
                        // [s1start, s1start + leftLen) <- a
                        // [s2start + len - leftLen, s2start + len) <- d
                        // [s1start + leftLen, s1start + len) <- b
                        // [s2start, s2start + len - leftLen) <- c
                        boolean c2 =
                                // <a, d>
                                dp[s1start][s2start + len - leftLen][leftLen] &&
                                        // <b, c>
                                        dp[s1start + leftLen][s2start][len - leftLen];
                        dp[s1start][s2start][len] = c1 || c2;
                    }
                }
            }
        }
        return dp[0][0][N];
    }

    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";
        System.out.println(isScramble(s1,s2));
    }
}