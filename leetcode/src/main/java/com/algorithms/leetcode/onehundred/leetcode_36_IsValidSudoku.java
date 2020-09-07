package com.algorithms.leetcode.onehundred;

public class leetcode_36_IsValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
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
                    if (row[i][num] || col[j][num] || bucket[b][num]) {
                        return false;
                    }
                    row[i][num] = true;
                    col[j][num] = true;
                    bucket[b][num] = true;
                }
            }
        }
        return true;
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

        System.out.println(isValidSudoku(board));
    }

}
