package com.algorithms.interview.dfs;

public class MinimumEffortPath {

    //  二分搜索
    // 行数
    static private int rows = 0;
    // 列数
    static private int cols = 0;
    // 一个点周围的四个方向
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static boolean[][] vis = null;

    private static void clearVisRecord() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                vis[r][c] = false;
            }
        }
    }

    // 这里采用DFS来寻路
    // <r,c>是当前的出发点
    private static boolean dfs(int[][] heights, int maxValue,
                               int r, int c) {
        // 如果已经走到了目标点<rows-1, cols-1>
        if (r == rows - 1 && c == cols - 1) {
            return true;
        }
        // 查看 <r,c>点的四周
        for (int d = 0; d < 4; d++) {
            final int nr = r + dir[d][0];
            final int nc = c + dir[d][1];

            // 如果周边的点有效，并且没有被访问过
            if (!(nr < 0 || nc < 0 || nr >= rows || nc >= cols) && !vis[nr][nc]) {
                // 获取边的代价
                final int cost = Math.abs(heights[nr][nc] - heights[r][c]);
                // 在走的时候，如果比midValue大，那么这条路就不能走了
                if (cost <= maxValue) {
                    vis[nr][nc] = true;
                    if (dfs(heights, maxValue, nr, nc)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // f(x)函数
    // 重新映射之的一维数组
    // midValue是在二分的时候给定的值
    // 我们在进行搜索的时候，路径上的绝对值不能比这个大
    // 只能是 <= midValue.
    // 此时我们只需要寻找看看是否存在一条路径即可
    // 如果存在一条路径，上面的绝对值 <= midValue
    // 那么满足条件-> 返回0
    // 如果没有这样的路径，那么返回-1
    private static int getC(int[][] heights, int midValue) {
        clearVisRecord();
        vis[0][0] = true;
        return dfs(heights, midValue, 0, 0) ? 0 : -1;
    }

    public static int minimumEffortPath(int[][] heights) {
        if (heights == null || heights[0] == null) {
            return 0;
        }
         rows = heights.length;
         cols = heights[0].length;

        // if just one node
        if (rows == 1 && cols == 1) {
            return 0;
        }
        // 生成vis数组
        vis = new boolean[rows][cols];

        // 二分搜索
        // 找到搜索范围里：最大值/最小值
        int minCost = Integer.MAX_VALUE;
        int maxCost = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // 看一下 右边的点
                if (c + 1 < cols) {
                    int rightValue =
                            Math.abs(heights[r][c] - heights[r][c + 1]);
                    minCost = Math.min(minCost, rightValue);
                    maxCost = Math.max(maxCost, rightValue);
                }
                if (r + 1 < rows) {
                    int downValue =
                            Math.abs(heights[r][c] - heights[r + 1][c]);
                    minCost = Math.min(minCost, downValue);
                    maxCost = Math.max(maxCost, downValue);
                }
            }
        }
        // 那么应该有一个值 target
        // 当 路径的最大绝对值差为 x
        // 并且 x >= target的时候
        // 总是可以走通的
        // 所以我们二分搜索的范围就为[minCost, maxCost + 1)
        // 我们定义-1: 表示左上角与右下有没有通路
        //        0: 表示左上角与右下角有通路
        // 那么形成的C数组就是[-1,-1,-1,-1, 0, 0, 0, 0]
        // 这样的结构
        // 因此，我们在利用二分搜索的时候，只需要找到最左边的
        // 0的位置就可以了。
        int l = minCost, r = maxCost + 1;
        while (l < r) {
            final int mid = l + ((r - l) >> 1);
            final int mv = getC(heights, mid);
            if (mv < 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[][] height = new int[][]{{1, 2, 3}, {3, 8, 4}, {5, 3, 5}};

        System.out.println(minimumEffortPath(height));
    }
}
