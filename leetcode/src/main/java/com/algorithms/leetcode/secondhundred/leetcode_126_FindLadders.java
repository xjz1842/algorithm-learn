package com.algorithms.leetcode.secondhundred;

import java.util.*;

public class leetcode_126_FindLadders {

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //缓存
        Map<String, Boolean> cache = new HashMap<>();
        for (String str : wordList) {
            cache.put(str, true);
        }
        // 累积每一层的结果队列
        Queue<List<String>> queue = new LinkedList<>();
        // Visited to make sure we don't repeat processing same word.
        Set<String> visited = new HashSet<>();
        List<String> list = new ArrayList<>(Arrays.asList(beginWord));
        queue.add(list);
        visited.add(beginWord);

        List<List<String>> result = new ArrayList<>();
        // 是否到达符合条件的层：如果该层添加的某一单词符合目标单词，则说明截止该层的所有解为最短路径，停止循环
        boolean flag = false;
        while (!queue.isEmpty() && !flag) {
            // 上一层的结果队列
            int size = queue.size();
            Set<String> subVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {
                List<String> path = queue.poll();
                // 获取该路径上一层的单词最后一个单词
                String word = path.get(path.size() - 1);
                List<String> sublist = findOneDiffWord(word, cache);

                for (String sub : sublist) {
                    if (!visited.contains(sub)) {
                        // 生成新的路径
                        List<String> pathList = new ArrayList<>(path);
                        pathList.add(sub);

                        if (sub.equals(endWord)) {
                            flag = true;
                            result.add(pathList);
                        }
                        // 将该路径添加到该层队列中
                        queue.add(pathList);
                        // 将该单词添加到该层已访问的单词集合中
                        subVisited.add(sub);
                    }
                }
            }
            visited.addAll(subVisited);
        }
        return result;
    }

    public static List<String> findOneDiffWord(String word, Map<String, Boolean> cache) {
        List<String> oneDiffWordList = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (word.charAt(i) != ch) {
                    String diffOne = word.substring(0, i) + ch + ((i == word.length() - 1) ? "" : word.substring(i + 1));
                    if (cache.get(diffOne) != null) {
                        oneDiffWordList.add(diffOne);
                    }
                }
            }
        }
        return oneDiffWordList;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("hot");
        words.add("dot");
        words.add("dog");
        words.add("lot");
        words.add("log");
        words.add("cog");
        for (List<String> list : findLadders("hit", "cog", words)) {
            System.out.println(list);
        }
    }
}
