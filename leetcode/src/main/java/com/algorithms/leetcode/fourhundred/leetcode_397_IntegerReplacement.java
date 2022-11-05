package com.algorithms.leetcode.fourhundred;

public class leetcode_397_IntegerReplacement {

    public static int integerReplacement(int n) {
       return dfs(n);
    }

    public static int dfs(long n) {
        if(n == 1){
            return 0;
        }
        //是错误转换
        if(n <= 0){
            return Integer.MAX_VALUE;
        }
        //奇数
        if((n & 1) == 1){
            return Math.min(dfs(n + 1), dfs(n - 1)) + 1;
        }else{
            //偶数
            return dfs(n/2) + 1;
        }
    }


    public static void main(String[] args) {
        int n = Integer.MAX_VALUE;
        System.out.println(integerReplacement(n));
    }
}
