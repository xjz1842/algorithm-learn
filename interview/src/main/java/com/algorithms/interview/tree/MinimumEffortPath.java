package com.algorithms.interview.tree;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @lc app=leetcode.cn id=1631 lang=java
 * <p>
 * [1631] 最小体力消耗路径
 * <p>
 * https://leetcode-cn.com/problems/path-with-minimum-effort/description/
 * <p>
 * algorithms
 * Medium (49.37%)
 * Likes:    211
 * Dislikes: 0
 * Total Accepted:    21.9K
 * Total Submissions: 44.4K
 * Testcase Example:  '[[1,2,2],[3,8,2],[5,3,5]]'
 * <p>
 * 你准备参加一场远足活动。给你一个二维 rows x
 * columns 的地图 heights ，其中 heights[row][col] 表示格子 (row,
 * col) 的高度。一开始你在最左上角的格子 (0,
 * 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0
 * 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力
 * 最小的一条路径。
 * <p>
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 * <p>
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
 * 输出：1
 * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5]
 * 更优。
 * <p>
 * 示例 3：
 * <p>
 * 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * 输出：0
 * 解释：上图所示路径不需要消耗任何体力。
 * <p>
 * 提示：
 * <p>
 * rows == heights.length
 * columns == heights[i].length
 * 1
 * 1
 */
public class MinimumEffortPath {

    private int[] F = null;

    private void Init(int n) {
        F = new int[n];
        for (int i = 0; i < n; i++) {
            F[i] = i;
        }
    }

    public int Find(int x) {
        if (x == F[x]) {
            return x;
        }
        F[x] = Find(F[x]);
        return F[x];
    }

    public void Union(int x, int y) {
        F[Find(x)] = Find(y);
    }

    // 行数
    private int rows = 0;

    // 列数
    private int cols = 0;

    // 四个方向
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int getPointMapping(int r, int c) {
        return r * cols + c;
    }


    private void putEdge(int[][] edges, int iter, int r, int c, int nr, int nc, int cost) {
        edges[iter][0] = getPointMapping(r, c);
        edges[iter][1] = getPointMapping(nr, nc);
        edges[iter][2] = cost;
    }

    public int minimumEffortPath(int[][] heights) {
        if (heights == null || heights[0] == null) {
            return 0;
        }
        rows = heights.length;
        cols = heights[0].length;

        // 如果只有一个点
        if (rows == 1 && cols == 1) {
            return 0;
        }

        // 横向的无向边的数目
        final int hNumber = rows * (cols - 1);
        final int vNumber = cols * (rows - 1);

        // 无向边
        // 记录起点，终点，权重
        int[][] edges = new int[hNumber + vNumber][3];

        // 得到所有的边
        int edgeIter = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                //  右边的点
                if (c + 1 < cols) {
                    int edgeCost = Math.abs(heights[r][c] - heights[r][c + 1]);
                    putEdge(edges, edgeIter, r, c, r, c + 1, edgeCost);
                    edgeIter++;
                }
                //下边的边
                if (r + 1 < rows) {
                    int edgeCost = Math.abs(heights[r][c] - heights[r + 1][c]);
                    putEdge(edges, edgeIter, r, c, r + 1, c, edgeCost);
                    edgeIter++;
                }
            }
        }

        // 再将边进行排序
        Arrays.sort(edges, (Comparator<int[]>) (a, b) -> a[2] - b[2]);

        // 排序结束之后，再使用并查集，依次加入边
        final int totalNodes = rows * cols;
        Init(totalNodes);

        final int src = 0;
        final int target = getPointMapping(rows - 1, cols - 1);


        for (int[] edge : edges) {
            Union(edge[0], edge[1]);
            // 如果能让 src dst连通
            // 那么就是当前的cost
            if (Find(src) == Find(target)) {
                return edge[2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] heights = new int[][]{{1, 10, 6, 7, 9, 10, 4, 9}};
        MinimumEffortPath s = new MinimumEffortPath();
        System.out.println(s.minimumEffortPath(heights));
    }
}
