package com.algorithms.leetcode.fourhundred;

import java.util.Stack;

public class leetcode_316_RemoveDuplicateLetters {


    public static String removeDuplicateLetters(String s) {
        //record char count
        int[] count = new int[26];
        // visited
        boolean[] vis = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        // record str order
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            // not visited
            if (!vis[s.charAt(i) - 'a']) {
                while (!stack.isEmpty() && count[stack.peek() - 'a'] > 1
                        && stack.peek() > s.charAt(i)) {
                    vis[stack.peek() - 'a'] = false;
                    count[stack.peek() - 'a']--;
                    stack.pop();
                }
                stack.push(s.charAt(i));
                vis[s.charAt(i) - 'a'] = true;
            } else {
                count[s.charAt(i) - 'a']--;
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
    public static void main(String[] args) {
        String s = "bcabc";
        System.out.println(removeDuplicateLetters(s));
    }

}
