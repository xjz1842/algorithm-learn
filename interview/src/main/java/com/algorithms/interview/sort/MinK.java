package com.algorithms.interview.sort;

/**
 * 【题目】给定一个数组，请找出第 k 小的数（最小的数为第 1 小）。
 * <p>
 * 输入：A = [2, 4, 1, 5, 3], k = 3
 * <p>
 * 输出：3
 */
public class MinK {

    void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    // 注意这里区间为[b, e), k也是从0开始算的
    int kth(int[] A, int b, int e, int k) {
        // 如果为空
        if (b >= e) {
            return 0;
        }
        // 如果只有一个元素
        if (b + 1 >= e) {
            return A[b];
        }
        // 进行三路切分
        final int x = A[b + ((e - b) >> 1)];
        int i = b;
        int l = b;
        int r = e - 1;
        while (i <= r) {
            if (A[i] < x){
                swap(A, l++, i++);
            }else if (A[i] == x){
                i++;
            }else{
                swap(A, r--, i);
            }
        }
        // 分别拿到三段的长度
        final int lcnt = l - b;
        final int mcnt = i - l;
        // 如果第k个数落在左区间
        if (k < lcnt){
            return kth(A, b, l, k);
        }
        // 如果第k个数落在右区间
        if (k >= (lcnt + mcnt)){
            return kth(A, i, e, k - lcnt - mcnt);
        }
        // 如果第k个数落在中间，那么直接返回x
        return x;
    }

    int kthNumber(int[] A, int n, int k) {
        return kth(A, 0, n, k - 1);
    }
}
