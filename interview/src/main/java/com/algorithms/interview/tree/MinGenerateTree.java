package com.algorithms.interview.tree;

import java.util.Arrays;
import java.util.Comparator;

public class MinGenerateTree {

    private long cost = 0;
    // 这里直接申请了足够多的内存
    private int[] F = null;

    // 并查集初始化
    // 注意点的编号是从1~n
    private void Init(int n) {
        F = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            F[i] = i;
        }
        cost = 0;
    }

    private int Find(int x) {
        if (x == F[x]) {
            return x;
        }
        F[x] = Find(F[x]);
        return F[x];
    }

    // 在合并的时候，需要加上代价
    private void Union(int x, int y, int pay) {
        if (Find(x) != Find(y)) cost += pay;
        F[Find(x)] = Find(y);
    }

    // 一共有n个点，编号从1~n
    // conn表示输入的边的集合
    // 每一项是一个三元组[点a, 点b, 需要费用c]
    public long Kruskal(int n, int m, int[][] conn) {
        Init(n);
        // 边集的排序
        Arrays.sort(conn, 0, m, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });
        // 顺次将边集添加到集合中
        for (int i = 0; i < m; i++) {
            Union(conn[i][0], conn[i][1], conn[i][2]);
        }
        return cost;
    }
}
