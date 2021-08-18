package com.algorithms.interview.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * https://leetcode-cn.com/problems/path-with-minimum-effort/description/
 */
public class MinimumEffortPath {

    //Dijkstra
    public static int minimumEffortPath(int[][] heights) {
        if (heights == null || heights[0].length == 0) {
            return 0;
        }
        // 行数
        int rows = heights.length;
        ;
        //列数
        int cols = heights[0].length;

        // 四个方向
        int[][] dir = {{0, 1}, {0, -1},
                {1, 0}, {-1, 0}};

        // 设置矩阵的最大距离
        final int maxDist = Integer.MAX_VALUE >> 4;
        int[][] dist = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dist[i][j] = maxDist;
            }
        }
        //init
        dist[0][0] = 0;
        // java小堆
        Queue<int[]> Q = new PriorityQueue<>(Comparator.comparingInt(v -> dist[v[0]][v[1]]));

        // 放入出发点
        Q.offer(new int[]{0, 0});

        while (!Q.isEmpty()) {
            // 取出最近的点
            int[] topNode = Q.poll();

            final int r = topNode[0];
            final int c = topNode[1];

            // 我们看一下这个点四周的点
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                // 看一下这个点的权重是否会更新
                if (!(nr < 0 || nc < 0 || nr >= rows || nc >= cols)) {
                    // 如果要走过去的点是合法的点
                    // 点之间的边上的权重
                    // 是由点与点之间的abs()决定的
                    final int weight =
                            Math.abs(heights[r][c] - heights[nr][nc]);
                    // 注意，题目要求是取整条路径上的绝对值的最大值
                    final int nextDist = Math.max(dist[r][c], weight);

                    if (nextDist < dist[nr][nc]) {
                        dist[nr][nc] = nextDist;
                        Q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return dist[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] height = new int[][]{{1, 2, 3}, {3, 8, 4}, {5, 3, 5}};

        System.out.println(minimumEffortPath(height));
    }
}
