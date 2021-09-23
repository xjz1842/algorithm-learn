package com.algorithms.leetcode.fourhundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class leetcode_310_FindMinHeightTrees {

    /*
     * BFS 遍历每一个节点 // 超时
     */
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges == null || edges.length == 0) {
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
        }

        // 预处理
        Map<Integer, List<Integer>> edgesMap = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            // 双向边
            // 正向
            if (edgesMap.containsKey(edges[i][0])) {
                edgesMap.get(edges[i][0]).add(edges[i][1]);
            } else {
                List<Integer> init = new ArrayList<>();
                init.add(edges[i][1]);
                edgesMap.put(edges[i][0], init);
            }
            // 反向
            if (edgesMap.containsKey(edges[i][1])) {
                edgesMap.get(edges[i][1]).add(edges[i][0]);
            } else {
                List<Integer> init = new ArrayList<>();
                init.add(edges[i][0]);
                edgesMap.put(edges[i][1], init);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        // 遍历每一个节点
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            queue.add(i);
            visited[i] = true;
            int count = 0;
            while (!queue.isEmpty()) {
                count++;
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int tmp = queue.poll();
                    for (Integer v : edgesMap.get(tmp)) {
                        if (visited[v]) {
                            continue;
                        }
                        visited[v] = true;
                        queue.add(v);
                    }
                }
            }
            if (min == count) {
                ans.add(i);
            } else if (min > count) {
                min = count;
                ans.clear();
                ans.add(i);
            }
        }
        return ans;
    }

    public static List<Integer> findMinHeightTrees1(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        // 1.条件判断（边界判断，其他要求的判断）
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        int[] degree = new int[n];// 每个节点的度数
        List<List<Integer>> list = new ArrayList<>();// 每个节点
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            degree[edge[0]]++;// 计算edge[0]节点的度数
            degree[edge[1]]++;// 计算edge[1]节点的度数
            list.get(edge[0]).add(edge[1]);// 跟edge[0]相邻的节点
            list.get(edge[1]).add(edge[0]);// 跟edge[1]相邻的节点
        }
        // 2.创建队列
        Queue<Integer> queue = new LinkedList<>();

        // 3.在队列中加入第一个满足条件的元素
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {// 度数为1，说明是叶子结点,入队列
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            ans = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                ans.add(cur);
                List<Integer> nexts = list.get(cur);
                for (Integer next : nexts) {
                    degree[next]--;// 删除叶子节点后，跟其相邻的节点的度数要减少
                    if (degree[next] == 1) {
                        queue.offer(next);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 1;
        int[][] edges = new int[][] {};
        System.out.println(findMinHeightTrees(n, edges));
        System.out.println(findMinHeightTrees1(n, edges));
    }

}
