package com.algorithms.leetcode.secondhundred;

import java.util.Stack;

public class leetcode_150_EvalRPN {

    public static int evalRPN(String[] tokens) {
        if (tokens == null) {
            return 0;
        }
        Stack<String> stack = new Stack<>();

        int sum = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int res = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());
                sum += res;
                stack.push(String.valueOf(res));
            } else if (tokens[i].equals("-")) {
                String a = stack.pop();
                String b = stack.pop();
                int res = Integer.parseInt(b) - Integer.parseInt(a);
                sum += res;
                stack.push(String.valueOf(res));
            } else if (tokens[i].equals("*")) {
                int res = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
                sum += res;
                stack.push(String.valueOf(res));
            } else if (tokens[i].equals("/")) {
                String a = stack.pop();
                String b = stack.pop();
                int res = Integer.parseInt(b) / Integer.parseInt(a);
                sum += res;
                stack.push(String.valueOf(res));
            } else {
                stack.push(tokens[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "+"}));
    }

}
