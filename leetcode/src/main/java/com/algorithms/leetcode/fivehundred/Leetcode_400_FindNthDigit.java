package com.algorithms.leetcode.fivehundred;

public class Leetcode_400_FindNthDigit {
    /**
     * 查询第n位的数
     * <p>
     * 1 ~ 9  9
     * 10 ~ 99  9 * 10 * 2
     * 100 ~ 999 9 * 100 * 3
     * <p>
     * 首先定位一共是几位数
     */
    public static int findNthDigit(int n) {
        if (n == 0) {
            return 0;
        }
        //几位数
        int digit = 1;
        //记录1 -> gigit位  分别用有多少位
        long start = 1;
        // 该数位的数一共的索引个数（不是数字个数）
        long index_count = digit * 9 * start;
        while (n > index_count) {
            n -= index_count;
            digit++;
            start *= 10;
            index_count = digit * 9 * start;
        }
        //剩下的数据就是n
        //算出原始的 n 到底对应那个数字
        long target = start + (long)((n - 1) / digit);
        //余数就是原始的 n 是这个数字中的第几位
        int targetIndex = (n - 1) % digit;
        //返回目标数字
        return String.valueOf(target).charAt(targetIndex) - '0';
    }

    public static void main(String[] args) {
     int n = 1;
      System.out.println(findNthDigit(n));
    }
}
