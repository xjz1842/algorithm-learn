package com.algorithms.leetcode.threehundred;

public class leetcode_231_IsPowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        if(n == 0 || n < 0)
            return false;
        return (n & (n-1)) == 0;
    }

    public static void main(String[] args) {


        for(int i = 0; i < 1000; i++) {
           if(isPowerOfTwo(i)){
               System.out.println(i);
           }
        }
    }
}
