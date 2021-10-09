package com.algorithms.leetcode.fourhundred;

public class leetcode_389_FindTheDifference {

    public static char findTheDifference(String s, String t) {
        if(s.length() == 0){
            return t.charAt(0);
        }
        int len = 26;
        int[] count = new int[len];
        char[] sArray = s.toCharArray();
        for(char ch : sArray){
            count[ch-'a']++;
        }
        char[] tArray = t.toCharArray();
        for(char ch : tArray){
            int c =  --count[ch-'a'];
            if(c < 0){
                return ch;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s = "abcd", t = "abcde";
        System.out.println(findTheDifference(s,t));
    }
}
