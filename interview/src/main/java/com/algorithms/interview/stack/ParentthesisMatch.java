package com.algorithms.interview.stack;

import java.util.Stack;

public class ParentthesisMatch {

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if ((s.length() & 1) == 1) {
            return false;
        }
        // 消除法的主要核心逻辑:
        Stack<Character> t = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            // 取出字符
            char c = s.charAt(i);
            if (c == '(') {
                // 如果是'('，那么压栈
                t.push(c);
            } else if (s.charAt(i) == ')') {
                // 如果是')'，那么就尝试弹栈
                if (t.empty()) {
                    return false;
                }
                t.pop();
            }
        }
        return t.empty();
    }

    //简化：就是把入栈与出栈变成了 leftBraceNumber 的加减
    public static boolean isValid1(String s) {
        // 当字符串本来就是空的时候，我们可以快速返回true
        if (s == null || s.length() == 0) {
            return true;
        }
        // 消除法的主要核心逻辑:
         int leftBraceNumber = 0;

        for(int i = 0; i < s.length(); i++){
            // 取出字符
            char c = s.charAt(i);
            if(c == '('){
               leftBraceNumber++;
            }else if(c == ')'){
                if(leftBraceNumber <= 0){
                    return false;
                }
                --leftBraceNumber;
            }
        }
        return leftBraceNumber == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("((((())))"));
        System.out.println(isValid1("((((())))"));
    }
}
