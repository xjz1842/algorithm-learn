package com.algorithms.leetcode.threehundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_290_WordPattern {


    public static boolean wordPattern(String pattern, String s) {
        Map<Character, List<Integer>> index = new HashMap<>();

        for(int i = 0; i < pattern.toCharArray().length; i++){
            if(index.containsKey(pattern.charAt(i))){
                index.get(pattern.charAt(i)).add(i);
            }else{
                List<Integer> list =  new ArrayList<>();
                list.add(i);
                index.put(pattern.charAt(i),list);
            }
        }
        String[] arr =  s.split(" ");
        if(arr.length != pattern.toCharArray().length){
            return false;
        }
        List<Integer> keys = new ArrayList<>();
        for(List<Integer> list : index.values()){
            keys.add(list.get(0));
            if(list.size() > 1){
                int targetIndex = list.get(0);
                for(int i = 1; i < list.size(); i++){
                    if(!arr[list.get(i)].equals(arr[targetIndex])){
                        return false;
                    }
                }
            }
        }
        //check keys different
        Map<String,Boolean> exist = new HashMap<>();
        for(int i = 0; i < keys.size(); i++){
           if(exist.containsKey(arr[keys.get(i)])){
               return false;
           }else{
               exist.put(arr[keys.get(i)],Boolean.TRUE);
           }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "aaa";
        String str = "aa aa aa aa";
        System.out.println(wordPattern(pattern,str));
    }
}
