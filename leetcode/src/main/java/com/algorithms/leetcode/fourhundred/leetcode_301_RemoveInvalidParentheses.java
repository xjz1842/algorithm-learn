package com.algorithms.leetcode.fourhundred;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode_301_RemoveInvalidParentheses {

    public static List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        char[] array = s.toCharArray();
        int leftRemove = 0;
        int rightRemove = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                leftRemove++;
            }
            if (array[i] == ')') {
                if (leftRemove > 0) {
                    leftRemove--;
                } else {
                    rightRemove++;
                }
            }
        }
        Set<String> ans = new HashSet<>();
        dfs(0, array, leftRemove, rightRemove, 0, 0, new StringBuilder(), ans);
        return new ArrayList<>(ans);
    }

    public static void dfs(int index, char[] chars, int leftRemove, int rightRemove, int leftCount, int rightCount, StringBuilder stringBuilder, Set<String> answer) {
        if (index == chars.length
                && leftCount == rightCount
                && leftRemove == 0 && rightRemove == 0) {
            answer.add(stringBuilder.toString());
            return;
        }
        if(index >= chars.length){
            return;
        }
        if (chars[index] == '('  && leftRemove > 0) {
            dfs(index + 1, chars, leftRemove-1, rightRemove, leftCount, rightCount, stringBuilder, answer);
        }
        if (chars[index] == ')' && rightRemove > 0) {
            dfs(index + 1, chars,leftRemove,rightRemove-1, leftCount, rightCount, stringBuilder, answer);
        }
        stringBuilder.append(chars[index]);
        if (chars[index] != '(' && chars[index] != ')') {
            dfs(index + 1, chars, leftRemove, rightRemove, leftCount, rightCount, stringBuilder, answer);
        }
        if (chars[index] == '(' ) {
            dfs(index + 1, chars, leftRemove, rightRemove,leftCount+1, rightCount, stringBuilder, answer);
        }
        if (chars[index] == ')' && leftCount > rightCount) {
            dfs(index + 1, chars, leftRemove, rightRemove, leftCount,rightCount+1,stringBuilder, answer);
        }
        //回溯
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }

    public static void main(String[] args) {
        String s = "(a)())()";
        System.out.println(removeInvalidParentheses(s));
    }
}
