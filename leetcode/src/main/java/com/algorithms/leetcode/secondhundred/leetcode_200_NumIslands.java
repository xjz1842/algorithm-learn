package com.algorithms.leetcode.secondhundred;

public class leetcode_200_NumIslands {

    public static int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int X = grid.length;
        int Y = grid[0].length;

        int count = 0;
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if ('1' == grid[i][j]) {
                    inject(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void inject(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length
                || grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '#';

        inject(grid, row - 1, col);
        inject(grid, row + 1, col);
        inject(grid, row, col - 1);
        inject(grid, row, col + 1);
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        System.out.println(numIslands(grid));
    }

}
