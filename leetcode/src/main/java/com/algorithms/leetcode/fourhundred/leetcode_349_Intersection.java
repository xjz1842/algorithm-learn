package com.algorithms.leetcode.fourhundred;

import java.util.HashSet;
import java.util.Set;

public class leetcode_349_Intersection {

    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return new int[]{};
        }
        Set<Integer> cache = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            cache.add(nums1[i]);
        }
        Set<Integer> ans = new HashSet<>();
        for(int i = 0; i < nums2.length; i++){
            if(cache.contains(nums2[i])){
                ans.add(nums2[i]);
            }
        }
        int size = ans.size();
        int[] res  = new  int[size];
        if( size == 0){
            return res;
        }
        int index = 0;
        for(Integer i : ans){
            res[index++] = i;
        }
        return res;
    }

    public static void main(String[] args) {
       int[] nums1 = new int[]{4,9,5};
       int[] nums2 = new int[]{9,4,9,8,4};
        for(int i : intersection(nums1,nums2)){
            System.out.println(i);
        }
    }

}
