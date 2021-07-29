package com.algorithms.interview.strMatch;

public class RepeatedSubstringPattern {

    public static boolean repeatedSubstringPattern(String s) {
        return  indexOf1((s+s).substring(1),s) != s.length()-1;
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
        String s = "aba";
        System.out.println(repeatedSubstringPattern(s));
    }
}
