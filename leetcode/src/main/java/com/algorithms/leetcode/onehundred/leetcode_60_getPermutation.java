package com.algorithms.leetcode.onehundred;

public class leetcode_60_getPermutation {

    //递归求解
    public static String getPermutation(int n, int k) {
        if (n <= 1) {
            return n + "";
        }
        int groupIndexNum = 1;

        for (int i = 1; i < n; i++) {
            groupIndexNum = groupIndexNum * i;
        }
        boolean[] used = new boolean[n];

        StringBuilder result = new StringBuilder();
        int remain = 0;
        int groupIndex = 0;
        while (n > 0) {
            remain = k % groupIndexNum;
            groupIndex = k / groupIndexNum + (remain == 0 ? 0 : 1);

            int i = 0;
            for (; i < used.length && groupIndex > 0; i++) {
                if (!used[i]) {
                    groupIndex--;
                }
            }
            result.append(i);
            used[i - 1] = true;
            if (n == 1) {
                break;
            }
            k = remain == 0 ? groupIndexNum : remain;
            groupIndexNum = groupIndexNum / (n - 1);
            n = n - 1;
        }
        return result.toString();
    }


    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        System.out.println(getPermutation(n, k));
    }

}
