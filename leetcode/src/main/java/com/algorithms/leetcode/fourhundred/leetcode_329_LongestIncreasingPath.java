package com.algorithms.leetcode.fourhundred;

public class leetcode_329_LongestIncreasingPath {


    private static int[][] direction = new int[][]{
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
    };
    /**
     * DFS
     */
    public  static  int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxLen = 0;
        // 记录 仪 i，j 开始递增的长度
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                maxLen =  Math.max(maxLen,dfs(matrix,i,j,memo));
            }
        }
        return  maxLen;
    }

    /**
     * @param matrix
     * @param row 当前横坐标
     * @param col 当前纵坐标
     * @param len 递增路径长度
     */
    private static int dfs(int[][] matrix, int row, int col, int[][] memo) {
        if(memo[row][col] != 0){
            return memo[row][col];
        }
        ++memo[row][col];
        for(int i = 0; i < direction.length; i++){
            int nextRow = row + direction[i][0];
            int nextCol = col + direction[i][1];

            if(nextRow < 0 || nextRow >= matrix.length
              ||  nextCol < 0
              ||  nextCol >= matrix[0].length){
                continue;
            }

            if(matrix[nextRow][nextCol] > matrix[row][col]){
                memo[row][col] = Math.max(memo[row][col],dfs(matrix,nextRow,nextCol,memo)+1);
            }
        }
        return memo[row][col];
    }

    public static void main(String[] args) {
       int[][]  matrix =  new int[][]
               {{3,4,5},{3,2,6},{2,2,1}};
        System.out.println(longestIncreasingPath(matrix));
    }
}
