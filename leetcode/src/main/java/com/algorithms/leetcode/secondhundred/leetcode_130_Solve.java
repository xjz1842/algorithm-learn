package com.algorithms.leetcode.secondhundred;

public class leetcode_130_Solve {

    public static void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            inject(board, i, 0);
            inject(board, i, col - 1);
        }
        for (int j = 0; j < col; j++) {
            inject(board, 0, j);
            inject(board, row - 1, j);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void inject(char[][] borad, int row, int col) {
        if (row < 0 || col < 0 || row > borad.length - 1 || col > borad[0].length - 1 || 'O' != borad[row][col]) {
            return;
        }
        borad[row][col] = '#';
        inject(borad, row - 1, col);
        inject(borad, row + 1, col);
        inject(borad, row, col - 1);
        inject(borad, row, col + 1);
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
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
