package com.algorithms.leetcode.threehundred;

import java.util.Locale;
import java.util.Stack;

public class leetcode_227_Calculate {

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char preSign = '+';
        int i = 0;
        int num = 0;
        s = s.trim();
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            boolean isDigit = Character.isDigit(s.charAt(i));
            if (isDigit) {
                num = num * 10 + s.charAt(i) - '0';
            }
            //不是数字时，入栈 后者 已经到最后一个字符了
            if(!isDigit || i == (s.length()-1)) {
                process(preSign, num, stack);
                if (!isDigit) {
                    preSign = s.charAt(i);
                    num = 0;
                }
            }
            i++;
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void process(char preSign, Integer num, Stack<Integer> stack) {
        switch (preSign) {
            case '+':
                stack.push(num);
                break;
            case '-':
                stack.push(-num);
                break;
            case '*':
                stack.push(stack.pop() * num);
                break;
            case '/':
                stack.push(stack.pop() / num);
                break;
        }
    }

    public static void main(String[] args) {
        String s = " 3/2 ";
        System.out.println(calculate(s));
    }
}
