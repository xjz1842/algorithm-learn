package com.algorithms.leetcode.secondhundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_139_WordBreak {


    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int maxLen = 0;
        int minLen = 0;
        Map<String, Boolean> cache = new HashMap<>();
        for (String ele : wordDict) {
            maxLen = Math.max(maxLen, s.length());
            minLen = Math.min(minLen, s.length());
            cache.put(ele, true);
        }
        // dp[i] 0..i之前的都是可以拆分
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            int start = i > maxLen ? i - maxLen : minLen;
            for (int j = start; j < i; j++) {
                if (i == s.length()) {
                    if (cache.containsKey(s.substring(j))) {
                        dp[i] = dp[i] || dp[j];
                    }
                }
                if (cache.containsKey(s.substring(j, i))) {
                    dp[i] = dp[i] || dp[j];
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");
        System.out.println(wordBreak(s, wordDict));
    }

}
