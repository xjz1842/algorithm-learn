package com.algorithms.leetcode.fourhundred;

public class leetcode_374_GuessNumber {

    /**
     * 二分查找
     */
    public static int guessNumber(int n) {
        int l = 1;
        int r = n;
        //区间是左闭右闭区间
        while(l <= r){
            int mid = l + (r - l)/2;
            int result = guess(mid);
            if(result == 0){
                return mid;
            }else if(result == -1){
               r = mid -1;
            }else{
               l = mid + 1;
            }
        }
        return -1;
    }

    // Mock data （leetcode提供函数）
    private static int guess(int mid) {
        if(mid == 6){
            return 0;
        }else if(mid < 6){
            return 1;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }
}
