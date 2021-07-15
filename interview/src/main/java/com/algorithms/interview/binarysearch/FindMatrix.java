package com.algorithms.interview.binarysearch;

public class FindMatrix {

    //下边界 区间 [m r)
    static int lowerBound(int[] A, int n, long target) {
        int l = 0, r = n;
        while (l < r) {
            final int m = l + ((r - l) >> 1);
            if (A[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 ) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        //每一行做二分搜索
        for(int i = 0; i < row; i++) {
            int low = lowerBound(matrix[i],col, target);

            if (low < col && matrix[i][low] == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] array = new int[][]{
//                {-1,4,7,11,15},
//                {2,5,8,12,19},
//                {3,6,9,16,22},
//                {10,13,14,17,24},
//                {18,21,23,26,30}};
        int[][] array = new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
               };
        System.out.println(findNumberIn2DArray(array,19));
    }
}