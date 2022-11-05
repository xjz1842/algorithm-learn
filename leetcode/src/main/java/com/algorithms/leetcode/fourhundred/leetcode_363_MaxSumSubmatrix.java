package com.algorithms.leetcode.fourhundred;

import java.util.TreeSet;

public class leetcode_363_MaxSumSubmatrix {

    /**
     * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
     *
     * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
     *
     * 输入：matrix = [[1,0,1],[0,-2,3]], k = 2
     * 输出：2
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。。
     */
    public static int maxSumSubmatrix(int[][] matrix, int k) {
         if (matrix.length == 0) {
             return 0;
         }
         if(matrix[0].length == 0){
             return 0;
         }
        int ans = Integer.MIN_VALUE;
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 枚举上边界
        for (int i = 0; i < rows; ++i) {
            int[] sum = new int[cols];
            // 枚举下边界
            for (int j = i; j < rows; ++j){
                for (int c = 0; c < cols; ++c) {
                    // 更新每列的元素和
                    sum[c] += matrix[j][c];
                }
                TreeSet<Integer> sumSet = new TreeSet<>();
                sumSet.add(0);
                int s = 0;
                // 枚举右边界
                for(int v : sum){
                    s += v;
                    Integer ceil = sumSet.ceiling(s-k);
                    if(ceil != null){
                        ans = Math.max(ans, s - ceil);
                    }
                    sumSet.add(s);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][]  matrix =  new int[][]{{1,0,1},{0,-2,3}};
        int k = 2;
        System.out.println(maxSumSubmatrix(matrix,k));
    }
}
