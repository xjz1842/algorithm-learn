package com.algorithms.interview.tree;

public class FindGangNumber {

    private static int count = 0;
    // 这里直接申请了足够多的内存
    private static int[] F = null;

    // 并查集初始化
    // 注意点的编号是从1~n
    private static void Init(int n) {
        F = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            F[i] = i;
        }
        count = 0;
    }

    private static int Find(int x) {
        if (x == F[x]) {
            return x;
        }
        F[x] = Find(F[x]);
        return F[x];
    }

    // 在合并的时候，需要加上代价
    private static void Union(int x, int y) {
        if (Find(x) != Find(y)) {
            count++;
        }
        F[Find(x)] = Find(y);
    }

    static int findGangNumber(int n, int[][] conn) {
        Init(n);
        int m = conn.length;
        for (int i = 0; i < m; i++) {
            Union(conn[i][0], conn[i][1]);
        }
        // 帮派里面帮主的个数
        return count;
    }

    public static void main(String[] args) {
        int N = 4;
        int[][] conn = new int[][]{
                {1, 2},
                {2, 3}
        };
        System.out.println(findGangNumber(N, conn));
    }

}
