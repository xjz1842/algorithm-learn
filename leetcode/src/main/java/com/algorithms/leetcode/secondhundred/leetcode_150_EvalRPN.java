package com.algorithms.leetcode.secondhundred;

import java.util.Stack;

public class leetcode_150_EvalRPN {

    public static int evalRPN(String[] tokens) {
        if (tokens == null) {
            return 0;
        }
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int res = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());
                stack.push(String.valueOf(res));
            } else if (tokens[i].equals("-")) {
                String a = stack.pop();
                String b = stack.pop();
                int res = Integer.parseInt(b) - Integer.parseInt(a);
                stack.push(String.valueOf(res));
            } else if (tokens[i].equals("*")) {
                int res = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
                stack.push(String.valueOf(res));
            } else if (tokens[i].equals("/")) {
                String a = stack.pop();
                String b = stack.pop();
                int res = Integer.parseInt(b) / Integer.parseInt(a);
                stack.push(String.valueOf(res));
            } else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

}
