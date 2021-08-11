package com.algorithms.interview.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [778]
 * https://leetcode-cn.com/problems/swim-in-rising-water/
 *
 * ：在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。现在开始下雨了。
 * 当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。
 * 你可以从一个平台游向四周相邻的任意一个平台，
 * 但是前提是此时水位必须同时淹没这两个平台。
 * 假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。
 * 当然，在你游泳的时候你必须待在坐标方格里面。你从坐标方格的左上平台 (0，0) 出发。
 * 最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？
 */
public class SwimInWater {

    public static int swimInWater(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int N = grid.length;

        int left = 0;
        int right = N * N - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            if (grid[0][0] <= mid && bfs(grid, mid)) {
                // mid 可以，尝试 mid 小一点是不是也可以呢？// [left, mid]
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean bfs(int[][] grid, int threshold) {
        int[][] dir = {
                {0, 1}  /*右*/,
                {0, -1} /*左*/,
                {1, 0}  /*下*/,
                {-1, 0} /*上*/,
        };
        int rows = grid.length;
        int cols = grid[0].length;
        int N = grid.length;
        boolean[][] visited = new boolean[N][N];

        Queue<int[]> queue = new LinkedList<>();
        //init
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] ints : dir) {
                    int nr = cur[0] + ints[0];
                    int nc = cur[1] + ints[1];

                    if (!(nr < 0 || nc < 0 || nr >= rows || nc >= cols)
                            && !visited[nr][nc]
                            && grid[nr][nc] <= threshold) {
                        if (nr == rows-1 && nc == cols-1) {
                            return true;
                        }
                        queue.add(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}};

        System.out.println(swimInWater(grid));
    }
}
