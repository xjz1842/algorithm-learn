package com.algorithms.leetcode.onehundred;

import java.util.ArrayList;
import java.util.List;

public class leetcode_51_SolveNQueens {

    public static List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();

        //初始化
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        process(board, 0, ans);
        return ans;
    }

    public static void process(char[][] borad, int row, List<List<String>> ans) {

        if (row == borad.length) {
            ans.add(charArr2StringList(borad));
        }
        for (int j = 0; j < borad.length; j++) {
            if (isValid(borad, row, j)) {
                borad[row][j] = 'Q';
                process(borad, row + 1, ans);
                borad[row][j] = '.';
            }
        }
    }

    private static List<String> charArr2StringList(char[][] board) {

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            ans.add(new String(board[i]));
        }
        return ans;
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
        List<List<String>> list = solveNQueens(1);

        for (List<String> row : list) {
            for (String s : row) {
                System.out.println(s);
            }
            System.out.println("=====");
        }

    }


}
