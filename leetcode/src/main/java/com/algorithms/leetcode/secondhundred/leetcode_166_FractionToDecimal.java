package com.algorithms.leetcode.secondhundred;


import java.util.HashMap;
import java.util.Map;

public class leetcode_166_FractionToDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        if ((numerator < 0 && denominator > 0) ||
                (numerator > 0 && denominator < 0)) {
            result.append("-");
        }
        long numeratorL = Math.abs((long) numerator);
        long denominatorL = Math.abs((long) denominator);

        long fraction = numeratorL / denominatorL;
        result.append(fraction);
        long remain = numeratorL % denominatorL;
        if (remain == 0) {
            return result.toString();
        }
        result.append(".");
        Map<Long, Integer> remainIndex = new HashMap<>();
        while (remain != 0) {
            if (remainIndex.get(remain) != null) {
                result.insert(remainIndex.get(remain), "(");
                result.append(")");
                return result.toString();
            }
            remainIndex.put(remain, result.length());
            numeratorL = remain * 10;
            remain = numeratorL % denominatorL;
            fraction = numeratorL / denominatorL;
            result.append(fraction);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int numerator = -50;
        int denominator = 8;
        System.out.println(fractionToDecimal(numerator, denominator));
    }
}
