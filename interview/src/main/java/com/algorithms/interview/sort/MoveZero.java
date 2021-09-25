package com.algorithms.interview.sort;

/**
 *
 */
public class MoveZero {

    static public void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    static public void moveZeroes(int[] A) {
        final int N = A.length;
        int i = 0, l = 0, r = N - 1;
        while (i <= r) {
            // case: 不等于0, 则往左放
            if (A[i] != 0){
                swap(A, l++, i++);
            }else{
                i++;
            }
        }
    }
}
