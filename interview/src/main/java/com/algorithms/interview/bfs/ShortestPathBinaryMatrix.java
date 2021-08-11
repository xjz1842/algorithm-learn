package com.algorithms.interview.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个矩阵，矩阵中只有 0，1，
 * 其中 0 表示可以通行的路径，1 表示墙，请返回从左上角走到右下角的最短路径。
 * （注意：这个题里面有 8 个方向可以走，也就是可以斜着走），
 * 如果不存在这样的路径，那么返回 -1。
 *
 * 输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
 *
 * 输出：4
 *
 */
public class ShortestPathBinaryMatrix {


    public static  int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dir = {
                {0, 1}  /*右*/,
                {0, -1} /*左*/,
                {1, 0}  /*下*/,
                {-1, 0} /*上*/,
                {-1,-1} /*左上*/,
                {-1,1}  /*右上*/,
                {1,-1}  /*左下*/,
                {1,1}   /*右下*/,
        };

        // 拿到矩阵的Row, Col
        final int R = grid == null ? 0 : grid.length;
        final int C = R > 0 ? (grid[0] == null ? 0 : grid[0].length) : 0;

        // 首先处理特殊情况
        // 为空，或者只有一个格子
        if (R <= 1 || C <= 1) {
            return Math.min(R, C);
        }

        // 首先处理起始点
        // 如果起始点或者说终点已经是1
        // 那么返回-1
        if (grid[0][0] == 1 || grid[R - 1][C - 1] == 1) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();

        int[] cur = new int[2]; // {0,0}
        // 将起始点 入队， 并且标记为已访问
        queue.add(cur);

        grid[cur[0]][cur[1]] = 1;
        // 一开始就会占用一个格子
        int ans = 0;

        while (!queue.isEmpty()) {
            ans++;
            // 注意这里类似二叉树层次遍历的做法，取出qSize
            // 可以一层一层的遍历。
            int size = queue.size();
            for(int i = 0; i < size; i++){
                cur = queue.remove();
                // 如果已经走到了目的地
                if (cur[0] == (R - 1) && cur[1] == (C - 1)) {
                    return ans;
                }
                for (int d = 0; d < 8; d++) {
                    int nr = cur[0] + dir[d][0];
                    int nc = cur[1] + dir[d][1];

                    if(!(nc < 0 || nr < 0 || nr >= R || nc >= C)){
                        if (grid[nr][nc] != 1) {
                            grid[nr][nc] = 1;
                            queue.add(new int[] { nr, nc });
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,0,0},
                {1,1,0},
                {1,1,0}
        };
        System.out.println(shortestPathBinaryMatrix(matrix));
    }
}
