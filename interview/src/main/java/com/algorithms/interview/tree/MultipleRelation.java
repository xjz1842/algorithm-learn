package com.algorithms.interview.tree;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 例 6: 倍数关系
 * 题目：
 * 给定一系列的变量， 以及变量之间的倍数关系， 比如: a/b = 2.0  b/c = 4.0  a/c = ?
 * 注意： 变量不支持约分，比如: aa/ab = 2.0. 不能将其约分为  a/b = 2.0, 也就是说
 * 给定一个字符串必须作为一个整体看待，
 * 输入： equations = [["a","b"],["b","c"]],
 * values = [2,0,4,0]
 * queries = [["a","c"]]
 * <p>
 * 输出 [8]
 * <p>
 * 【分析】那么首先我们进行一下模拟。
 */
public class MultipleRelation {

    // 记录字符串与整数的映射
    // 将字符串映射成整数之后，在操作并查集的数组的时候
    static void addToMap(String key, Map<String, Integer> H) {
        final int id = H.size();
        if (!H.containsKey(key)) {
            H.put(key, id);
        }
    }

    // 并查集的数组
    static int[] F = null;

    // 结点与其父结点的比例关系，我们总是用子结点除以父结点
    // 当 a / c = 8时，并且当前 a的父结点就是c
    // 那么 C[a] = 8
    // 当并查集的结构调整之后，a的父结点变成了d
    // 并且a/d=16，那么此时C[a] = 16
    static double[] C = null;

    static void Init(int n) {
        F = new int[n];
        C = new double[n];

        for (int i = 0; i < n; i++) {
            F[i] = i;
            C[i] = 1;
        }
    }

    static int Find(int x) {
        int b = x;
        // base用来保存从x -> .... root
        // 这条路径上所有的乘积
        // 最后保证可以得到
        // x = base * root
        double base = 1;
        while (x != F[x]) {
            base *= C[x];
            x = F[x];
        }
        // 这里x就是root
        // base x -> root的映射值
        // 把路径上的其他值一并压缩
        int root = x;
        while (F[b] != root) {
            // 修改值上的变化
            double next = base / C[b];
            //当前的倍数
            C[b] = base;
            //下一步的倍数
            base = next;
            //当前指向父节点
            int parent = F[b];
            //指向新的根
            F[b] = root;
            //往parent走一步
            b = parent;
        }
        return root;
    }

    static void Union(int T, int D, double v) {
        // T / D = v;
        // 给定的输入表示 T = v * D;
        // 那么找到T的root
        int tpar = Find(T);
        // T = C[T] * par
        int dpar = Find(D);
        // D = C[D] * dpar;
        // T = v * D = v * C[D] * dpar = C[T] * tpar;
        // 如果我们要让tpar 指向dpar
        // tpar = v * C[D] * dpar / C[T]
        F[tpar] = dpar;
        C[tpar] = v * C[D] / C[T];
    }

    static double[] calcEquation(List<List<String>> equations,
                          double[] values,
                          List<List<String>> queries) {
        // 为了方便后面操作，我们把所有的字符串都映射成整数
        Map<String, Integer> H = new HashMap<>();
        for (List<String> l : equations) {
            String t = l.get(0), d = l.get(1);
            addToMap(t, H);
            addToMap(d, H);
        }
        // 初始化并查集
        Init(H.size());

        // 开始执行Union操作
        for (int i = 0; i < equations.size(); i++) {
            List<String> l = equations.get(i);
            Union(H.get(l.get(0)), H.get(l.get(1)), values[i]);
        }
        // 在进行query之前，对所有的点执行Find操作。让后面的query
        // 的Find操作时间复杂度为O(1)
        for (int i = 0; i < H.size(); i++) {
            Find(i);
        }
        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            List<String> l = queries.get(i);
            int tidx = H.containsKey(l.get(0)) ? H.get(l.get(0)) : -1;
            int didx = H.containsKey(l.get(1)) ? H.get(l.get(1)) : -1;
            // 如果变量不存在，那么比例关系照题意设置为-1
            if (tidx == -1 || didx == -1) {
                ans[i] = -1;
            }else{
                int troot = Find(tidx);
                int droot = Find(didx);

                // 如果两个变量从来没有过交集
                if (troot != droot) {
                    ans[i] = -1;
                }else{
                    ans[i] = C[tidx] / C[didx];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> item = new ArrayList<>();
        item.add("a");
        item.add("b");
        equations.add(item);
        List<String> item1 = new ArrayList<>();
        item1.add("b");
        item1.add("c");
        equations.add(item1);
        List<List<String>> queries = new ArrayList<>();
        List<String> item3 = new ArrayList<>();
        item3.add("a");
        item3.add("c");
        queries.add(item3);
        double[] values = new double[]{2.0,4.0};
        for(double d : calcEquation(equations,values,queries)){
            System.out.println(d);
        }
    }
}
