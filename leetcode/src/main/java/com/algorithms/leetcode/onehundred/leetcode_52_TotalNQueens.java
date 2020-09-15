package com.algorithms.leetcode.onehundred;


import java.util.ArrayList;
import java.util.List;

public class leetcode_52_TotalNQueens {

    public static int totalNQueens(int n) {
        char[][] board = new char[n][n];
        List<Integer> answer = new ArrayList<>();

        //初始化
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        process(board, 0, answer);
        return answer.size();
    }


    public static void process(char[][] borad, int row, List<Integer> answer) {

        if (row == borad.length) {
            answer.add(1);
        }
        for (int j = 0; j < borad.length; j++) {
            if (isValid(borad, row, j)) {
                borad[row][j] = 'Q';
                process(borad, row + 1, answer);
                borad[row][j] = '.';
            }
        }
    }


    public static boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'Q') {
                    if (row == i || j == col || (Math.abs(i - row) == Math.abs(j - col))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }

}