package com.algorithms.leetcode.fourhundred;

public class leetcode_344_ReverseString {

    public static void reverseString(char[] s) {
        if(s == null || s.length == 1){
            return;
        }
        int l = 0;
        int r = s.length - 1;

        while (l < r){
            //交换
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        reverseString(s);
        for(char c : s){
            System.out.println(c);
        }
    }
}
