package com.algorithms.leetcode.onehundred;

public class leetcode_37_SolveSudoku {
    /**
     * 一个数独的解法需遵循如下规则：
     * <p>
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     */
    public static void solveSudoku(char[][] board) {
        int h = board.length;
        int w = board[0].length;

        boolean[][] row = new boolean[h][w];
        boolean[][] col = new boolean[h][w];
        boolean[][] bucket = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] != '.') {
                    int b = (3 * (i / 3) + j / 3);
                    int num = board[i][j] - '1';
                    row[i][num] = true;
                    col[j][num] = true;
                    bucket[b][num] = true;
                }
            }
        }
        dfs(board, 0, 0, row, col, bucket);

        printBoard(board);
    }

    public static boolean dfs(char[][] board, int i, int j, boolean[][] row, boolean[][] col, boolean[][] bucket) {
        if (i == board.length || j == board.length) {
            return true;
        }

        while (i < board.length && board[i][j] != '.') {
            i = j != 8 ? i : i + 1;
            j = j != 8 ? j + 1 : 0;
        }
        if (i == board.length || j == board.length) {
            return true;
        }

        for (int num = 0; num < 9; num++) {
            int bucketIndex = (3 * (i / 3) + j / 3);

            if (!row[i][num] && !col[j][num] && !bucket[bucketIndex][num]) {
                // 递归
                board[i][j] = (char) ('1' + num);
                row[i][num] = true;
                col[j][num] = true;
                bucket[bucketIndex][num] = true;
                if (dfs(board, i, j, row, col, bucket)) {
                    return true;
                } else {
                    row[i][num] = false;
                    col[j][num] = false;
                    bucket[bucketIndex][num] = false;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);


    }
}
