package com.algorithms.leetcode.fourhundred;

import java.util.Stack;

public class leetcode_372_SuperPow {

    private static final int base = 1337;

    public static int superPow(int a, int[] b) {
        // 递归的 base case
        Stack<Integer> stack = new Stack<>();
        int len = b.length;
        for (int i : b) {
            stack.push(b[i]);
        }
        return sPow(a,stack);
    }

    //递归实现
    public static int sPow(int a,Stack<Integer> stack){
        if(stack.isEmpty()){
            return 1;
        }
        int last = stack.pop();
        int part1 = myPow(a,last);
        int part2 = myPow(sPow(a,stack),10);
        return (part1 * part2) % base;
    }

    private static int myPow(int a, int k) {
        if (k == 0) {
            return 1;
        }
        a %= base;

        if ((k & 1) == 1) {
            // k 是奇数
            return (a * myPow(a, k - 1)) % base;
        } else {
            // k 是偶数
            int sub = myPow(a, k / 2);
            return (sub * sub) % base;
        }
    }

    public static void main(String[] args) {
        int a = 1;
        int[] b = new int[]{4,3,3,8,5,};
        System.out.println(superPow(a,b));
    }
}
