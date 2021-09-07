package com.algorithms.leetcode.threehundred;

public class leetcode_263_IsUgly {


    public static boolean isUgly(int n) {
        if(n == 0 || n == 1){
            return false;
        }
        while (n != 1) {
            if ((n % 2) == 0) {
                n = n / 2;
            }else if ((n % 3) == 0) {
                n = n / 3;
            }else if ((n % 5) == 0) {
                n = n / 5;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 14;
        System.out.println(isUgly(n));
    }
}
