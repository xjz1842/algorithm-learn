package com.algorithms.interview.strMatch;

public class KMP {
    /**
     * PMT 表（Partial Match Table）
     * 表示的是一个字符串 S[0..i] 的前后缀的最长匹配的长度。这里我可以用如下操作表示 PMT 表的含义：
     * 给定一个字符串，我们想知道它的前缀集和后缀集里面最长且相同的字符串是什么，比如：
     * <p>
     * 复制代码
     * S = "ababa";
     * 前缀集 = {
     * "a",
     * "ab",
     * "aba",
     * "abab",
     * }
     * 后缀集 = {
     * "a",
     * "ba",
     * "aba",
     * "baba",
     * }
     * <p>
     * 那么两个集合的交集就是：
     * <p>
     * 前后缀的交集 = {
     * "a",
     * "aba",
     * }
     * 我们还需要在这个交集里面找到最长的字符串，就是 "aba"，这里我们称为前后缀的最长匹配。
     */
    static int indexOf(String main, String sub) {
        int i = 0;
        int j = 0;

        final int mainLen = main.length();
        final int subLen = sub.length();
        int[] PMT = buildPMT(sub);

        while (i < mainLen && j < subLen) {
            if (main.charAt(i) == sub.charAt(j)) {
                // 如果匹配成功，那么向前走
                // 这里和暴力的方法没有区别
                i++;
                j++;
            } else {
                //失败，
                if (j == 0) {
                    i++;
                } else {
                    //去掉无效比较
                    j = PMT[j - 1];
                }
            }
        }
        // 看一下是不是匹配完了
        return j == subLen ? i - subLen : -1;
    }

    public static int[] buildPMT(String sub) {
        final int N = sub == null ? 0 : sub.length();
        int[] PMT = new int[N];

        int i = 1;
        int j = 0;
        PMT[0] = 0;

        while (i < N) {
            if (sub.charAt(i) == sub.charAt(j)) {
                // 当相等的时候，都往前走
                i++;
                j++;
                PMT[i - 1] = j;
            } else {
                if (0 == j) {
                    // 如果匹配失败，并且j已经为0
                    // 那么
                    i++;
                    PMT[j] = 0;
                } else {
                    j = PMT[j - 1];
                }
            }
        }
        return PMT;
    }

    /**
     * 使用next数据
     */
    static int indexOf1(String main, String sub) {
        int i = 0;
        int j = 0;

        final int mainLen = main.length();
        final int subLen = sub.length();
        int[] next = buildNext(sub);

        while (i < mainLen && j < subLen) {
            if (j == -1 || main.charAt(i) == sub.charAt(j)) {
                // 如果匹配成功，那么向前走
                // 这里和暴力的方法没有区别
                i++;
                j++;
            } else {
                //失败，
                j = next[j];
            }
        }
        // 看一下是不是匹配完了
        return j == subLen ? i - subLen : -1;
    }

    static int[] buildNext(String sub) {
        final int N = sub == null ? 0 : sub.length();
        int[] next = new int[N + 1];

        int i = 0;
        int j = -1;
        //初始化
        next[0] = -1;
        while (i < N) {
            if (j==-1 || sub.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String main = "dfadsfdf dd fs";
        String target = "fdf";

        System.out.println(indexOf(main, target));
        System.out.println(indexOf1(main, target));
    }

}
