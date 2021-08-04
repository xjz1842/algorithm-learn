package com.algorithms.leetcode.threehundred;

public class leetcode_211_WordDictionary {

    private class TreeNode {
        TreeNode[] children = new TreeNode[26];
        boolean end;

        public TreeNode() {
        }
    }

    private TreeNode head;

    /**
     * Initialize your data structure here.
     */
    public leetcode_211_WordDictionary() {
        head = new TreeNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TreeNode node = head;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TreeNode();
            }
            node = node.children[index];
        }
        node.end = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchHelp(word, head);
    }

    private boolean searchHelp(String word, TreeNode root) {
        char[] array = word.toCharArray();
        TreeNode cur = root;
        for (int i = 0; i < array.length; i++) {
            // 对于 . , 递归的判断所有不为空的孩子
            if ('.' == array[i]) {
                for (int j = 0; j < 26; j++) {
                    if (cur.children[j] != null) {
                        if (searchHelp(word.substring(i + 1), cur.children[j])) {
                            return true;
                        }
                    }
                }
                return false;
            }
            // 不含有当前节点
            if (cur.children[array[i] - 'a'] == null) {
                return false;
            }
            cur = cur.children[array[i] - 'a'];
        }
        // 当前节点是否为是某个单词的结束
        return cur.end;
    }

    public static void main(String[] args) {
        leetcode_211_WordDictionary head = new leetcode_211_WordDictionary();
        head.addWord("adbsa");
        System.out.println(head.search("a"));
    }
}
