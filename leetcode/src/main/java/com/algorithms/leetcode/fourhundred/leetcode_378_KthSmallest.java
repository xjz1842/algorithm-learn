package com.algorithms.leetcode.fourhundred;


public class leetcode_378_KthSmallest {

    /**
     * 有序二维矩阵
     * 利用二分查找
     * 以左上角 最小值 L
     * 由下角 最大值 R
     * <p>
     * 验证方法验证 当前小于mid的个数是否 小于 k个
     * 如果 小于 mid 个数 >= k  ,则 R = mid
     * 如果 小于 mid 个数 < k  ,则 L = mid + 1;
     */
    public static int kthSmallest(int[][] matrix, int k) {
        //行列个数
        int rows = matrix.length;
        int cols = matrix[0].length;

        int l = matrix[0][0];
        int r = matrix[rows - 1][cols - 1];
        //记录答案
        int[] res = new int[]{l, r};
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            int[] count = countLow(mid, matrix);
            if (count[0] >= k) {
                res = count;
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return res[1];
    }

    private static int[] countLow(int mid, int[][] matrix) {
        // 从左下角开始计算
        int rows = matrix.length;
        int cols = matrix[0].length;
        //开始坐标 左下角
        int r = rows - 1;
        int c = 0;
        //计算小于等于mid的个数
        int count = 0;
        //记录最大元素
        int max = Integer.MIN_VALUE;
        while (r >= 0 && c < cols) {
            if (matrix[r][c] <= mid) {
                max = Math.max(max, matrix[r][c]);
                count += r + 1;
                c++;
            } else {
                r--;
            }
        }
        return new int[]{count, max};
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{
//                {1, 5, 9},
//                {10, 11, 13},
//                {12, 13, 15}};
        int[][] matrix = new int[][]{
                {1, 2}, {1, 3}};
        int k = 4;
        System.out.println(kthSmallest(matrix, k));
    }

}