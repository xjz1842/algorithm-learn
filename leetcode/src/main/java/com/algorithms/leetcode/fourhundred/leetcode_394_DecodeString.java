package com.algorithms.leetcode.fourhundred;

import java.util.Stack;

public class leetcode_394_DecodeString {

    /**
     * 使用栈
     */
    public static String decodeString(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        char[] chars = s.toCharArray();
        //栈
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < chars.length) {
            // 数字入栈
            if (Character.isDigit(chars[index])) {
                StringBuilder ret = new StringBuilder();
                while (Character.isDigit(s.charAt(index))) {
                    ret.append(s.charAt(index++));
                }
                stack.push(ret.toString());
            }else
            // 非 ']' 入栈
            if (chars[index] != ']' &&  !Character.isDigit(chars[index])) {
                stack.push(String.valueOf(chars[index++]));
            }else
            if(chars[index] == ']'){
                String top = stack.pop();
                StringBuilder stringBuilder = new StringBuilder();
                while (!stack.isEmpty() && !"[".equals(top)){
                    stringBuilder.append(top);
                    top = stack.pop();
                }
                StringBuilder builder = new StringBuilder();
                int duplicateTimes = !stack.isEmpty() ? Integer.parseInt(stack.pop()) : 0;
                for(int i = 0; i < duplicateTimes; i++){
                    builder.append(stringBuilder);
                }
                stack.push(builder.toString());
                index++;
            }
        }
        while (!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        //String s = "3[a2[c]]";
        String str = "2[abc]3[cd]ef";
        System.out.println(decodeString(str));
    }
}
