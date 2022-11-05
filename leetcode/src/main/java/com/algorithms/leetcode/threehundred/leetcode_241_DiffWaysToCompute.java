package com.algorithms.leetcode.threehundred;

import java.util.ArrayList;
import java.util.List;

public class leetcode_241_DiffWaysToCompute {

    // 采用分治
    static char[] cArr;
    static int len;
    static List<Integer> res = new ArrayList<Integer>();

    public static List<Integer> diffWaysToCompute(String input) {
        cArr = input.toCharArray();
        len = input.length();
        return dfsHelper(0, len - 1);
    }

    private static List<Integer> dfsHelper(int l, int r) {
        int idx = l;
        List<Integer> nArr = new ArrayList<Integer>();
        int num = 0;
        while ((idx <= r) && Character.isDigit(cArr[idx])) {
            num = num * 10 + (cArr[idx] - '0');
            idx++;
        }
        if (idx > r) {
            nArr.add(num);
            return nArr;
        }
        for (int i = idx; i <= r; i++) {
            if (Character.isDigit(cArr[i])) {
                continue;
            }
            List<Integer> left = dfsHelper(l, i - 1);
            List<Integer> right = dfsHelper(i + 1, r);
            for (int valL : left) {
                for (int valR : right) {
                    char opt = cArr[i];
                    int output = 0;
                    if (opt == '+') {
                        output = valL + valR;
                    } else if (opt == '-') {
                        output = valL - valR;
                    } else if (opt == '*') {
                        output = valL * valR;
                    }
                    nArr.add(output);
                }
            }
        }
        return nArr;
    }

    public static void main(String[] args) {
        String expresion = "2*3-4*5";
        System.out.println(diffWaysToCompute(expresion));
    }
}
