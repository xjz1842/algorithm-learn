package com.algorithms.interview.sort;

/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 *
 * https://leetcode-cn.com/problems/single-number/description/
 *
 * algorithms
 * Easy (70.74%)
 * Likes:    1674
 * Dislikes: 0
 * Total Accepted:    326.1K
 * Total Submissions: 461K
 * Testcase Example:  '[2,2,1]'
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class FindThreeTimesNumber {

    static void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    // 三路切分
    static int threeSplit(int[] A, int b, int e) {
        if (b >= e) {
            return 0;
        }
        // 我们取数组中间的数
        final int m = b + ((e - b) >> 1);
        final int x = A[m];
        // 注意我们的初始区间有四个：
        // [b, l) [l, i) [i, r] (r, N)
        // [小于)  [等于) [未知]  (大于)
        int l = b;
        int i = b;
        int r = e - 1;
        while (i <= r) {
            if (A[i] < x) {
                swap(A, l++, i++);
            } else if (A[i] == x) {
                i++;
            } else {
                swap(A, r--, i);
            }
        }
        // 切分完毕之后，只有三个区间
        // [b, l) [l, i) [i, N)
        // 首先看中间的区间
        if (i - l == 1)
            return A[l];
        // 再看左区间
        if (((l - b) & 0x01) == 1) {
            return threeSplit(A, b, l);
        }
        // 再看右区间
        return threeSplit(A, i, e);
    }

    static int singleNumber(int[] A) {
        if (A == null || A.length <= 0) {
            return 0;
        }
        return threeSplit(A, 0, A.length);
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,2, 3, 3,6};

        System.out.println(singleNumber(array));
    }
}
