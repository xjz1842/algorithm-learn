package com.algorithms.sword.to.offer;

/**
 * &#064;Author:  zxj
 * &#064;Date:  2022/11/10 11:39 AM
 */
public class Offer_04_FindNumberIn2DArray {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        // 从右上角开始搜索 因为右上角的是第一行最大的，是最后一列最小的，与target比较后，可以得出从哪个方向移动
        int startX = 0;
        int startY = matrix[0].length - 1;

        while (startY >= 0 && startX < matrix.length) {
            if (matrix[startX][startY] == target) {
                return true;
            } else if (matrix[startX][startY] < target) {
                startX++;
            } else {
                startY--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(findNumberIn2DArray(matrix, 5));
    }

}
