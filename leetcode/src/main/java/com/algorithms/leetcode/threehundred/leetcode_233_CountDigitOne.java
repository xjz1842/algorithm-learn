package com.algorithms.leetcode.threehundred;

public class leetcode_233_CountDigitOne {

    //枚举每一位数
    public static int countDigitOne(int n) {
        // index 表示 10^k
        long index = 1;
        int ans = 0;
        for (int k = 0; n >= index; ++k) {
            ans += (n / (index * 10)) * index +
                    Math.min(Math.max(n % (index * 10) - index + 1, 0), index);
            index *= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(1234));
    }

}
