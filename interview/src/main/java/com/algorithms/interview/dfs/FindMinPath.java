package com.algorithms.interview.dfs;

import java.util.ArrayList;
import java.util.List;

public class FindMinPath {

    static class Node {
        public int r;
        public int c;

        public Node() {
        }

        public Node(int a, int b) {
            r = a;
            c = b;
        }
    }

    //最短路径
    private static List<Node> shortPath = null;
    //方向
    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static List<Node> clone(List<Node> a) {
        List<Node> ans = new ArrayList<Node>();
        for (int i = 0; i < a.size(); i++) {
            Node x = a.get(i);
            ans.add(new Node(x.r, x.c));
        }
        return ans;
    }

    public static List<Node> findMinPath(int[][] board) {
        List<Node> ans = new ArrayList<Node>();

        if (board == null || board.length == 0) {
            return ans;
        }
        final int rows = board.length;
        final int cols = board[0].length;

        boolean[][] vis = new boolean[rows][cols];
        int[][] step = new int[rows][cols];

        // 记录每个点的从出发点走的最小的步数，一开始为 R * C
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                step[r][c] = rows * cols + 1;
            }
        }
        // 路径最长为遍历所有的点
        List<Node> tmp = new ArrayList<Node>();

        // 出发点[0, 0]
        tmp.add(new Node(0, 0));
        vis[0][0] = true;

        dfs(board, step, vis, 0, 0, tmp);

        tmp.remove(tmp.size() - 1);
        vis[0][0] = false;

        return shortPath;
    }


    private static void dfs(int[][] board, int[][] step, boolean[][] vis, int r, int c, List<Node> tmp) {
        //判断越界
        final int rows = board.length;
        final int cols = board[0].length;

        // 如果已经走到终点
        if (r == rows - 1 && c == cols - 1) {
            if (shortPath == null || shortPath.size() > tmp.size()) {
                shortPath = clone(tmp);
            }
            return;
        }
        // 剪枝1
        if (shortPath != null && tmp.size() >= shortPath.size()) return;

        // 剪枝2
        // 如果发现走到step[r][c]比以前用了更多的步数，那么直接返回
        if (tmp.size() - 1 > step[r][c]) {
            return;
        }

        // 接下来看当前出发点的四个选择
        for (int d = 0; d < 4; d++) {
            final int nr = r + dir[d][0];
            final int nc = c + dir[d][1];

            // 如果是越界的
            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                continue;
            }

            // 如果是不能访问的
            // 或者说已经访问过了
            if (board[nr][nc] == 1 || vis[nr][nc] == true) {
                continue;
            }

            vis[nr][nc] = true;
            tmp.add(new Node(nr, nc));

            dfs(board, step, vis, nr, nc, tmp);

            vis[nr][nc] = false;
            tmp.remove(tmp.size()-1);
        }

    }

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 1}, {0, 0}
        };
       for(Node node : findMinPath(board)){
           System.out.println(node.r + " " + node.c);
       }
    }
}
