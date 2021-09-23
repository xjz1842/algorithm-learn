package com.algorithms.leetcode.eighthundred;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode_784_LetterCasePermutation {



    public static List<String> letterCasePermutation(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        Set<String> ans = new HashSet<>();

        backtrack(s,0,new StringBuilder(),ans);

        return new ArrayList<>(ans);
    }

    private static void backtrack(String s, int i,StringBuilder stringBuilder,Set<String> ans) {
        String candidate =  stringBuilder.toString();
        if(stringBuilder.length() == s.length() &&
           !ans.contains(candidate)){
             ans.add(candidate);
         }
         if(i >= s.length()){
             return;
         }
         stringBuilder.append(Character.toUpperCase(s.charAt(i)));
         backtrack(s,i+1,stringBuilder,ans);
         stringBuilder.deleteCharAt(stringBuilder.length()-1);

         stringBuilder.append(Character.toLowerCase(s.charAt(i)));
         backtrack(s,i+1,stringBuilder,ans);
         stringBuilder.deleteCharAt(stringBuilder.length()-1);
    }

    //二分掩码
    public static List<String> letterCasePermutation1(String s) {
        int b = 0;
        for (char c: s.toCharArray()){
            if (Character.isLetter(c)){
                b++;
            }
        }

        List<String> ans = new ArrayList<>();

        for(int bits = 0; bits < (1 << b); bits++){
            StringBuilder word = new StringBuilder();
            int i = 0;
            char[] chars = s.toCharArray();
            for(char letter : chars){
                if (Character.isLetter(chars[i])) {
                    if(((bits >> i++) & 1) == 1){
                        word.append(Character.toUpperCase(letter));
                    }else{
                        word.append(Character.toLowerCase(letter));
                    }
                }else{
                    word.append(letter);
                }
            }
            ans.add(word.toString());
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "12345";

        System.out.println(letterCasePermutation(s));
    }
}
