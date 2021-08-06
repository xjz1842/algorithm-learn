package com.algorithms.leetcode.threehundred;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class leetcode_242_IsAnagram {

    public static boolean isAnagram(String s, String t) {
        if(s == null || s == null){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            Integer count = map.get(s.charAt(i));
            if(Objects.nonNull(count)){
                map.put(s.charAt(i),count+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        for(int i = 0; i < t.length(); i++){
            Integer count = map.get(t.charAt(i));
            if(Objects.isNull(count)){
                return false;
            }
            if((--count) == 0){
                map.remove(t.charAt(i));
            }else {
                map.put(t.charAt(i), count);
            }
        }
        if(map.size() != 0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }
}
