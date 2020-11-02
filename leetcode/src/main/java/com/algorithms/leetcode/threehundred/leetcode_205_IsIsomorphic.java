package com.algorithms.leetcode.threehundred;

import java.util.HashMap;
import java.util.Map;

public class leetcode_205_IsIsomorphic {

    public static boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> caches = new HashMap<>(s.length());
        Map<Character, Integer> cachet = new HashMap<>(t.length());
        int indexS = 0;
        int indexT = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!caches.containsKey(s.charAt(i))) {
                caches.put(s.charAt(i), i);
                indexS = i;
            } else {
                indexS = caches.get(s.charAt(i));
            }
            if (!cachet.containsKey(t.charAt(i))) {
                cachet.put(t.charAt(i), i);
                indexT = i;
            } else {
                indexT = cachet.get(t.charAt(i));
            }
            if (indexT != indexS) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "egg", t = "add";

        System.out.println(isIsomorphic(s, t));
    }
}


