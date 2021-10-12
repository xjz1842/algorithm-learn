package com.algorithms.leetcode.fourhundred;

import java.util.Random;

public class leetcode_384_UpsetArray {

    /**
     * 原始数组
     */
     int[] original;

    /**
     * 打乱后的数组
     */
    int[] upsetArray;

    /**
     * 随机函数
     */
     Random random = new Random();

    /**
     * 打乱数据
     */
    public  leetcode_384_UpsetArray(int[] nums) {
        original = nums.clone();
        upsetArray = nums;
    }

    public int[] reset() {
        upsetArray = original.clone();
        return upsetArray;
    }

    public int[] shuffle() {
        for(int i = 0; i < upsetArray.length; i++){
            int index =  i + random.nextInt(upsetArray.length - i);
            int temp = upsetArray[index];
            upsetArray[index] = upsetArray[i];
            upsetArray[i] = temp;
        }
        return upsetArray;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        leetcode_384_UpsetArray upsetArray = new leetcode_384_UpsetArray(nums);
        for(int i : upsetArray.shuffle()){
            System.out.printf("%d \t",i);
        }
        System.out.println();
        for(int i :  upsetArray.reset()){
            System.out.printf("%d \t",i);
        }
        System.out.println();
        for(int i :  upsetArray.shuffle()){
            System.out.printf("%d \t",i);
        }
    }
}
