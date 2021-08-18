package com.algorithms.leetcode.seventeenhundred;

public class leetcode_1631_MinimumEffortPath {

    //Bellman Ford 算法
    public static int minimumEffortPath(int[][] heights) {
        if (heights == null || heights[0] == null) {
            return 0;
        }
        int rows = heights.length;
        int cols = heights[0].length;

        // if just one node
        if (rows == 1 && cols == 1) {
            return 0;
        }
        // 一个点周围的四个方向
        int[][] dir = {{0, 1}, {0, -1},
                {1, 0}, {-1, 0}};

        // 采用BF算法
        // 从左上角走到右下角，最多只需要走rows + cols次
        // 所以我们在更新的时候，最多只需要更新rows + cols次
        // 并且，在更新的过程中，如果我们发现，没有任何一个点被更新的时候
        // 我们就可以退出来了
        final int maxDist = Integer.MAX_VALUE >> 4;

        int[][] dist = new int[rows][cols];
        // 初始化整个距离
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dist[r][c] = maxDist;
            }
        }
        dist[0][0] = 0;

        final int maxUpdateTimes = rows + cols;
        // 用BF算法来更新
        for (int updateTimes = 0;
             updateTimes < maxUpdateTimes; updateTimes++) {
            boolean hasUpdateItem = false;
            // 用所有的边来进行更新
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dir[d][0];
                        int nc = c + dir[d][1];
                        if(!(nr < 0 || nc < 0 ||
                                nr >= rows || nc >= cols)){
                            // 拿到边的代价
                            final int cost =
                                    Math.abs(heights[r][c] - heights[nr][nc]);
                            // 这条路径走过来的最大代价
                            final int nextCost = Math.max(dist[r][c], cost);
                            if(nextCost <  dist[nr][nc]){
                                dist[nr][nc] = nextCost;
                                hasUpdateItem = true;
                            }
                        }
                    }
                }
            }
            // 如果没有更新
            if (!hasUpdateItem) {
                break;
            }
        }
          return dist[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] height = new int[][]{{1, 2, 3}, {3, 8, 4}, {5, 3, 5}};

        System.out.println(minimumEffortPath(height));
    }
}
