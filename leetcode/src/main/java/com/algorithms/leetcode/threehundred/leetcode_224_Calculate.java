package com.algorithms.leetcode.threehundred;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/basic-calculator/
 * <p>
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 */
public class leetcode_224_Calculate {

    public static int calculate(String s) {
        int res = 0;
        int num = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                num = 10 * num + s.charAt(i) - '0';
            } else if (cur == '+' || cur == '-') {
                res += sign * num;
                num = 0;
                sign = cur == '+' ? 1 : -1;
            } else if (cur == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (cur == ')') {
                res += sign * num;
                num = 0;
                //sign
                res *= stack.pop();
                //value
                res += stack.pop();
            }
        }
        res += sign * num;
        return res;
    }

    public static void main(String[] args) {
        String s = "- (3 + (4 + 5))";
        System.out.println(calculate(s));
    }
}
