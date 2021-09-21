package com.algorithms.leetcode.fourhundred;

public class leetcode_319_BulbSwitch {

       public static int bulbSwitch(int n) {
            int count = 0; 
            for(int i = 1; i * i <= n; i++){
                count++;
            }
            return count;
       }

       public static void main(String[] args) {
           int n = 8;
           System.out.println(bulbSwitch(n));
       }
}
