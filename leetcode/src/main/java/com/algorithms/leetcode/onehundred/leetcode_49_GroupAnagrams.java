package com.algorithms.leetcode.onehundred;

import java.util.*;

public class leetcode_49_GroupAnagrams {

    private static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        int len = strs.length;

        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < len; i++) {

            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String newStr = new String(charArr);

            if (map.containsKey(newStr)) {
                map.get(newStr).add(i);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                map.put(newStr, indexList);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<String> tempRes = new ArrayList<>();
            for (Integer i : entry.getValue()) {
                tempRes.add(strs[i]);
            }
            result.add(tempRes);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{
                "eat", "tea", "tan", "ate", "nat", "bat"
        };

        List<List<String>> result = groupAnagrams(strs);

        for (List<String> list : result) {
            System.out.println(list);
        }
    }
}
