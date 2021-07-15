package com.algorithms.interview.binarysearch;

public class SearchRange {

    //下边界 区间 [m r)
    static int lowerBound(int[] A, int n, long target) {
        int l = 0, r = n;
        while (l < r) {
            final int m = l + ((r - l) >> 1);
            if (A[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    //上边界  区间 (m, r]
    static int upperBound(int[] A, int n, long target) {
        int l = 0, r = n;
        while (l < r) {
            final int m = l + ((r - l) >> 1);
            if (A[m] <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    public static int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
       int low =  lowerBound(nums,nums.length,target);
       int upper = upperBound(nums,nums.length,target);

       if(low == upper){
           return new int[]{-1, -1};
       }
       return new int[]{low,upper-1};
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{5,7,7,8,8,1};
//        int target = 8;

        int[] arr = new int[]{1};
        int target = 1;
        for(int i : searchRange(arr,target)){
            System.out.println(i);
        }
    }

}
