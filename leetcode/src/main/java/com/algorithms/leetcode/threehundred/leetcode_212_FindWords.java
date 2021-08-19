package com.algorithms.leetcode.threehundred;

import java.util.*;

public class leetcode_212_FindWords {

    //前缀树
    public static class TrieNode {
        //子树
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        String word = null;

        public TrieNode() {
        }
    }

    public static void clearVisited(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static TrieNode init(String[] words) {
        // Construct the Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;

            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;  // store words in Trie
        }
        return root;
    }

    public static List<String> findWords(char[][] board, String[] words) {
        if (board == null || board[0].length == 0) {
            return new ArrayList<>();
        }
        if (words == null || words.length == 0) {
            return new ArrayList<>();
        }
        int rows = board.length;
        int cols = board[0].length;

        //上 下 左 右方向移动
        int[][] dir = new int[][]{
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        TrieNode root = init(words);
        //结果
        Set<String> ans = new HashSet<>();
        //记录是否访问
        boolean[][] visited = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                //是否包含前缀
                if (root.children.containsKey(board[r][c])) {
                    clearVisited(visited);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(board[r][c]);
                    visited[r][c] = true;
                    TrieNode nextNode = root.children.get(board[r][c]);
                    if (nextNode.word != null) {
                        ans.add(nextNode.word);
                    }
                    dfs(board, visited, dir, r, c, stringBuilder, nextNode, ans);
                }
            }
        }
        return new ArrayList<>(ans);
    }

    private static void dfs(char[][] board, boolean[][] visited, int[][] dir, int r, int c, StringBuilder candiate, TrieNode parent, Set<String> ans) {
        if (parent == null) {
            return;
        }
        for (int d = 0; d < dir.length; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if (!(nr < 0 || nc < 0 || nr >= board.length || nc >= board[0].length) && !visited[nr][nc]) {
                StringBuilder newCandidate = new StringBuilder(candiate.toString());
                newCandidate.append(board[nr][nc]);
                visited[nr][nc] = true;
                TrieNode curNode = parent.children.get(board[nr][nc]);
                //是否包含当前节点
                if (curNode != null) {
                    if (curNode.word != null) {
                        ans.add(curNode.word);
                    }
                    dfs(board, visited, dir, nr, nc, newCandidate, curNode, ans);
                    visited[nr][nc] = false;
                    newCandidate.deleteCharAt(candiate.length() - 1);
                } else {
                    visited[nr][nc] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
//        char[][] board = new char[][]{
//                {'o', 'a', 'a', 'n'},
//                {'e', 't', 'a', 'e'},
//                {'i', 'h', 'k', 'r'},
//                {'i', 'f', 'l', 'v'}};
//              String[] words = new String[]{"oath", "pea", "eat", "rain"};;

        char[][] board = new char[][]{
                {'a', 'b', 'c', 'e'},
                {'x', 'x', 'c', 'd'},
                {'x', 'x', 'b', 'a'}};
        String[] words = new String[]{"abc", "abcd"};
        System.out.println(findWords(board, words));
    }
}
