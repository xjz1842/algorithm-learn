package com.algorithms.interview.bfs;

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

    public static int ladderLength(String beginWord,
                                   String endWord,
                                   List<String> wordList) {
        // 我们要写的核心代码在这里。
        // 如果建图失败，说明无法找到有效解，依照题意，无解的时候
        // 我们需要返回0
        if (!buildGraph(beginWord, endWord, wordList)) {
            return 0;
        }

        int src = wordID.get(beginWord);
        int target = wordID.get(endWord);

        // 这里我们采用“两段击”的BFS的方式进行处理
        List<Integer> cur = new ArrayList<>();
        cur.add(src);

        List<Integer> next = new ArrayList<>();

        // 记录哪些点被访问过了
        boolean[] visited = new boolean[wordID.size()];
        visited[src] = true;

        //初始步数
        int step = 0;

        while (!cur.isEmpty()) {
            next.clear();
            step++;
            // 遍历当前层的点，然后放到next中
            for (Integer curNode : cur) {
                // 如果走到终点
                if (curNode == target) {
                    return step;
                }
                for (Integer nextNode : graph[curNode]) {
                    // 遍历边curNode -> nextNode
                    // 如果这个点还没有被访问过
                    if (!visited[nextNode]) {
                        // 那么放到next中
                        next.add(nextNode);
                        visited[nextNode] = true;
                    }
                }
            }
            // swap the cur next
            List<Integer> tmp = cur;
            cur = next;
            next = tmp;
        }
        return 0;
    }

    // 双向BFS
    public static int ladderLength1(String beginWord,
                                    String endWord,
                                    List<String> wordList) {
        // 如果建图失败，那么返回0
        if (!buildGraph(beginWord, endWord, wordList)) {
            return 0;
        }

        // 接下来，我们就是在一个图中找到两个点的最近距离
        // 这里采用BFS的方法
        final int srcNode = wordID.get(beginWord);
        final int dstNode = wordID.get(endWord);

        // 这里我们采用“两段击”的
        // 双向BFS的方式来进行处理

        // 这里正向出发
        Set<Integer> src = new HashSet<>();
        src.add(srcNode);

        // 这里逆向出发
        Set<Integer> dst = new HashSet<>();
        dst.add(dstNode);

        final int srcVisTag = 1;
        final int dstVisTag = 2;

        // 记录哪些点被访问过了
        int[] visited = new int[wordID.size()];

        // 通过不同的标号来标记点是被前序遍历过
        // 还是被后序遍历过
        visited[srcNode] = srcVisTag;
        visited[dstNode] = dstVisTag;

        // 初始步数
        int step = 0;
        while (!src.isEmpty() && !dst.isEmpty()) {
            step++;

            // 查看src与set是否相遇
            for (Integer node : dst) {
                if (src.contains(node)) {
                    return step;
                }
            }

            // 哪边点更少，就更新哪一边
            final int visTag = src.size() < dst.size() ?
                    srcVisTag : dstVisTag;

            Set<Integer> startNodes = src.size() < dst.size() ? src : dst;
            Set<Integer> next = new HashSet<>();

            for (int startNode : startNodes) {
                for (int nextNode : graph[startNode]) {
                    if (visited[nextNode] != visTag) {
                        visited[nextNode] = visTag;
                        next.add(nextNode);
                    }
                }
            }
            if (src.size() < dst.size()) {
                src = next;
            } else {
                dst = next;
            }
        }
        return 0;
    }

    //Dijkstra
    public static int ladderLength2(String beginWord,
                                    String endWord,
                                    List<String> wordList) {
        // 如果建图失败，那么返回0
        if (!buildGraph(beginWord, endWord, wordList)) {
            return 0;
        }
        // 接下来，我们就是在一个图中找到两个点的最近距离
        // 这里采用BFS的方法
        final int src = wordID.get(beginWord);
        final int target = wordID.get(endWord);
        // 记录从src到各个点的距离
        int[] dist = new int[wordID.size()];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = wordID.size() * wordID.size() + 100;
        }
        dist[src] = 0;

        // java小堆
        Queue<Integer> Q = new PriorityQueue<>(
                Comparator.comparingInt(v -> dist[v]));
        Q.add(src);

        while (!Q.isEmpty()) {

            final int startNode = Q.poll();
            final int startDist = dist[startNode];

            for (int nextNode : graph[startNode]) {
                final int nextDist = startDist + 1;
                if (dist[nextNode] > nextDist) {
                    dist[nextNode] = nextDist;
                    Q.add(nextNode);
                }
            }
        }
        return dist[target] > wordID.size() ?
                0 : dist[target] + 1;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(ladderLength(beginWord, endWord, wordList));
        System.out.println(ladderLength1(beginWord, endWord, wordList));
        System.out.println(ladderLength2(beginWord, endWord, wordList));
    }

}
