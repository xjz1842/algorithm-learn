package com.algorithms.leetcode.secondhundred;

import java.util.*;

public class leetcode_140_WordBreak {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null) {
            return new ArrayList<>();
        }
        Map<String, Boolean> cache = new HashMap<>();
        int maxLen = 0;
        for (String ele : wordDict) {
            cache.put(ele, true);
            maxLen = Math.max(maxLen, ele.length());
        }
        List<String> result = new ArrayList<>();
        StringBuilder sbuilder = new StringBuilder();
        process(s, maxLen, s.length(), 0, sbuilder, wordDict, result);
        return result;
    }

    private static void process(String s, int wordMaxLen, int len, int index, StringBuilder stringBuilder, List<String> wordDict, List<String> result) {
        if (index > len) {
            return;
        }
        if (index == len) {
            String tmp = stringBuilder.substring(0, stringBuilder.length() - 1);
            if (!result.contains(tmp)) {
                result.add(tmp);
            }
            return;
        }
        int i = wordMaxLen >= s.length() ? s.length() : wordMaxLen;

        for (; i >= 0; i--) {
            System.out.println(i + "===" + s);
            String str = s.substring(0, i);
            if (wordDict.contains(str)) {
                stringBuilder.append(str).append(" ");
                process(s.substring(str.length()), wordMaxLen, len, index + str.length(), stringBuilder, wordDict, result);
                stringBuilder.delete(stringBuilder.length() - str.length() - 1, stringBuilder.length());
            }
        }
    }

    static class TrieNode {
        TrieNode[] childern;
        //记录当前节点是否是某个单词的结尾
        boolean end = false;

        public TrieNode() {
            childern = new TrieNode[26];
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;

            for (int i = 0; i < word.length(); i++) {
                int ch = word.charAt(i) - 'a';
                if (cur.childern[ch] == null) {
                    cur.childern[ch] = new TrieNode();
                }
                cur = cur.childern[ch];
            }
            cur.end = true;
        }

        //查找可以分割的索引位置集合
        private List<Integer> search(String word, int i) {
            List<Integer> res = new ArrayList<>();
            TrieNode cur = root;

            for (; i < word.length(); i++) {
                int num = word.charAt(i) - 'a';

                if (cur.childern[num] == null) {
                    return res;
                }
                cur = cur.childern[num];
                if (cur.end) {
                    res.add(i);
                }
            }
            return res;
        }
    }

    public List<String> wordBreak2(String s, List<String> wordDict) {
        trie = new Trie();
        for (String str : wordDict) {
            trie.insert(str);
        }

        res = new ArrayList<>();
        dfs(new StringBuilder(), s, 0);
        return res;
    }

    List<String> res;
    Trie trie;

    private void dfs(StringBuilder sb, String s, int i) {
        int len = s.length();
        if (i == len) {
            //删除最后一个空格
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        int sblen = sb.length();
        List<Integer> indexs = trie.search(s, i);
        for (int index : indexs) {
            sb.append(s.substring(i, index + 1)).append(" ");
            dfs(sb, s, index + 1);
            sb.setLength(sblen);
        }
    }

    public static List<String> wordBreak1(String s, List<String> wordDict) {
        int len = s.length();
        //将字典存放在 set 中，方便 O(1) 查找
        Set<String> set = new HashSet<>(wordDict);
        //dp[i] 代表存储 [0, i] 分割组成的所有字符串
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        List<String>[] strs = new List[len + 1];
        for (int i = 0; i <= len; i++) {
            strs[i] = new ArrayList<>();
        }

        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < i; j++) {
                String str = s.substring(j, i);
                /* 只有 [0, j) 可以分割为字典中的单词，以及 [j, i] 这个子串存在于字典中时，才能够进行拼接 */

                if (dp[j] && set.contains(str)) {
                    //进行字符串拼接，跟上面的 dog 和 前面的拼接例子一样
                    dp[i] = true;
                    if (j == 0) {
                        strs[i].add(str);
                    } else {
                        for (String ss : strs[j]) {
                            StringBuilder sb = new StringBuilder(ss).append(" ").append(str);
                            strs[i].add(sb.toString());
                        }
                    }
                }

            }
        }
        return strs[len];
    }

    private Map<String, List<String>> cache = new HashMap<>();

    public List<String> wordBreak3(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0);
    }

    private List<String> dfs(String s, List<String> wordDict, int offset) {
        if (offset == s.length()) {
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        if (cache.containsKey(s.substring(offset))) {
            return cache.get(s.substring(offset));
        }
        List<String> res = new ArrayList<>();
        for (String word : wordDict) {
            if (word.equals(s.substring(offset, Math.min(s.length(), offset + word.length())))) {
                List<String> next = dfs(s, wordDict, offset + word.length());
                for (String str : next) {
                    res.add((word + " " + str).trim());
                }
            }
        }
        cache.put(s.substring(offset), res);
        return res;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("aa");
        wordDict.add("aaa");
        wordDict.add("aaaa");
        wordDict.add("aaaaa");
        wordDict.add("aaaaaa");
        wordDict.add("aaaaaaa");
        wordDict.add("aaaaaaaa");
        List<String> list = wordBreak(s, wordDict);

        for (String str : list) {
            System.out.println(str);
        }
    }

}
