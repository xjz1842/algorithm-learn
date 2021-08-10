package com.algorithms.interview.dfs;

/**
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 *
 * https://leetcode-cn.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (42.26%)
 * Likes:    475
 * Dislikes: 0
 * Total Accepted:    88.5K
 * Total Submissions: 209.4K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 *
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 *
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O'
 * 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 **/
public class AroundArea {

    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static char VIS = 'A';

    private static int rows, cols;

    public static  void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        rows = board.length;
        cols = board[0].length;
        // 除了四边外的 ‘O’，
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(row == 0 || col == 0 || row == rows -1 || col == cols-1){
                    if(board[row][col] == 'O'){
                        board[row][col] = VIS;
                        dfs(board,row,col);
                    }
                }
            }
        }

        for (int row = 0; row < rows;row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] != VIS) {
                    board[row][col] = 'X';
                } else {
                    board[row][col] = 'O';
                }
            }
        }
    }

    static  void dfs(char[][] board,int row,int col){

        for(int d = 0; d < 4; d++){
            final int nr = row + dir[d][0];
            final int nc = col + dir[d][1];
            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                continue;
            }
            if (board[nr][nc] == 'O') {
                board[nr][nc] = VIS;
                dfs(board, nr, nc);
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.printf("%s\t", board[i][j]);
            }
            System.out.println();
        }
    }
}
