package com.algorithms.leetcode.fivehundred;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_448_FindDisappearedNumbers {

    /**
     *  原地交换
     */
    public  static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
         if(nums == null || nums.length == 0){
             return ans;
         }
         for(int i = 0; i < nums.length; i++){
             // 交换到正确的位置
             while(nums[i] != (i+1)){
                 if(nums[nums[i]-1] == nums[i]) {
                        break;
                 }
                 //交换
                 int temp = nums[nums[i]-1];
                 nums[nums[i]-1] = nums[i];
                 nums[i] = temp;
             }
         }

        //找到位置不正确的数 即为答案
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != (i+1)){
                ans.add(i+1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//      int[] nums = new int[]{4,3,2,7,8,2,3,1};
        int[] nums = new int[]{1,1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
