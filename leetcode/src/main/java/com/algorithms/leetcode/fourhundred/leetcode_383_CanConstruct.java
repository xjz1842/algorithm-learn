package com.algorithms.leetcode.fourhundred;

import java.util.HashMap;
import java.util.Map;

public class leetcode_383_CanConstruct {

    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || magazine == null){
            return false;
        }
        Map<Character,Integer> cache = new HashMap<>();
        for(Character c : magazine.toCharArray()){
            cache.merge(c,1,(oldvalue,value)-> oldvalue+1);
        }
        for(Character c : ransomNote.toCharArray()){
            Integer count = cache.get(c);
            if(count == null){
                 return false;
             }
             count = count - 1;
            if(count < 0){
                return false;
            }
            cache.put(c,count);
        }
        return true;
    }

    /**
     *  解法二，利用字符数组
     */
    public static boolean canConstruct1(String ransomNote, String magazine){
        int[] cnt = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            //统计magazine各字符个数
            cnt[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--cnt[ransomNote.charAt(i) - 'a'] < 0){
                //若消耗完小于0，说明不够用，直接返回false
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "a", magazine = "s";
        System.out.println(canConstruct(ransomNote,magazine));
    }
}
