package com.algorithms.leetcode.fourhundred;

public class leetcode_396_MaxRotateFunction {

    /**
     * 暴力求解 O(N * N)
     */
    public static int maxRotateFunction(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int sum;
        for (int i = 0; i < len; i++) {
            sum = 0;
            for(int delta = 0; delta < len; delta++){
                int rotateIndex = (i + delta) % len;
                sum += delta * nums[rotateIndex];
            }
            max = Math.max(sum,max);
        }
        return max;
    }

     /**
     * 递推公式  F(n)=F(n-1)+sum-n*nums[pos];
     */
    public static int maxRotateFunction1(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int mSum = 0;
        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += nums[i];
            mSum+=i*nums[i];
        }
        int pos = len-1;
        //初始化 F(0) F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。
        int max = mSum;
        for(int i = 0; i < len; i++){
            mSum = mSum - len*nums[pos]+sum;
            pos--;
            max = Math.max(max,mSum);
        }
        return max;
    }

    public static void main(String[] args) {
       int[] nums = new int[]{4, 3, 2, 6};
       System.out.println(maxRotateFunction(nums));
    }
}
