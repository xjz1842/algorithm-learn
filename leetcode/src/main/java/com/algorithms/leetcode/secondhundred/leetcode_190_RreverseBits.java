package com.algorithms.leetcode.secondhundred;

public class leetcode_190_RreverseBits {

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (i << 1)) != 0) {
                result = result + (1 << (31 - i));
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}


