package com.algorithms.leetcode.fourhundred;


import java.util.LinkedHashMap;
import java.util.Map;

public class leetcode_387_FirstUniqChar {

     static class Node{
        int index;
        int count;

         public Node(int index, int count) {
             this.index = index;
             this.count = count;
         }
     }

    public static int firstUniqChar(String s) {
        if(s == null){
            return -1;
        }
        Map<Character,Node> chars = new LinkedHashMap<>();
        char[] charArr = s.toCharArray();
        for(int i = 0;i < charArr.length; i++){
            chars.merge(charArr[i],new Node(i,1),(oldValue,value)->{
               oldValue.count =  oldValue.count+1;
               return oldValue;
            });
        }
        for(Map.Entry<Character,Node> entry : chars.entrySet()){
            if(entry.getValue() != null && entry.getValue().count == 1){
                return entry.getValue().index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }
}
