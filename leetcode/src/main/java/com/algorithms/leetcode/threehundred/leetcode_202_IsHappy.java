package com.algorithms.leetcode.threehundred;


import java.util.HashSet;
import java.util.Set;

public class leetcode_202_IsHappy {

    private static int getNext(int n) {
        int totalSum = 0;

        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public static void main(String[] args) {
        int s = 19;
        System.out.println(isHappy(s));
    }
}
