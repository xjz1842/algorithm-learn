package com.algorithms.leetcode.fourhundred;

public class leetcode_324_WiggleSort {

    /**
     *  基数排序
     */
    public static void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int len = nums.length;
        int max = 0;
        for(int i : nums){
            max = Math.max(max, nums[i]);
        }
        //建立buckets
        int[] buckets = new int[max+1];
        //记录每一个元素大小的个数
        for(int i : nums){
            buckets[nums[i]]++;
        }
        int index;
        if((len & 1) == 1){
            index = len - 1;
        }else{
            index = len - 2;
        }
        int i = 0;
        //填充偶数 从小到大 填充位置从高到低
        for(;i < buckets.length; i++){
            if(buckets[i] == 0){
                continue;
            }
            if(index >= len){
                break;
            }
            while(buckets[i] > 0 && index >= 0){
                nums[index] = i;
                buckets[i]--;
                index -= 2;
            }
        }
        //填充奇数 从大到小 填充位置从低到高
        index = 1;
        for(i = buckets.length-1; i >=0; i--){
            if(buckets[i] == 0){
                continue;
            }
            while(buckets[i] > 0 && index < len){
                nums[index] = i;
                buckets[i]--;
                index += 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,1,1,6,4};
        wiggleSort(nums);
        for(int i : nums){
            System.out.println(i);
        }
    }
}
