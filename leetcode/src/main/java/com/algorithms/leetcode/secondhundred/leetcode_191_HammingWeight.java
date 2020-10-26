package com.algorithms.leetcode.secondhundred;

public class leetcode_191_HammingWeight {

    public static int hammingWeight(int n) {
        int bits = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                bits++;
            }
        }
        return bits;
    }

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;

        System.out.println(hammingWeight(n));
    }
}
