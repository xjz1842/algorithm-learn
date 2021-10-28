package com.algorithms.leetcode.fivehundred;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode_402_RemoveKdigits {

    /**
     *  使用递增的单调栈
     *
     */
    public static String removeKdigits(String num, int k) {
        //单调递增栈
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < num.length(); i++) {
           int digit = num.charAt(i) - '0';

           while (!stack.isEmpty() && stack.peek() > digit && k > 0){
               stack.pop();
               k--;
           }
           stack.push(digit);
       }
        //如果k > 0 知道移除到满足k个元素
        while (k > 0){
            stack.pop();
            k--;
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()){
           Integer top =  stack.pollLast();
           // 解去掉前导0
           if(top > 0 || ans.length() > 0){
               ans.append(top);
           }
        }
        if (ans.length() == 0){
            return "0";
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String num = "10200";
        int k = 1;
        System.out.println(removeKdigits(num,k));
    }

}
