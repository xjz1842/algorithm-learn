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


    public static void main(String[] args) {
        String s = "12345";

        System.out.println(letterCasePermutation(s));
    }
}
