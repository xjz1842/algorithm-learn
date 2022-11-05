package com.algorithms.interview.sort;

/**
 * 【题目】给定一个只包含 [0, 1, 2] 的数组，如何只通过 swap 操作，将这个数组进行排序？
 *
 * 输入：[2, 1, 0]
 *
 * 输出：[0, 1, 2]
 *
 * 要求：你的时间复杂度需要是 O(N)，空间复杂度需要是 O(1)。
 *
 * 【分析】回想一下，我们前面学过的“三路切分”，在快速排序的时候，我们通过一个整数 x 将数组切分成小于、等于、大于三部分。分别可以映射到三个值上：
 *
 * 0 的部分对应到小于 x 的部分
 *
 * 1 的部分对应到等于 x 的部分
 *
 * 2 的部分对应到大于 x 的部分
 */
public class ThreeSplit {

    static void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    void split(int[] A) {
        final int N = A.length;
        int i = 0, l = 0, r = N - 1;
        while (i <= r) {
            // case 0: 需要将0元素放到左区间。l++, i++完成[L, i)区间的平移。
            if (A[i] == 0){
                swap(A, l++, i++);
            }
            // case 1: 元素1直接append在[L, i)区间的后面就可以了。
            else if (A[i] == 1){
                i++;
            }
                // case 2: 元素2需要与A[r]交换。然后区间(r, N)向左扩张
            else{
                swap(A, r--, i);
            }
        }
    }

}
