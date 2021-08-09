package com.algorithms.leetcode.eighthundred;

import java.util.*;

public class leetcode_743_NetworkDelayTime {

    static class Edge {
        public int to;
        public int cost;

        public Edge(int a, int b) {
            to = a;
            cost = b;
        }
    }

    // times实际上是边集
    public static  int networkDelayTime(int[][] times, int n, int k) {
        if(times == null || times.length == 0){
            return 0;
        }
        List<List<Edge>> G = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            G.add(new ArrayList<>());
        }

        for(int i = 0; i < times.length; i++){
            final int from = times[i][0],to = times[i][1],cost = times[i][2];
            G.get(from).add(new Edge(to,cost));
        }

        final int INF = Integer.MAX_VALUE/2;

        int[] ans = new int[n+1];
        for(int i = 0; i <= n; i++){
            ans[i] = INF;
        }

        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(v -> ans[v]));
        //初始化
        queue.add(k);
        ans[k] = 0;

        while (!queue.isEmpty()){
            int cur = queue.poll();

            for(Edge edge : G.get(cur)){
                final int next = edge.to, cost = edge.cost;
                final int transCost = ans[cur] + cost;
                if(transCost < ans[next]){
                    ans[next] = transCost;
                    queue.add(next);
                }
            }
        }
        int maxValue = -1;
        for(int i = 1; i <= n; i++){
            maxValue = Math.max(maxValue,ans[i]);
        }
        return maxValue == INF ? -1 : maxValue;
    }

    public static void main(String[] args) {
        int[][] times = new int[][]{
                {2,1,1},
                {2,3,1},
                {3,4,1}};
        System.out.println(networkDelayTime(times,4,2));
    }
}
