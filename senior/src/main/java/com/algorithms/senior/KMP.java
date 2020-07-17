package com.algorithms.senior;


/**
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KMP {

    // for test
    public static String getRandomString(int possibilities, int size) {
        char[] ans = new char[(int) (Math.random() * size) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (char) ((int) (Math.random() * possibilities) + 'a');
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        int possibilities = 5;
        int strSize = 20;
        int matchSize = 5;
        int testTimes = 5000000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            String str = getRandomString(possibilities, strSize);
            String match = getRandomString(possibilities, matchSize);
            if (getIndexOf(str, match) != str.indexOf(match)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish");
    }

    // O(N)
    public static int getIndexOf(String haystack, String needle) {

        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }

        if (needle.length() < 1) {
            if (haystack.length() < 1) {
                return 0;
            } else {
                return 0;
            }
        }

        char[] str = haystack.toCharArray();
        char[] match = needle.toCharArray();
        int x = 0; // str中当前比对到的位置
        int y = 0; // match中当前比对到的位置

        // M  M <= N   O(M)
        int[] next = getNextArray(match); // next[i]  match中i之前的字符串match[0..i-1

        // O(N)

        while (x < str.length && y < match.length) {
            if (str[x] == match[y]) {
                x++;
                y++;
            } else if (next[y] == -1) {
                x++;
            } else {
                y = next[y];
            }
        }
        return y == match.length ? x - y : -1;
    }


    //M     O(M)
    public static int[] getNextArray(char[] match) {

        if (match.length == 1) {
            return new int[]{-1};
        }

        int[] next = new int[match.length];

        next[0] = -1;
        next[1] = 0;

        int i = 2;

        // cn代表，cn位置的字符，是当前和i-1位置比较的字符
        int cn = 0;
        while (i < next.length) {
            if (match[i - 1] == match[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
