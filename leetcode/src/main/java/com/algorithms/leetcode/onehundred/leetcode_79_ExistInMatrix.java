package com.algorithms.leetcode.onehundred;

public class leetcode_79_ExistInMatrix {

    public static boolean exist(char[][] board, String word) {
        if (word.isEmpty() || board.length == 0) {
            return false;
        }
        if (board[0].length == 0) {
            return false;
        }

        int endX = board.length;
        int endY = board[0].length;

        char[] words = word.toCharArray();

        boolean[][] isUsed = new boolean[board.length][board[0].length];

        for (int i = 0; i < endX; i++) {
            for (int j = 0; j < endY; j++) {
                //开始节点
                if (board[i][j] == words[0]) {
                    isUsed[i][j] = true;
                    if (dfs(board, i, j, 1, words, isUsed)) {
                        return true;
                    }
                    isUsed[i][j] = false;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, int i, int j, int matchIndex, char[] words, boolean[][] isUsed) {

        if (matchIndex == words.length) {
            return true;
        }

        int[][] directions = new int[][]{
                {0, 1},
                {0, -1},
                {-1, 0},
                {1, 0}};

        for (int k = 0; k < directions.length; k++) {
            int nextX = i + directions[k][0];
            int nextY = j + directions[k][1];
            if (validate(nextX, nextY, board) && board[nextX][nextY] == words[matchIndex] && isUsed[nextX][nextY] == false) {
                isUsed[nextX][nextY] = true;
                if (dfs(board, nextX, nextY, matchIndex + 1, words, isUsed)) {
                    return true;
                }
                isUsed[nextX][nextY] = false;
            }
        }
        return false;
    }

    public static boolean validate(int x, int y, char[][] board) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "SEE";

        System.out.println(exist(board, word));
    }

}
