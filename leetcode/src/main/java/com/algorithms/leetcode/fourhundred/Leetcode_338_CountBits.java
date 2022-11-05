package com.algorithms.leetcode.fourhundred;

public class Leetcode_338_CountBits {

    public static int[] countBits(int n) {
        int[] ans = new int[n+1];

        for (int i = 0; i <= n; i++) {
            int count = 0;
            int t = i;
            while (t > 0) {
                int leftOne = t & (-t);
                t = t - leftOne;
                count += 1;
            }
            ans[i] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
       int n = 5;
       for(int i : countBits(n)){
          System.out.println(i);
      }
    }
}
