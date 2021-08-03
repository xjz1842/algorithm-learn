package com.algorithms.interview.tree;

/**
 * 例 4: 替换字母
 * 【题目】给你一个矩阵 A，里面只包含字母 ‘O’ 和 'X'，如果一个 'O'
 * 上下左右四周都被 'X' 包围，
 * 那么这个 'O' 会被替换成 'X'。请你写程序处理一下这个过程。
 * <p>
 * 解释：由于中心的 'O' 四周都被包围，所以需要被换成 'X'，而第 A[0][0] = 'O' 靠着边，所以不能被替换。
 */
public class ReplaceChar {

    static int[][] dir = {{0, 1}, {1, 0}};
    static int[] F = null;

    static void Init(int n) {
        F = new int[n];
        for (int i = 0; i < n; i++) {
            F[i] = i;
        }
    }

    static int Find(int x) {
        if (x == F[x]) {
            return x;
        }
        F[x] = Find(F[x]);
        return F[x];
    }

    static void Union(int x, int y) {
        F[Find(x)] = Find(y);
    }

    static void replaceChar(char[][] A) {
        if (A == null || A[0] == null) {
            return;
        }
        final int R = A.length;
        final int C = A[0].length;

        Init(R * C + 1);
        // 我们将vNode设置为R * C
        // 这是一个在矩阵中不存在的点
        final int vNode = R * C;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (A[r][c] == 'O') {
                    // 如果是边上的点
                    if (r == 0 || r == R - 1 || c == 0 || c == C - 1) {
                        // 那么将其与vNode进行Union
                        Union(r * C + c, vNode);
                    }
                    // 将其与四面的点进行Union
                    for (int d = 0; d < 2; d++) {
                        final int nr = r + dir[d][0];
                        final int nc = c + dir[d][1];
                        if (!(nr < 0 || nr >= R || nc < 0 || nc >= C)) {
                            if (A[nr][nc] == 'O') {
                                Union(r * C + c, nr * C + nc);
                            }
                        }
                    }
                }
            }
        }
        // 查看是不是和vNode一个集合，如果不是就要修改成'X'
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (A[r][c] == 'O') {
                    if (Find(r * C + c) != Find(vNode)) {
                        A[r][c] = 'X';
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] chars = new char[][]{{
                'O', 'X', 'X'},
                {'X', 'O', 'X'},
                {'X', 'X', 'X'}};
        replaceChar(chars);

        final int R = chars.length;
        final int C = chars[0].length;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                System.out.printf("%s ", chars[r][c]);
            }
            System.out.println();
        }
    }

}
