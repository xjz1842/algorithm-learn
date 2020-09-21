package com.algorithms.leetcode.onehundred;

import java.util.ArrayList;
import java.util.List;

public class leetcode_22_GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        process(n, 0, 0, ans, new StringBuilder());
        return ans;
    }

    public static void process(int n, int open, int close, List<String> ans, StringBuilder stringBuilder) {
        if (close == n) {
            ans.add(stringBuilder.toString());
            return;
        }
        if (open < n) {
            stringBuilder.append('(');
            process(n, open + 1, close, ans, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        if (close < open) {
            stringBuilder.append(')');
            process(n, open, close + 1, ans, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = generateParenthesis(1);

        for (String s : list) {
            System.out.println(s);
        }
    }
}
