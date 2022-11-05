package com.algorithms.interview.heap;


/**
 * 【题目】给定一个数组 a[]，返回这个数组中最小的 k 个数。
 * <p>
 * 输入：A = [3,2,1], k = 2
 * <p>
 * 输出：[2, 1]
 */
public class GetMinK {

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || arr.length < k){
            return new int[]{};
        }

        Heap heap = new Heap(k);

        for (int i = 0; i < arr.length; i++) {
            // 首先将元素压入堆中
            // 如果堆中已经有k个元素
            // 此时压入，会有k+1个元素，
            // 所以初始化时，申请数组大小需要为k+1
            heap.push(arr[i]);
            // 如果堆中元素多于k个，那么扔掉最大的元素
            if (heap.size() > k) {
                heap.pop();
            }
        }
        int[] ans = new int[k];

        int i = 0;
        while (heap.size() > 0) {
            ans[i++] = heap.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1};
        int k = 2;
        for (int i : getLeastNumbers(nums, k)) {
            System.out.println(i);
        }
    }
}
