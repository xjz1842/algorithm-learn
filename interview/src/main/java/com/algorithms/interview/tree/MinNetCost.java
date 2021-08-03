package com.algorithms.interview.tree;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 【题目】园区里面有很多大楼，编号从 1~N。
 * 第 i 大楼可以自己花钱买路由器上网，费用为 cost[i-1]，
 * 也可以从别的大楼拉一根网线来上网，比如大楼 a 和大楼 b 之间拉网线的费用为 c，
 * 表示为一条边 [a, b, c]。输入为每个大楼自己买路由器和拉网线的费用，
 * 请问，让所有大楼都能够上网的最小费用是多少？上网具有联通性，
 * 只要与能够上网的大楼连通，即可上网。
 * <p>
 * 输入：cost = [1, 2, 3], edges = [[1,2,100], [2,3,3]]
 * <p>
 * 输出：6
 * <p>
 * 解释：最优方案是 1 号大楼买路由器 cost[0] = 1，2 号楼买路由器 cost[1] = 2，
 * 然后和 3 号楼之间可拉一根网线，费用为 3，所以一共花费 6 元。如图（红色部分标记为费用 ）：
 */
public class MinNetCost {

    private static int[] F = null;
    private static int totalCost = 0;

    // 注意，编号是从1 ~ n
    private static void Init(int n) {
        F = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            F[i] = i;
        }
        totalCost = 0;
    }

    private static int Find(int x) {
        if (x == F[x]) {
            return x;
        }
        F[x] = Find(F[x]);
        return F[x];
    }

    private static void Union(int x, int y, int pay) {
        if (Find(x) != Find(y)) {
            totalCost += pay;
        }
        F[Find(x)] = Find(y);
    }

    /**
     * 增加虚拟节点,
     */
    public static int minNetCost(int N, int[] cost, int[][] es) {
        // 初始化并查集
        Init(N);
        // 每个结点都要自己买路由器，那么我们可以认为这样
        // 0号楼已经有网络了，可以用0费用上网

        int[][] conn = new int[es.length + N][3];
        for (int i = 0; i < es.length; i++) {
            conn[i][0] = es[i][0];
            conn[i][1] = es[i][1];
            conn[i][2] = es[i][2];
        }
        // i号楼与0号楼拉网线，需要的费用是cost[i-1]
        // 那么这里就多了N条边
        int to = es.length;
        for (int i = 1; i <= N; i++) {
            conn[to][0] = 0;
            conn[to][1] = i;
            conn[to][2] = cost[i - 1];
            to++;
        }
        // 接下来采用Krukal最小生成树算法
        Arrays.sort(conn, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });

        for (int[] ints : conn) {
            Union(ints[0], ints[1], ints[2]);
        }
        return totalCost;
    }

    public static void main(String[] args) {
        int[] cost = new int[]{1, 2, 3};
        int[][] edges = new int[][]{
                {1, 2, 100},
                {2, 3, 3}};
        int n = 3;
        System.out.println(minNetCost(n,cost,edges));
    }

}
