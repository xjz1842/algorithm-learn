package com.algorithms.leetcode.fivehundred;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_409_LongestPalindrome {

    /**
     *  贪心算法
     *  最长回文串
     * @param s 原始字符串
     */
    public static int longestPalindrome(String s) {
        if( s == null || s.length() == 0){
            return 0;
        }
        int size = 26;
        //字符记录个数
       Map<Character,Integer> cache = new HashMap<>();

        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            cache.merge(chars[i],1,(oldValue,value)->oldValue+1);
        }
        int result = 0;
        for (Map.Entry<Character,Integer> entry : cache.entrySet()) {
             if((entry.getValue() & 1) == 1){
                 result += entry.getValue() - 1;
             }else{
                 result += entry.getValue();
             }
        }
        if(result < chars.length){
            result = result + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abccccddweffasfdfsdfds";
        System.out.println(longestPalindrome(s));
    }
}
