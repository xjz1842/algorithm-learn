package com.algorithms.leetcode.fourhundred;

public class leetcode_342_IsPowerOfFour {

    public static boolean isPowerOfFour(int n) {
        //从低到高 第一个不为0的位置
        int res = n & (-n);

        if (n != res) {
            return false;
        }
        int numbersOfZeros = 0;
        while (res != 1) {
            numbersOfZeros++;
            res = res >> 1;
        }
        return (numbersOfZeros & 1) == 0;
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPowerOfFour(n));
    }
}
