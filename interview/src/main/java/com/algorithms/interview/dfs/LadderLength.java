package com.algorithms.interview.dfs;

import java.util.*;

public class LadderLength {

    private static Map<String, Integer> wordID = null;
    private static List<Integer>[] graph = null;

    public static boolean buildGraph(String beginWord,
                                     String endWord,
                                     List<String> wordList) {

        // 首先如果单词一样：题目中给出了条件，这两个单词必须不一样
        if (beginWord.compareTo(endWord) == 0) {
            return false;
        }
        // 需要记录每个单词的ID
        wordID = new HashMap<>();
        int id = 0;

        for (String word : wordList) {
            if (!wordID.containsKey(word)) {
                wordID.put(word, id++);
            }
        }

        // 根据题意：如果我们在wordList中找不到endWord必须要
        // 返回0
        if (!wordID.containsKey(endWord)) {
            return false;
        }
        // 如果wordID中没有beginWord
        // 那么把beginWord添加到wordID & wordList中
        if (!wordID.containsKey(beginWord)) {
            wordID.put(beginWord, id++);
            wordList.add(beginWord);
        }
        // 构建图
        graph = new ArrayList[wordID.size()];
        for (int i = 0; i < wordID.size(); i++) {
            graph[i] = new ArrayList<>();
        }

        for (String word : wordList) {
            // 边的起始点 from
            final int from = wordID.get(word);
            // 看一下from能转变成什么
            byte[] wordBytes = word.getBytes();

            for (int i = 0; i < wordBytes.length; i++) {
                byte old = wordBytes[i];
                // 改变成其他byte
                for (byte toByte = 'a'; toByte <= 'z'; toByte++) {
                    wordBytes[i] = toByte;
                    String toWord = new String(wordBytes);
                    if (wordID.containsKey(toWord)) {
                        // 边的终点to
                        int to = wordID.get(toWord);
                        // 把这条边加到Graph中
                        graph[from].add(to);
                    }
                }
                wordBytes[i] = old;
            }
        }
        return true;
    }

    public static  int ladderLength(String beginWord,
                            String endWord,
                            List<String> wordList) {
        // 这里构图
        if (!buildGraph(beginWord, endWord, wordList)) {
            return 0;
        }
        // 分别设置好源点，终点
        final int src = wordID.get(beginWord);
        final int dst = wordID.get(endWord);

        // 数组记录src点出发到其他点的最短距离
        int[] dist = new int[wordID.size()];

        // 设置一个最大距离，表示无解
        int maxPathLength = wordID.size() + 1024;

        //初始化dist数组
        for(int i = 0; i < dist.length; i++){
            dist[i] = maxPathLength;
        }
        dist[src] = 0;
        // dfs搜索最优解
        dfs(graph, src, dist);
        return dist[dst] >= maxPathLength ? 0 : dist[dst] + 1;
    }

    private static void dfs(List<Integer>[] graph, int src, int[] dist) {

        for(Integer nextNode : graph[src]){
            final int nextDist = dist[src] + 1;
            if(nextDist < dist[nextNode]){
                dist[nextNode] = nextDist;
                dfs(graph,nextNode,dist);
            }
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}
