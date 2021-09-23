package com.algorithms.leetcode.fourhundred;


public class leetcode_321_MaxNumber {

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] maxSubsequence = new int[k];

        int start = Math.max(0, k - n);
        int end = Math.min(k, m);

        for(int i = start; i <= end; i++){
            int[] subsequence1 = maxSubsequence(nums1, i);
            int[] subsequence2 = maxSubsequence(nums2, k - i);
            int[] curMaxSubsequence = merge(subsequence1, subsequence2);
            if (compare(curMaxSubsequence, 0, maxSubsequence, 0) > 0) {
                System.arraycopy(curMaxSubsequence, 0, maxSubsequence, 0, k);
            }
        }
        return maxSubsequence;
    }
    private static int[] maxSubsequence(int[] nums, int k) {
        int length = nums.length;
        int[] stack = new int[k];
        int top = -1;
        int remain = length-k;
        for(int i = 0; i < length; i++){
            int num = nums[i];
            while (top >= 0 && stack[top] < num && remain > 0) {
                top--;
                remain--;
            }
            if(top < (k-1)){
                stack[++top] = num;
            }else{
                remain--;
            }
        }
        return stack;
    }

    private static int compare(int[] maxSubsequence1, int i, int[] maxSubsequence2, int j) {
        int x = maxSubsequence1.length;
        int y = maxSubsequence2.length;

        while(i < x && j < y){
            int difference = maxSubsequence1[i] - maxSubsequence2[j];
            if(difference != 0){
                return difference;
            }
            i++;
            j++;
        }
        //x==i 或者 y == j
        return (x - i) - (y - j);
    }

    private static int[] merge(int[] subsequence1, int[] subsequence2) {
        int x = subsequence1.length;
        int y = subsequence2.length;
        if(x == 0){
            return subsequence2;
        }
        if(y == 0){
            return subsequence1;
        }
        int mergeLen = x + y;
        int[] merged = new int[mergeLen];
        int i = 0;
        int j = 0;
        for(int k = 0; k < mergeLen; k++){
            if(compare(subsequence1, i, subsequence2, j) > 0){
               merged[k] = subsequence1[i++];
            }else{
                merged[k] = subsequence2[j++];
            }
        }
        return merged;
    }


    public static void main(String[] args) {
       int[]  nums1 = new int[]{6,7};
       int[]  nums2 = new int[]{6,0,4};
       int  k = 5;
      for (int i : maxNumber(nums1, nums2, k)) {
          System.out.println(i);
      }
    }
}
