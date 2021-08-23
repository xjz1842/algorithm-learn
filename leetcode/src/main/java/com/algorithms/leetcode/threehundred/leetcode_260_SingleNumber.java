package com.algorithms.leetcode.threehundred;


import java.util.HashMap;
import java.util.Map;

public class leetcode_260_SingleNumber {

    public static int[] singleNumber(int[] nums) {
        Map<Integer,Integer> cache = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
           Integer old =  cache.put(nums[i],cache.getOrDefault(nums[i],0)+1);
            if(old != null && old == 1){
                cache.remove(nums[i]);
            }
        }
        int[] ans = new int[2];
        int idx = 0;
        for(Integer i : cache.keySet()){
            ans[idx++] = i;
        }
        return ans;
    }
    //分组异或
    public static int[] singleNumber1(int[] nums) {
        int cand = 0;
        for(int num : nums){
            cand ^= num;
        }

        //找到
        int judge = 1;
        while ((cand & judge) == 0){
            judge = judge << 1;
        }

        int a = 0;
        int b = 0;
        for(int num : nums){
            if( (num & judge) == 0){
                a ^= num;
            }else{
                b ^= num;
            }
        }
        return new int[]{a,b};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0};
        for(int i : singleNumber(nums)){
            System.out.println(i);
        }
        for(int i : singleNumber1(nums)){
            System.out.println(i);
        }
    }
}
