package com.algorithms.sword.to.offer;

/**
 * https://leetcode-cn.com/problems/deep-dark-fraction/
 * <p>
 * 连分数是形如上图的分式。在本题中，所有系数都是大于等于0的整数。
 * <p>
 * 输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。
 * 返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，
 * 且n, m最大公约数为1。
 */
public class LCP_Fration_01 {

    public static int[] fraction(int[] cont) {
        if (cont == null || cont.length == 0) {
            return new int[]{};
        }
        if (cont.length == 1) {
            return new int[]{cont[0],1};
        }
        int m = cont[cont.length - 1];
        int n = cont[cont.length - 2];

        int numerator = (m * n + 1);
        int denominator = m;
        for (int i = cont.length - 3; i >= 0; i--) {
            int tmp = numerator;
            numerator = denominator;
            denominator = tmp;
            //分子
            numerator = cont[i] * denominator + numerator;
        }
        return new int[]{numerator, denominator};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,3};
        for (int i : fraction(arr)) {
            System.out.println(i);
        }
    }
}
