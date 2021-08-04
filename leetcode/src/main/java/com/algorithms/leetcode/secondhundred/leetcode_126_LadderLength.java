package com.algorithms.leetcode.secondhundred;




import javafx.util.Pair;

import java.util.*;

public class leetcode_126_LadderLength {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //缓存
        Map<String, Boolean> cache = new HashMap<>();
        for (String str : wordList) {
            cache.put(str, true);
        }
        // Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));
        // Visited to make sure we don't repeat processing same word.
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            List<String> nextWordList = findOneDiffWord(node.getKey(), cache);
            int level = node.getValue();
            for (String word : nextWordList) {
                if (word.equals(endWord)) {
                    return level + 1;
                }
                if (!visited.containsKey(word)) {
                    visited.put(word, true);
                    Q.add(new Pair(word, level + 1));
                }
            }
        }
        return 0;
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
        System.out.println(ladderLength("hit", "cog", words));
    }

}
