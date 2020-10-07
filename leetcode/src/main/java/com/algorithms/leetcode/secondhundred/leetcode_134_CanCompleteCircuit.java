package com.algorithms.leetcode.secondhundred;

public class leetcode_134_CanCompleteCircuit {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length != cost.length) {
            return -1;
        }

        for (int i = 0; i < gas.length; i++) {
            if (gas[i] < cost[i]) {
                continue;
            }
            int remain = 0;
            boolean flag = false;
            for (int j = i; j < gas.length; j++) {
                remain = remain + gas[j] - cost[j];
                if (remain < 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }
            for (int k = 0; k < i; k++) {
                remain = remain + gas[k] - cost[k];
                if (remain < 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }
            if (remain >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66};
        int[] cost = new int[]{27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
        System.out.println(canCompleteCircuit(gas, cost));
    }

}
